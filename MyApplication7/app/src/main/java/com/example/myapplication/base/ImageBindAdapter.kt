package com.example.myapplication.base

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.R

class ImageBindAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("bindingImage")
        fun setImage(imageView: ImageView, url: String?) {
            if (url != null && !TextUtils.isEmpty(url)) {
                Glide.with(imageView).load(url).placeholder(R.drawable.network).into(imageView)

            } else {
                Glide.with(imageView).load(R.drawable.avatar).into(imageView)
            }
        }
    }
}