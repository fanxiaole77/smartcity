package com.example.myapplication.ui.huanbao

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_paizhao.*
import kotlinx.android.synthetic.main.item_line_content.*
import java.io.File
import java.io.IOException

class PaizhaoActivity : AppCompatActivity() {


    val takephto = 1

    lateinit var imageUri: Uri
    lateinit var outputImage: File

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paizhao)
        take_photo.setOnClickListener {
             outputImage = File(externalCacheDir, "output_image.jpg")
                if (outputImage.exists()) {
                    outputImage.delete()
                }
                outputImage.createNewFile()
            imageUri = if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                FileProvider.getUriForFile(this,"com.example.myapplication.ui.huanbao.fileProvider",outputImage)
            }else{
                Uri.fromFile(outputImage)
            }
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent,takephto)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            takephto -> {
                if (resultCode == Activity.RESULT_OK){
                    val bitamap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
                    imageView.setImageBitmap(bitamap)
                }
            }
        }
    }
}