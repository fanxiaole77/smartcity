package com.example.myapplication.ui.mine.oreder

import androidx.lifecycle.ViewModel
import com.example.myapplication.network.OrderEntity
import com.example.myapplication.ui.mine.MineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrderViewModel:ViewModel() {

    private val mineRepository = MineRepository()

    suspend fun getAllOrders(orderStatus: Boolean):ArrayList<OrderEntity.Row>{
        return withContext(Dispatchers.IO){
            val array = ArrayList<OrderEntity.Row>()

            val entity = mineRepository.getAllOrders(orderStatus)

            entity.rows.forEach {
                array.add(it)
            }
            array
        }
    }

}