package com.example.myapplication.ui.mine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.base.ActivityCollector
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentMineBinding
import com.example.myapplication.extensions.edit
import com.example.myapplication.extensions.sharedPreferences
import com.example.myapplication.ui.mine.changePassword.ChangePassswordActivity
import com.example.myapplication.ui.mine.feedback.FeedbackActivity
import com.example.myapplication.ui.mine.oreder.OrederActivity
import kotlinx.coroutines.launch

class MineFragment : BaseFragmnet() {
    companion object {
        const val TAG = " MineFragment"
        fun newInstance() = MineFragment()
    }
    private val binding:FragmentMineBinding by lazy {
        FragmentMineBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MineViewModel::class.java)
        binding.data =viewModel
        binding.lifecycleOwner = this
        lifecycleScope.launch {
            val user = viewModel.getUserInfo()
            if (user.code != 200){
                binding.btnLogout.visibility = View.GONE
                binding.btnLogin.visibility = View.VISIBLE
            } else {
                binding.btnLogout.visibility = View.VISIBLE
                binding.btnLogin.visibility = View.GONE
            }
            viewModel.userInfo.value = user
        }
        binding.personalSettings.setOnClickListener {
            PersonalActivity.start(this.requireContext())
        }
        binding.myOrder.setOnClickListener {
            OrederActivity.start(this.requireContext())
        }
        binding.changePassword.setOnClickListener {
            ChangePassswordActivity.start(this.requireContext())
        }
        binding.feedback.setOnClickListener {
            FeedbackActivity.start(this.requireContext())
        }
        binding.btnLogout.setOnClickListener{
            viewModel.userInfo.value = null
            sharedPreferences.edit {
                putString("token","")
                putBoolean("LoginFailure",true)
            }
            binding.btnLogout.visibility = View.GONE
            binding.btnLogin.visibility = View.VISIBLE
        }


    }

}