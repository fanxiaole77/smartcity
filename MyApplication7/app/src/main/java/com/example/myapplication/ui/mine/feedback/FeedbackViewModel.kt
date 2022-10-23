package com.example.myapplication.ui.mine.feedback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.Feed
import com.example.myapplication.network.Message
import com.example.myapplication.ui.mine.MineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedbackViewModel : ViewModel() {

    private val mineRepository = MineRepository()

    val editFeedback = MutableLiveData<String>()

    val textEditNumber = MutableLiveData<String>()

    val feedcontent = MutableLiveData<String>()

    private suspend fun feed(content: String): Message {
        return withContext(Dispatchers.IO) {
            val message = mineRepository.feedback(Feed(content))
            message
        }
    }

    fun submit() {
        viewModelScope.launch {
            val content = feedcontent.value!!
            val message = feed(content)
            if (message.code == 200) {
                "反馈成功".showToast()
                feedcontent.value = ""
            }
        }
    }
}