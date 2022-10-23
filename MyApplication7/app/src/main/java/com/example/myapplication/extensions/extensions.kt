package com.example.myapplication.extensions


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast
import com.example.myapplication.SmartCityApplication
import com.google.android.material.snackbar.Snackbar

// Toast提示框
fun CharSequence.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(SmartCityApplication.context, this, duration).show()
}

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(SmartCityApplication.context, this, duration).show()
}

// SharedPreferences 扩展
fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    action(editor)
    editor.apply()
}

/**
 * 获取SharedPreferences实例。
 */
val sharedPreferences: SharedPreferences = SmartCityApplication.context.getSharedPreferences(
    "SmartCityPreferences",
    Context.MODE_PRIVATE
)


/**
 * 根据手机的分辨率将dp转成为px。
 */
fun dp2px(dp: Float): Int {
    val scale = SmartCityApplication.context.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

/**
 * 根据手机的分辨率将px转成dp。
 */
fun px2dp(px: Float): Int {
    val scale = SmartCityApplication.context.resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}

inline fun <reified T> start(context: Context) {

    context.startActivity(Intent(context, T::class.java))
}

inline fun <reified T> start(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}

/**
 * @param content 显示内容
 * @param duration 显示时间
 */
fun View.showSnackBar(content:String,duration: Int=Snackbar.LENGTH_LONG){
    Snackbar.make(this,content,duration).show()
}

fun View.showSnackBar(resId:Int,duration: Int=Snackbar.LENGTH_LONG){
    Snackbar.make(this,resId,duration).show()
}

/**
 * @param content 显示内容
 * @param duration 显示时间
 * @param actionText 设置点击实践是需要传入一个字符串
 * @param block 事件具体处理，匿名函数
 */
fun View.showSnackBar(content:String,duration: Int=Snackbar.LENGTH_LONG,actionText:String ?=null,block:(()->Unit)?=null){
    val snackBar=  Snackbar.make(this,content,duration)
    if (actionText!=null && block !=null){
        snackBar.setAction(actionText){
            block()
        }
    }
    snackBar.show()

}


