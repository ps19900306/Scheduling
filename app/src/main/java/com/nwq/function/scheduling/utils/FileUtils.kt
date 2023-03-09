package com.nwq.function.scheduling.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.icu.text.IDNA
import android.net.Uri
import android.os.Environment
import android.os.FileUtils
import android.provider.MediaStore
import timber.log.Timber
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.OutputStream

/**
create by: 86136
create time: 2023/3/9 14:46
Function description:
Timber.d("${} $methodName$ $className$ NWQ_ $date$");
 */

object FileUtils {

    const val FileDir = "Schedule"
    var LastImageName = ""
    private val TextFileDir =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)


    fun saveBitmapAndroid(context: Context, name: String, b: Bitmap): String? {
        LastImageName = name
        val jpegName = "IMG_$name.jpg"
        val values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME, jpegName)
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        values.put("relative_path", "DCIM/$FileDir")
        val external: Uri
        val resolver = context.contentResolver
        val status = Environment.getExternalStorageState()
        // 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
        external = if (status == Environment.MEDIA_MOUNTED) {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        } else {
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        }
        val insertUri = resolver.insert(external, values) ?: return ""
        val os: OutputStream?
        return try {
            os = resolver.openOutputStream(insertUri)
            b.compress(Bitmap.CompressFormat.JPEG, 100, os)
            if (os != null) {
                os.flush()
                os.close()
            }
            insertUri.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }
    }

    fun writeFile(msg: String) {
        try {
            val file = File(TextFileDir, "${FileDir}.text")
            if (!file.exists())
                file.mkdirs()
            val writer = FileWriter(file)
            writer.write(msg);
            writer.close();
        } catch (e: Exception) {
            Timber.d("$e getFileWrite FileUtils NWQ_ 2023/3/9");
        }
    }

    fun getFileWrite(): FileWriter? {
        return try {
            val file = File(TextFileDir, "${FileDir}.text")
            if (!file.exists())
                file.mkdirs()
            val writer = FileWriter(file)
            writer
        } catch (e: Exception) {
            Timber.d("$e getFileWrite FileUtils NWQ_ 2023/3/9");
            null
        }
    }

}