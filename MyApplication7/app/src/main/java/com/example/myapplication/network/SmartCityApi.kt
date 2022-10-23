package com.example.myapplication.network

import com.example.myapplication.SmartCityApplication
import retrofit2.Call
import retrofit2.http.*

interface SmartCityApi {

    @POST("prod-api/api/login")  // 登录
    fun getLogin(@Body user: LoginUser): Call<Message>
    //      suspend fun getLogin(@Body user: LoginUser): Call<Message>
    // 如果加上suspend 关键字的话直接返回Message，

    @POST("prod-api/api/register")  // 注册
    fun getRegister(@Body user: RegisterUser): Call<Message>

    @GET("/prod-api/api/rotation/list") //首页轮播
    fun getHomeBanner():Call<BannerEntity>
    @GET("/prod-api/press/press/list")    // 获取新闻列表，hot，是否为热点新闻，值为Y or N
    fun getNewsList(@Query("hot") hot: String = "N"): Call<NewsEntity>
    @GET("/prod-api/api/service/list")  // 获取服务
    fun getService(): Call<ServiceEntity>
    @GET("/prod-api/press/category/list") // 获取新闻分类
    fun getNewsClassify(): Call<NewsClassifyEntity>
    @GET("/prod-api/press/press/list")    // 获取新闻列表，根据新闻分类
    fun getNewsList(@Query("type") type: Int): Call<NewsEntity>
    @GET("/prod-api/press/comments/list") // 获取新闻评论列表， newsId：新闻ID
    fun getNewsComments(@Query("newsId") newsId: Int): Call<NewsCommentsEntity>
    @POST("/prod-api/press/pressComment") // 添加评论
    fun pressComments(
        @Header("Authorization") header: String = SmartCityApplication.TOKEN,
        @Body bean: CommentsBean,
    ): Call<Message>

    @GET("/prod-api/api/takeout/rotation/list") //首页轮播
    fun getLookHomeBanner():Call<LookHouseBanner>
    @GET("/prod-api/api/house/housing/list")  // 找房子
    fun getHouse(): Call<HouseInfoEntity>

    @GET("/prod-api/api/house/housing/list")
    fun getHouseershou(@Query("houseType") houseType: String = "二手" ):Call<HouseInfoEntity>
    @GET("/prod-api/api/house/housing/list")
    fun getHouseloupan(@Query("houseType") houseType: String = "楼盘" ):Call<HouseInfoEntity>
    @GET("/prod-api/api/house/housing/list")
    fun getHousezhongjie(@Query("houseType") houseType: String = "中介" ):Call<HouseInfoEntity>
    @GET("/prod-api/api/house/housing/list")
    fun getHousezufang(@Query("houseType") houseType: String = "租房" ):Call<HouseInfoEntity>

    @GET("/prod-api/api/metro/rotation/list")
    fun getWorkBanner():Call<WorkBanner>        //找工作轮播图

    @GET("/prod-api/api/job/post/list")
        fun getWork():Call<Recruitment>          //招聘信息

    @GET("/prod-api/api/job/post/list")
    fun getWorkName1(@Query("name") name:String = "软件开发"):Call<Recruitment>          //招聘信息

    @GET("/prod-api/api/job/deliver/list")
    fun getToudi(@Header("Authorization") header:String = SmartCityApplication.TOKEN):Call<Toudi>

    @GET("/prod-api/api/common/user/getInfo")
    fun getUserEntity(@Header("Authorization") header: String = SmartCityApplication.TOKEN):Call<UserEntity>

    @GET("/prod-api/api/job/resume/queryResumeByUserId")
    fun getJob(@Header("Authorization") header: String = SmartCityApplication.TOKEN
    ,@Path("userId") userId:Int = 1112235):Call<Jon>

    @GET("/prod-api/api/job/post/list")
    fun getWorkInfo(@Query("name") name: String = ""):Call<Recruitment>

    @PUT("/prod-api/api/common/user")   //更改个人信息
    fun changePersonal(
        @Header("Authorization") header: String = SmartCityApplication.TOKEN,
        @Body bean: PersonalBean,
    ): Call<Message>

    @GET("prod-api/api/common/user/getInfo")
    // 查询个人基本信息,请求头需要token，请求数据类型  application/x-www-form-urlencoded
    fun getUserInfo(@Header("Authorization") header: String = SmartCityApplication.TOKEN): Call<UserInfo>

    @GET("/prod-api/api/allorder/list")
    fun getAllOrders(
        @Header("Authorization") header: String = SmartCityApplication.TOKEN,
        @Query("orderStatus") orderStatus: Boolean,
    ): Call<OrderEntity>

    @PUT("/prod-api/api/common/user/resetPwd") // 更改密码
    fun changePwd(
        @Header("Authorization") header: String = SmartCityApplication.TOKEN,
        @Body bean: PasswordBean,
    ): Call<Message>

    @POST("/prod-api/api/common/feedback")  //反馈
    fun feedback(
        @Header("Authorization") header: String = SmartCityApplication.TOKEN,
        @Body bean: Feed,
    ): Call<Message>

    @GET("/prod-api/api/metro/list")  // 首页线路
    fun getLineInfo(@Query("currentName") currentName: String = "建国门"): Call<LineInfoEntity>

    @GET("/prod-api/api/metro/line/{id}") // 线路详情
    fun getLineContent(@Path("id") id: Int): Call<LineContentEntity>
    @GET("/prod-api/api/metro/city")   // 查询线路
    fun getLine(): Call<LineEntity>


}