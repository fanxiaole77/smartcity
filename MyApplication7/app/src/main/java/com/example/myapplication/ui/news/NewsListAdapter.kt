package com.example.myapplication.ui.news

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemNewsBinding
import com.example.myapplication.network.NewsEntity
import com.example.myapplication.ui.hoem.DataBingdingViewHolder

class NewsListAdapter(private val context: Context) :
    RecyclerView.Adapter<DataBingdingViewHolder>() {
    private var list = ArrayList<NewsEntity.Row>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<NewsEntity.Row>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBingdingViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(context), parent, false)
        return DataBingdingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBingdingViewHolder, position: Int) {
        val binding = holder.binding as ItemNewsBinding
        binding.data = list[position]
        holder.itemView.setOnClickListener {
            NewsViewModel.news = list[position]
            NewsContentActivity.start(context)
        }

    }

    override fun getItemCount(): Int = list.size
}