package com.example.myapplication.ui.activity.works.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentAccountBinding
import com.example.myapplication.extensions.start
import com.example.myapplication.ui.activity.works.me.ChaxunActivity
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : BaseFragmnet() {

    private lateinit var binding:FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_account,container,false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        chaxun.setOnClickListener {
            val intent = Intent(getActivity(),ChaxunActivity::class.java)
            startActivity(intent)
        }
    }



}