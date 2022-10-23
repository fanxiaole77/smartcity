package com.example.myapplication.ui.activity.house

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemHouseInfoBinding
import com.example.myapplication.extensions.start
import com.example.myapplication.network.HouseInfoEntity
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class LookHouseAdapter(val context: Context):RecyclerView.Adapter<DataBingdingViewHolder>() {

    private var list = ArrayList<HouseInfoEntity.Row>()

    fun setData(list:ArrayList<HouseInfoEntity.Row>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding =
            ItemHouseInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemHouseInfoBinding
        binding.data = list[position]
        holder.itemView.setOnClickListener {
            val houseId = list[position].id
            LookHouseViewModel.houseEntity = list[position]
            start<HousecontentActivity>(context) {
                putExtra("houseId", houseId)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}