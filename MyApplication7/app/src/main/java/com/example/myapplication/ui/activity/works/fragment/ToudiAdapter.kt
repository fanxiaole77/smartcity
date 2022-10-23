package com.example.myapplication.ui.activity.works.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemToudiBinding
import com.example.myapplication.network.Toudi
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class ToudiAdapter(private val context: Context) : RecyclerView.Adapter<DataBingdingViewHolder>() {

    private var list = ArrayList<Toudi.Row>()

    fun  setList(list: ArrayList<Toudi.Row>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemToudiBinding.inflate(LayoutInflater.from(context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemToudiBinding
        binding.data = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}