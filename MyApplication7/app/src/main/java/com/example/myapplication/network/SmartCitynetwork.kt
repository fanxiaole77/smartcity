package com.example.myapplication.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SmartCitynetwork {

    private val smartCityService = ServiceCreator.create(SmartCityApi::class.java)

    suspend fun getLogin(username: String, password: String) =
        smartCityService.getLogin(LoginUser(username = username, password = password)).await()

    suspend fun getRegister(
        username: String,
        nickname: String,
        phonenumber: String,
        password: String,
    ) = smartCityService.getRegister(
        RegisterUser(
            userName = username,
            nickName = nickname,
            phonenumber = phonenumber,
            password = password
        )
    ).await()

    suspend fun getHomeBanner() = smartCityService.getHomeBanner().await()

    suspend fun getNewsList() = smartCityService.getNewsList().await()

    suspend fun getServer() = smartCityService.getService().await()

    suspend fun getNewsList(type: Int) = smartCityService.getNewsList(type).await()//新闻列表

    suspend fun getNewsClassify() = smartCityService.getNewsClassify().await()//新闻分类

    suspend fun getNewsComments(newsId: Int) = smartCityService.getNewsComments(newsId).await()//新闻评论

    suspend fun pressComments(bean: CommentsBean) =
        smartCityService.pressComments(bean = bean).await()//发布评论

    suspend fun getLookHouse() = smartCityService.getLookHomeBanner().await()//获取找房子轮播图

    suspend fun getHouse() = smartCityService.getHouse().await()

    suspend fun getHouseershou(houseType: String) = smartCityService.getHouseershou().await()

    suspend fun getHoueloupan(houseType: String) = smartCityService.getHouseloupan().await()

    suspend fun getHouezhongjie(houseType: String) = smartCityService.getHousezhongjie().await()

    suspend fun getHouseZufang(houseType: String) = smartCityService.getHousezufang().await()

    suspend fun getWorkBanner() = smartCityService.getWorkBanner().await()

    suspend fun getWork() = smartCityService.getWork().await()

    suspend fun getWorknName(name:String) = smartCityService.getWorkName1(name).await()

    suspend fun getToudi() = smartCityService.getToudi().await()

    suspend fun getUesrEntity() = smartCityService.getUserEntity().await()

    suspend fun getJob() = smartCityService.getJob().await()

    suspend fun getWorkInfo(name: String) = smartCityService.getWorkInfo(name).await()

    suspend fun changePersonal(bean: PersonalBean) =
        smartCityService.changePersonal(bean = bean).await()

    suspend fun getUserInfo() = smartCityService.getUserInfo().await()

    suspend fun getAllOrders(orderStatus: Boolean) =
        smartCityService.getAllOrders(orderStatus = orderStatus).await()

    suspend fun changePwd(bean: PasswordBean) = smartCityService.changePwd(bean = bean).await()

    suspend fun feedback(bean: Feed) = smartCityService.feedback(bean = bean).await()

    suspend fun getLineInfo(currentName: String)=smartCityService.getLineInfo(currentName).await()

    suspend fun getLineContent(id :Int)=smartCityService.getLineContent(id).await()

    suspend fun getLine()=smartCityService.getLine().await()


    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                    t.message?.let { Log.d("SmartCityNetwork", it) }
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {

        // 单例创建SmartCityNetwork
        private var network: SmartCitynetwork? = null

        fun getInstance(): SmartCitynetwork {
            if (network == null) {
                synchronized(SmartCitynetwork::class.java) {
                    if (network == null) {
                        network = SmartCitynetwork()
                    }
                }
            }
            return network!!
        }
    }
}