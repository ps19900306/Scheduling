package com.nwq.function.corelib.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import timber.log.Timber
import java.io.*

/**
create by: 86136
create time: 2023/3/9 14:46
Function description:
Timber.d("${} $methodName$ $className$ NWQ_ $date$");
 */

object FileUtils {

    const val FileDir = "autoCode"
    var LastImageName = ""
    private val TextFileDir =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/schedule"
    val orcFileFolder =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + "/orc"
    const val language = "chi_sim"
    const val languageAllName = "chi_sim.traineddata"

    private var fileWriter: FileWriter? = null


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
            val folderFile = File(TextFileDir)
            if (!folderFile.exists()) {
                folderFile.mkdirs()
            }
            val file = File(TextFileDir, "${FileDir}.text")
            val writer = FileWriter(file, true)
            writer.write(msg);
            writer.close();
        } catch (e: Exception) {
            Timber.d("$e getFileWrite FileUtils NWQ_ 2023/3/9");
        }
    }


    fun getFileWrite(): FileWriter? {
        if (fileWriter != null)
            return fileWriter
        return try {
            val file = File(TextFileDir, "${FileDir}.text")
            fileWriter = FileWriter(file, true)
            fileWriter
        } catch (e: Exception) {
            Timber.d("$e getFileWrite FileUtils NWQ_ 2023/3/9");
            null
        }
    }

    fun closeFileWriter() {
        try {
            fileWriter?.close()
            fileWriter = null
        } catch (e: Exception) {
            Timber.d("$e getFileWrite FileUtils NWQ_ 2023/3/9");
            null
        }
    }


    fun orcExists(): Boolean {
        val orcFile = File(orcFileFolder, languageAllName)
        return orcFile.exists()
    }

    fun copyOrcFile(inputStream: InputStream) {
        val file = File(orcFileFolder)
        if (!file.exists()) {
            file.mkdirs()
        }
        val orcFile = File(orcFileFolder, languageAllName)
        val outOs = FileOutputStream(orcFile)
        val buffer = ByteArray(1024)
        var length = inputStream.read(buffer)
        while (length > 0) {
            outOs.write(buffer, 0, length)
            length = inputStream.read(buffer)
        }
        outOs.flush()
        outOs.close()
        inputStream.close()
    }

}