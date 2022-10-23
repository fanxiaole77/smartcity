package com.example.myapplication.ui.mine.oreder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityOrederBinding

class OrederActivity : BaseActivity() {

    private lateinit var viewModel: OrderViewModel
    private val binding:ActivityOrederBinding by lazy {
        ActivityOrederBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        binding.lifecycleOwner = this
        val adapter = OrderAdapter()

        binding.lifecycleOwner = this
        binding.rgSelected.setOnCheckedChangeListener { _, id ->
            if (id == R.id.rb_pay) {
                lifecycleScope.launchWhenCreated {
                    val list = viewModel.getAllOrders(true)

                    Log.d(TAG, list.size.toString())
                    if (list.size == 0) {
                        binding.rvOrder.visibility = View.GONE
                        binding.noOrders.visibility = View.VISIBLE
                    }
                    adapter.setData(list)
                    binding.rvOrder.layoutManager = LinearLayoutManager(this@OrederActivity)
                    adapter.notifyDataSetChanged()
                    binding.rvOrder.adapter = adapter
                }
            } else if (id == R.id.rb_no_pay) {
                lifecycleScope.launchWhenResumed {
                    val list = viewModel.getAllOrders(false)
                    Log.d(TAG, list.size.toString())
                    if (list.size == 0) {
                        binding.rvOrder.visibility = View.GONE
                        binding.noOrders.visibility = View.VISIBLE
                    }
                    adapter.setData(list)
                    binding.rvOrder.layoutManager = LinearLayoutManager(this@OrederActivity)
                    adapter.notifyDataSetChanged()
                    binding.rvOrder.adapter = adapter
                }
            }
        }
    }
    companion object {

        const val TAG = "OrderActivity"
        fun start(context: Context) {
            context.startActivity(Intent(context, OrederActivity::class.java))
        }
    }
}