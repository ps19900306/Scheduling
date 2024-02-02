package com.android.schedule.corelibrary.controller

import android.content.Intent
import android.graphics.ImageFormat
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.Image
import android.media.ImageReader
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Handler
import android.util.DisplayMetrics
import com.android.schedule.corelibrary.utils.L


object ImageTakeUtils {


    private var mImageReader: ImageReader? = null
    private var mVirtualDisplay: VirtualDisplay? = null
    private var mMediaProjection: MediaProjection? = null
    private const val DISPLAY_FLAGS = DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC or
            DisplayManager.VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY or
            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR


    private var count = 0
    private val maxImages = 10
    private var width = 0
    private var height = 0
    private val dpi = 1
    private var mHandler: Handler?=null
    fun acquireNextImage(): Image? {
        if (width == 0 || height == 0)
            return null
        if (count >= maxImages) {
            L.d("count >= maxImages")
            mImageReader?.close()
            mVirtualDisplay?.release()
            createNewImageReader()
            count=0
        }
        val image = mImageReader?.acquireNextImage()
        count++
        return image
    }

    fun startRecord(
        mediaProjectionManager: MediaProjectionManager,
        resultCode: Int,
        data: Intent,
        handler: Handler?,
        metrics: DisplayMetrics
    ) {

        // 创建 ImageReader 对象，用于从虚拟显示器中获取图像帧
        mMediaProjection = mediaProjectionManager.getMediaProjection(resultCode, data);
        width = metrics.widthPixels
        height = metrics.heightPixels
        mHandler = handler
        createNewImageReader()
    }

    private fun createNewImageReader() {
        mImageReader =
            ImageReader.newInstance(width, height, 0x1, maxImages)
        // 创建虚拟显示器，指定虚拟显示器的名称、宽度、高度、dpi 等参数
        mVirtualDisplay = mMediaProjection?.createVirtualDisplay(
            "ScreenCapture",
            width, height, dpi,
            DISPLAY_FLAGS,
            mImageReader!!.surface, object : VirtualDisplay.Callback() {
                override fun onPaused() {
                    L.d("onPaused")
                }

                /**
                 * Called when the virtual display video projection has been
                 * resumed after having been paused.
                 */
                override fun onResumed() {
                    L.d("onResumed")
                }

                /**
                 * Called when the virtual display video projection has been
                 * stopped by the system.  It will no longer receive frames
                 * and it will never be resumed.  It is still the responsibility
                 * of the application to release() the virtual display.
                 */
                override fun onStopped() {
                    L.d("onStopped")
                }
            }, mHandler
        )
    }

}