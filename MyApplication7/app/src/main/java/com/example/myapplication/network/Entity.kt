package com.example.myapplication.network

data class LoginUser(val username: String, val password: String)

data class Message(val msg: String, val code: Int, val token: String = "")
data class UserInfo(
    val code: Int,
    val msg: String,
    val user: User,
) {
    data class User(
        val avatar: String?,
        val balance: Int,
        val email: String,
        val idCard: String,
        val nickName: String,
        val phonenumber: String,
        val score: Int,
        val sex: String,
        val userId: Int,
        val userName: String,
    )
}
data class RegisterUser(
    val avatar: String = "",
    val email: String = "",
    val idCard: String = "",
    val userName: String,
    val nickName: String = userName,
    val password: String,
    val phonenumber: String,
    val sex: String = "",
)

data class BannerEntity(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
) {
    data class Row(
        val advImg: String,
        val advTitle: String,
        val appType: String,
        val createBy: String,
        val createTime: String,
        val id: Int,
        val params: Any?,
        val remark: Any?,
        val searchValue: Any?,
        val servModule: String,
        val sort: Int,
        val status: String,
        val targetId: Int,
        val type: String,
        val updateBy: String,
        val updateTime: String,
    )
}

data class NewsEntity(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
) {
    data class Row(
        val appType: String? = null,
        val commentNum: Int? = 0,
        val content: String? = null,
        val cover: String? = null,
        val createBy: String? = null,
        val createTime: String? = null,
        val hot: String? = null,
        val id: Int? = 0,
        val likeNum: Int? = 0,
        val params: Any? = null,
        val publishDate: String? = null,
        val readNum: Int? = 0,
        val remark: Any? = null,
        val searchValue: Any? = null,
        val status: String? = null,
        val subTitle: Any? = null,
        val tags: Any? = null,
        val title: String? = null,
        val top: String? = null,
        val type: String? = null,
        val updateBy: String? = null,
        val updateTime: String? = null,
    )
}

data class ServiceEntity(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
) {
    data class Row(
        val createTime: String? = "",
        val id: Int? = 0,
        val imgUrl: String? = "",
        val isRecommend: String? = "",
        val link: String? = "",
        val params: Any? = "",
        val pid: Int? = 0,
        val remark: Any? = "",
        val searchValue: Any? = "",
        val serviceDesc: String? = "",
        val serviceName: String = "",
        val serviceType: String? = "",
        val sort: Int? = 0,
        val updateBy: Any? = "",
        val updateTime: String? = "",
    )
}

data class NewsClassifyEntity(
    val code: Int,
    val `data`: List<Data>,
    val msg: String,
) {
    data class Data(
        val appType: String,
        val createBy: Any?,
        val createTime: Any?,
        val id: Int,
        val name: String,
        val params: Any?,
        val parentId: Any?,
        val remark: Any?,
        val searchValue: Any?,
        val sort: Int,
        val status: String,
        val updateBy: Any?,
        val updateTime: Any?,
    )
}

data class NewsCommentsEntity(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
) {
    data class Row(
        val appType: String,
        val commentDate: String,
        val content: String,
        val createBy: Any?,
        val createTime: Any?,
        val id: Int,
        val likeNum: Int,
        val newsId: Int,
        val newsTitle: String,
        val params: Any?,
        val remark: Any?,
        val searchValue: Any?,
        val updateBy: Any?,
        val updateTime: Any?,
        val userId: Int,
        val userName: String,
    )
}

data class CommentsBean(var newsId: Int, var content: String)
data class PasswordBean(var oldPassword: String, var newPassword: String)
data class Feed(var content: String)
data class LookHouseBanner(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
){
    data class Row(
        val advImg: String
    )
}
data class HouseInfoEntity(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
) {
    data class Row(
        val address: String,
        val areaSize: Int,
        val createBy: Any?,
        val createTime: Any?,
        val description: String,
        val houseType: String,
        val id: Int,
        val params: Any?,
        val pic: String,
        val price: String,
        val remark: Any?,
        val searchValue: Any?,
        val sourceName: String,
        val tel: String,
        val updateBy: Any?,
        val updateTime: Any?,
    )
}

data class WorkBanner(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
){
    data class Row(
        val advImg: String,
    )
}
data class Recruitment(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
){
    data class Row(
        val name: String,
        val contacts:String,
        val companyId:Int,
        val professionId:Int,
        val professionName:String,
        val salary:String,
        val address:String,
        val need:String,
        val obligation:String,
        val id:Int? = 0
    )
}
data class Toudi(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
){
    data class Row(
        val postName:String,
        val money:String,
        val satrTime:String,
        val companyName:String
    )
}
data class UserEntity(
    val code: Int,
    val msg: String,
    val rows: List<user>,
    val total: Int,
){
    data class user(
        val userName:String,
        val userId:Int,
        val sex:String,
        val icCard:String
    )
}
data class Jon(
    val code:Int,
    val msg: String,
    val data:List<Row>,
    val total: Int,
){
    data class Row(
        val mostEducation:String,
        val education:String,
        val address:String,
        val experience:String,
        val individualResume:String,
        val money:String
    )
}
data class PersonalBean(
    val idCard: String?,
    val nickName: String,
    val phonenumber: String?,
    val sex: String?,
)
data class OrderEntity(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int,
) {
    data class Row(
        val amount: Int,
        val id: Int,
        val name: String,
        val orderNo: String,
        val orderStatus: String,
        val orderType: String,
        val orderTypeName: String,
        val payTime: String,
        val userId: Int,
    )
}
data class LineInfoEntity(
    val code: Int,
    val `data`: List<Data>,
    val msg: String,
) {
    data class Data(
        val currentName: String,
        val lineId: Int,
        val lineName: String,
        val nextStep: NextStep,
        val preStep: PreStep,
        val reachTime: Int,
    )
    data class NextStep(
        val lines: List<Line>,
        val name: String,
    )

    data class PreStep(
        val lines: List<Line>,
        val name: String,
    )

    data class Line(
        val lineId: Int,
        val lineName: String,
    )
}
data class moveEntity(
    val code: Int,
    val `data`: List<Data>,
    val msg: String
){
    data class Data(
        val lineId: Int,
        val lineName: String
    )
}
data class LineContentEntity(
    val code: Int,
    val `data`: Data,
    val msg: String,
) {
    data class Data(
        val cityId: Int,
        val end: String,
        val endTime: String,
        val first: String,
        val id: Int,
        val km: Int,
        val metroStepList: List<MetroStep>,
        val name: String,
        val remainingTime: Int,
        val runStationsName: String,
        val startTime: String,
        val stationsNumber: Int,
    ) {
        data class MetroStep(
            val createBy: Any?,
            val createTime: String,
            val firstCh: String,
            val id: Int,
            val lineId: Int,
            val name: String,
            val params: Any?,
            val remark: Any?,
            val searchValue: Any?,
            val seq: Int,
            val updateBy: Any?,
            val updateTime: String,
        )
    }
}

data class LineEntity(
    val code: Int,
    val `data`: Data,
    val msg: String,
) {
    data class Data(
        val code: Int,
        val createBy: Any?,
        val createTime: String,
        val id: Int,
        val imgUrl: String,
        val name: String,
        val params: Any?,
        val remark: Any?,
        val searchValue: Any?,
        val updateBy: Any?,
        val updateTime: String,
    )
}
