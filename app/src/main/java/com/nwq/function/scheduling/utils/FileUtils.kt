package com.nwq.function.scheduling.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import java.io.FileNotFoundException
import java.io.OutputStream


object FileUtils {
     fun saveImage29(toBitmap: Bitmap, context: Context) {
        //开始一个新的进程执行保存图片的操作
        val insertUri: Uri? = context.getContentResolver().insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ContentValues()
        )
        //使用use可以自动关闭流
        try {
            val outputStream: OutputStream? =
                insertUri?.let { context.getContentResolver().openOutputStream(it, "rw") }
            if (toBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)) {
                Log.i("保存成功", "success")
            } else {
                Log.i("保存失败", "fail")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }
}