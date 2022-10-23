package com.example.myapplication.ui.mine.oreder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemOrderBinding
import com.example.myapplication.network.OrderEntity
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class OrderAdapter:RecyclerView.Adapter<DataBingdingViewHolder>() {

    private var list = ArrayList<OrderEntity.Row>()

    fun setData(list: ArrayList<OrderEntity.Row>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
      val binding = holder.binding as ItemOrderBinding
        binding.data = list[position]
    }

    override fun getItemCount(): Int {
       return list.size
    }

}