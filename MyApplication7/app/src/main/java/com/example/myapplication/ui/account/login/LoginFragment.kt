package com.example.myapplication.ui.account.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.extensions.edit
import com.example.myapplication.extensions.sharedPreferences
import com.example.myapplication.extensions.showToast

class LoginFragment : BaseFragmnet() {
    private lateinit var binding: FragmentLoginBinding

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login,
            container,
            false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = getActivity()
        binding.tvRegisterAccount.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                val message = viewModel.login()
//                val userid = viewModel.user()

                if (message.code == 200) {
                    message.msg.showToast()
                    // SmartCityApplication.TOKEN = message.token
                    sharedPreferences.edit {
                        putString("token", message.token)
                    }
//                    sharedPreferences.edit {
//                        putString("userid", userid)
//                    }

                    MainActivity.start(this@LoginFragment.requireContext())
                } else {
                    message.msg.showToast()
                }

            }
        }
    }
}