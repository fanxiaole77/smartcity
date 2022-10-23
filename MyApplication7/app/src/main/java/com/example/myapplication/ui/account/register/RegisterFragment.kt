package com.example.myapplication.ui.account.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentRegisterBinding
import com.example.myapplication.extensions.showToast

class RegisterFragment : BaseFragmnet() {
    private lateinit var binding:FragmentRegisterBinding

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_register,container,false)
        return return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding.rdata=viewModel
        binding.lifecycleOwner= getActivity()


        binding.tvToLogin.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                val message = viewModel.register()

                if (message.code == 200){
                    message.msg.showToast()
                }else{
                    message.msg.showToast()
                }
            }
        }
    }

}