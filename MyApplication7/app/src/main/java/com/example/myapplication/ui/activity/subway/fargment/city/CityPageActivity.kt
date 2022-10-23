package com.example.myapplication.ui.activity.subway.fargment.city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityCityPageBinding
import com.example.myapplication.network.LineContentEntity

class CityPageActivity : BaseActivity() {

    private val binding:ActivityCityPageBinding by lazy {
        ActivityCityPageBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: CitySubwayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CitySubwayViewModel::class.java)
        val id = intent.getIntExtra("lineId", 0)
        val currentName = intent.getStringExtra("currentName")
        binding.data = viewModel
        binding.lifecycleOwner = this

        lifecycleScope.launchWhenStarted {
            val entity = viewModel.getLineContent(id)
            viewModel.apply {
                firstName.value = entity.data.first
                endName.value = entity.data.end
                km.value = entity.data.km.toString()
                time.value = "${entity.data.startTime} -${entity.data.endTime}"
            }
            val array = ArrayList<LineContentEntity.Data.MetroStep>()

            for (e in entity.data.metroStepList) {
                array.add(e)
            }
            val adapter = LineContentAdapter(currentName!!)
            adapter.setData(array)
            binding.recyclerView.layoutManager =
                LinearLayoutManager(this@CityPageActivity, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerView.adapter = adapter

        }
    }
}