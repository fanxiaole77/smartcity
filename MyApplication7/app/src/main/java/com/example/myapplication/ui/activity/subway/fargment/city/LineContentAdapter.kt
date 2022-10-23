package com.example.myapplication.ui.activity.subway.fargment.city

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLineContentBinding
import com.example.myapplication.databinding.ItemLineInfoBinding
import com.example.myapplication.network.LineContentEntity
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class LineContentAdapter(val currentName: String) : RecyclerView.Adapter<DataBingdingViewHolder>(){

    private var list = ArrayList<LineContentEntity.Data.MetroStep>()

    fun setData(list: ArrayList<LineContentEntity.Data.MetroStep>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding =  ItemLineContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
       val binding = holder.binding as ItemLineContentBinding
        binding.data = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }


}