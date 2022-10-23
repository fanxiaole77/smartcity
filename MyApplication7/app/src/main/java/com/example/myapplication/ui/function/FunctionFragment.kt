package com.example.myapplication.ui.function

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentFunctionBinding
import com.example.myapplication.ui.hoem.ServiceAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FunctionFragment : BaseFragmnet() {

    companion object{
        fun newsInstance() = FunctionFragment()
    }
    private lateinit var binding:FragmentFunctionBinding
    private lateinit var viewModel: FunctionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_function,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FunctionViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = getActivity()


        viewModel.viewModelScope.launch(Dispatchers.Main){
            val  service = viewModel.getServer()
            val adapter = FServviceAdapter(this@FunctionFragment.requireContext())
            adapter.setList(service)
            binding.rvRecommendedFunction.apply {
                layoutManager = GridLayoutManager(this@FunctionFragment.requireActivity(), 5)
                setAdapter(adapter)
            }
        }
    }
}