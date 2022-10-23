package com.example.myapplication.ui.activity.subway.fargment.city

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLineInfoBinding
import com.example.myapplication.extensions.showToast
import com.example.myapplication.extensions.start
import com.example.myapplication.network.LineInfoEntity
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class LineInfoAdapter(val context: Context):RecyclerView.Adapter<DataBingdingViewHolder>() {

    private var list = ArrayList<LineInfoEntity.Data>()

    fun setData(list: ArrayList<LineInfoEntity.Data>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemLineInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemLineInfoBinding
        binding.data = list[position]
       holder.itemView.setOnClickListener {
           list[position].currentName.showToast()
           start<CityPageActivity>(context){
               putExtra("lineId",list[position].lineId)
               putExtra("currentName",list[position].currentName)
           }
       }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}