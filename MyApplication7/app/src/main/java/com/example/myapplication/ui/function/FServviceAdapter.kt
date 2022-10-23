package com.example.myapplication.ui.function

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemServiceBinding
import com.example.myapplication.extensions.start
import com.example.myapplication.network.ServiceEntity
import com.example.myapplication.ui.activity.subway.CitySubwayActivity
import com.example.myapplication.ui.activity.works.WorkActivity
import com.example.myapplication.ui.activity.zheixiantu.ZhexianActivity
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class FServviceAdapter(private val context: Context):RecyclerView.Adapter<DataBingdingViewHolder>() {

    private var list = ArrayList<ServiceEntity.Row>()

    fun setList(list: ArrayList<ServiceEntity.Row>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemServiceBinding.inflate(LayoutInflater.from(context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemServiceBinding
        binding.data = list[position]
        val data = list[position]
        holder.itemView.setOnClickListener {
            when(data.serviceName){
                "城市地铁" -> {
                    start<CitySubwayActivity>(context)
                }
                "数据分析" -> {
                    start<ZhexianActivity>(context)
                }
                else -> return@setOnClickListener
            }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

}