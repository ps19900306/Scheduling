package com.nwq.function.scheduling.ui


import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.googlecode.tesseract.android.TessBaseAPI
import com.nwq.function.scheduling.auto_code.ui.AutoCodeActivity
import com.nwq.function.scheduling.core_code.CmdType
import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.databinding.ActivityMainBinding
import com.nwq.function.scheduling.utils.FileUtils
import com.nwq.function.scheduling.utils.singleClick
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val controller = WindowInsetsControllerCompat(window, window.decorView)
//        controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
//        controller.hide(WindowInsetsCompat.Type.navigationBars())
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        val params = window.attributes
//        params.layoutInDisplayCutoutMode =
//            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
//        window.attributes = params

        bind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

        SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE1).lastStatus.let {
            bind.role1StatusTv.text = it
        }
        SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE2).lastStatus.let {
            bind.role2StatusTv.text = it
        }

        bind.startRole1.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE1
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.START)
            sendBroadcast(intent);
        }
        bind.startRole2.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE2
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.START)
            sendBroadcast(intent);
        }
        bind.closeAll.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE2
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.CLOSE)
            sendBroadcast(intent);
        }

        bind.setRole1.singleClick {
            SelectModelActivity.startSelectSet(SpConstant.PREFIX_ROLE1, this)
        }
        bind.setRole2.singleClick {
            SelectModelActivity.startSelectSet(SpConstant.PREFIX_ROLE2, this)
        }
        bind.testColor.singleClick {
            SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE1).lastCompleteTime = 0L
            SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE2).lastCompleteTime = 0L
        }

        bind.continueToTheNextCb.isChecked = SPRepo.continueToTheNext
        bind.continueToTheNextCb.setOnCheckedChangeListener { compoundButton, b ->
            SPRepo.continueToTheNext = b
        }

        bind.autoBtn.singleClick {
            //test2()
             startActivity(Intent(this, AutoCodeActivity::class.java))
        }
    }


    fun test2() {
        GlobalScope.launch {
            //Timber.d("launch start: ${Thread.currentThread().name}")


            for(i in  0 ..10 ){
                val y = Math.random()*100-50
                val x = Math.random()*100-50
                val atan2 =Math.atan2(y, x)
                val tan   =Math.atan(y/x)
                Timber.d("x:$x  y:$y atan2:$atan2 tan:$tan   test2 MainActivity NWQ_ 2023/4/25");
            //    asyncTest2()
            }
           // Timber.d("launch end ${Thread.currentThread().name}")
        }


    }





    suspend fun asyncTest2() {
        Timber.d("Thread start: ${Thread.currentThread().name}")
        withContext(Dispatchers.Default) {
            val time = measureTimeMillis { //计算执行时间
                val deferredOne: Deferred<Int> = async(Dispatchers.IO) {
                    delay(2000)
                    Timber.d("Thread asyncOne: ${Thread.currentThread().name}")
                    100//这里返回值为100
                }

                val deferredTwo: Deferred<Int> = async(Dispatchers.IO) {
                    delay(3000)
                    Timber.d("Thread asyncTwo: ${Thread.currentThread().name}")
                    200//这里返回值为200
                }

                val deferredThr: Deferred<Int> = async(Dispatchers.IO) {
                    delay(4000)
                    Timber.d("Thread asyncThr: ${Thread.currentThread().name}")
                    300//这里返回值为300
                }


                //等待所有需要结果的协程完成获取执行结果
                val result = deferredOne.await() + deferredTwo.await() + deferredThr.await()
                Timber.d("Thread result == $result ms ${Thread.currentThread().name}")
            }
            Timber.d("Thread 耗时 $time ms ${Thread.currentThread().name}")
        }
        Timber.d("Thread end ${Thread.currentThread().name}")
    }


    private suspend fun startOCR(): String {
        return withContext(Dispatchers.IO) {
            delay(2000)
            Timber.d("Thread startOCR: ${Thread.currentThread().name}")
            "sdf"
        }
    }
}