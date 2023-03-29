package com.nwq.function.scheduling.core_code.ocr

import android.graphics.Bitmap
import com.googlecode.tesseract.android.TessBaseAPI
import com.nwq.function.scheduling.utils.FileUtils.language
import com.nwq.function.scheduling.utils.FileUtils.orcFileFolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
create by: 86136
create time: 2023/3/29 15:43
Function description:
 */

object OrcUtils {
    private const val defaultBpp = 4

    private suspend fun startOCR(bitmap: Bitmap): String {
        return withContext(Dispatchers.IO) {
            val tessBaseApi = TessBaseAPI()
            tessBaseApi.init(orcFileFolder, language)
            tessBaseApi.setImage(bitmap)
            val result = tessBaseApi.utF8Text
            tessBaseApi.end()
            result
        }
    }

    private suspend fun cutImg(bitmap: Bitmap, x: Int, y: Int, width: Int, height: Int): String {
        return withContext(Dispatchers.IO) {
            val tessBaseApi = TessBaseAPI()
            tessBaseApi.init(orcFileFolder, language)
            val resultBitmap = Bitmap.createBitmap(bitmap, x, y, width, height)
            tessBaseApi.setImage(resultBitmap)
            val result = tessBaseApi.utF8Text
            tessBaseApi.end()
            resultBitmap.recycle()
            result
        }
    }


    private suspend fun startOCR(
        imagedata: ByteArray,
        width: Int,
        height: Int,
        bpp: Int = defaultBpp,
        bpl: Int = bpp * width
    ): String {
        return withContext(Dispatchers.IO) {
            val tessBaseApi = TessBaseAPI()
            tessBaseApi.init(orcFileFolder, language)
            tessBaseApi.setImage(imagedata, width, height, bpp, bpl)
            val result = tessBaseApi.utF8Text
            tessBaseApi.end()
            result
        }
    }

}