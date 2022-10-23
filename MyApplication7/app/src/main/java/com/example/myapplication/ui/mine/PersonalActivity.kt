package com.example.myapplication.ui.mine

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityPersonalBinding
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.PersonalBean
import com.example.myapplication.ui.account.AccountActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PersonalActivity : BaseActivity() {

    private lateinit var viewModel: MineViewModel
    private val binding:ActivityPersonalBinding by lazy {
        ActivityPersonalBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        var sexSelected = "0"
        viewModel = ViewModelProvider(this).get(MineViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = this
        lifecycleScope.launchWhenCreated {
            viewModel.userInfo.value = viewModel.getUserInfo()

            viewModel.userInfo.value!!.user.let {
                viewModel.avatar.value = it.avatar
                viewModel.nickname.value = it.nickName
                viewModel.phoneNumber.value = it.phonenumber
                viewModel.idNumber.value = it.idCard
            }
            val sex = viewModel.userInfo.value!!.user.sex
            if (sex == "0"){
                binding.rbMan.isChecked = true
            }else if (sex == "1"){
                binding.rbWoman.isChecked = true
            }
        }
        binding.rgSex.setOnCheckedChangeListener { _, id ->
            if (id == R.id.rb_man) {
                sexSelected = "0"
            } else if (id == R.id.rb_woman) {
                sexSelected = "1"
            }
        }
        binding.btnSave.setOnClickListener {
            viewModel.viewModelScope.launch(Dispatchers.Main){
                "Sex:$sexSelected".showToast()
                val message = viewModel.changUserInfo(
                    PersonalBean(
                        idCard = viewModel.idNumber.value!!,
                        nickName = viewModel.nickname.value!!,
                        phonenumber = viewModel.phoneNumber.value!!,
                        sex = sexSelected,
                    )
                )
                if (message.code == 200){
                    "修改成功".showToast()
                    delay(1000)
                    AccountActivity.start(this@PersonalActivity)
                }else{

                }
            }
        }

    }
    companion object {

        const val TAG = "PersonalActivity"
        fun start(context: Context) {
            context.startActivity(Intent(context, PersonalActivity::class.java))
        }
    }
}