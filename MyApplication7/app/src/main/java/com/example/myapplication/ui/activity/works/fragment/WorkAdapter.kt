package com.example.myapplication.ui.activity.works.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemWorkBinding
import com.example.myapplication.extensions.start
import com.example.myapplication.network.Recruitment
import com.example.myapplication.ui.activity.works.WorkContentActivity
import com.example.myapplication.ui.activity.works.WorkViewModel
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class WorkAdapter(private val context: Context):RecyclerView.Adapter<DataBingdingViewHolder>() {


    private var list = ArrayList<Recruitment.Row>()

    fun setList(list: ArrayList<Recruitment.Row>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemWorkBinding.inflate(LayoutInflater.from(context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemWorkBinding
        binding.data = list[position]
        holder.itemView.setOnClickListener {
            WorkViewModel.Recruitment = list[position]
            WorkContentActivity.start(context)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}