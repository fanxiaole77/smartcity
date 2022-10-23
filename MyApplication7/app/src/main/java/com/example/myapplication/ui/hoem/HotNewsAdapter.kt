package com.example.myapplication.ui.hoem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemThemeBinding
import com.example.myapplication.network.NewsEntity

class HotNewsAdapter(private val context: Context):RecyclerView.Adapter<DataBingdingViewHolder>() {

    private var list = ArrayList<NewsEntity.Row>()

    fun setList(list:ArrayList<NewsEntity.Row>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemThemeBinding.inflate(LayoutInflater.from(context),parent,false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemThemeBinding
        holder.itemView.setOnClickListener {
            val navController = Navigation.findNavController(it)
//            NewsViewModel.news = list[position]
            navController.navigate(R.id.action_navigation_home_to_navigation_news_content)
        }
        binding.data = list[position]
    }

    override fun getItemCount(): Int  = if (list.size > 4){
        4
    }else{
        list.size
    }
}