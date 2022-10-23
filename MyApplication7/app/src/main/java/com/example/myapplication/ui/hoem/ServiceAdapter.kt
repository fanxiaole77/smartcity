package com.example.myapplication.ui.hoem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemServiceBinding
import com.example.myapplication.extensions.start
import com.example.myapplication.network.ServiceEntity
import com.example.myapplication.ui.activity.house.LookHouseActivity

class ServiceAdapter(private val context: Context) :
    RecyclerView.Adapter<DataBingdingViewHolder>() {
    private var list = ArrayList<ServiceEntity.Row>()

    fun setList(list:ArrayList<ServiceEntity.Row>){
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

                "更多服务" -> {
                    val navController = Navigation.findNavController(it)
                    navController.navigate(R.id.action_navigation_home_to_navigation_function)
                }
                else -> return@setOnClickListener
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}