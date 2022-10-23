package com.example.myapplication.ui.activity.works

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.*
import com.example.myapplication.ui.activity.works.fragment.WorkFragment
import kotlinx.android.synthetic.main.fragment_woek.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkViewModel:ViewModel() {

    private val workRepository = WorkRepository()

    var name = MutableLiveData<String>()

    var arrayList = mutableListOf<String>()

    var lob = MutableLiveData<Jon.Row>()

    var work = MutableLiveData<Recruitment.Row>()
    init {
        work.value = Recruitment
    }

    suspend fun getWorkBanner():ArrayList<String>{
        return withContext(Dispatchers.IO) {
            // 这里全是IO线程
            val arrayList = ArrayList<String>()
            val baseBrl = ServiceCreator.BASE_URL
            val bannerPage = workRepository.getWorkBanner()
            for (i in bannerPage.rows.indices) {
                arrayList.add(baseBrl + bannerPage.rows[i].advImg)
            }

            arrayList
        }
    }

    suspend fun getWork():ArrayList<Recruitment.Row>{
        return withContext(Dispatchers.IO){
            val work = workRepository.getWork()
            val array = arrayListOf<Recruitment.Row>()
            for (e in work.rows){
                array.add(e)
            }
            array
        }
    }

    suspend fun getToudi():ArrayList<Toudi.Row>{
        return withContext(Dispatchers.IO){
            val array = arrayListOf<Toudi.Row>()
            val hospitals = workRepository.getToudi()
            Log.d("AZX","$hospitals")
            for (e in hospitals.rows){
                array.add(e)
            }
            array
        }
    }
    suspend fun getWorkName(name:String = "软件开发"):ArrayList<Recruitment.Row>{
        return withContext(Dispatchers.IO){
            val workname = workRepository.getWorkName(name)
            val array = arrayListOf<Recruitment.Row>()
            for (e in workname.rows){
                array.add(e)

            }
            array
        }
    }

    suspend fun getWorkInfo(name:String = ""):Recruitment?{
        return withContext(Dispatchers.IO){
            val info = workRepository.getWorkInfo(name)
            if (info.code != 200 || info.rows.isEmpty()){
                "没有输入".showToast()
                return@withContext null
            }
            info
        }
    }

    companion object {
        @JvmStatic
        var Recruitment: Recruitment.Row? = null
    }


}