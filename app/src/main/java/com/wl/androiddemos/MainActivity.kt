package com.wl.androiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity--"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testGlobalScope()
    }


    fun testGlobalScope(){
//        GlobalScope.launch { // 在后台启动一个新的协程并继续
//            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//
//            Log.d(TAG,"World!") // 在延迟后打印输出
//        }
//        Log.d(TAG,"Hello,") // 协程已在等待时主线程还在继续
//       runBlocking {// 但是这个表达式阻塞了主线程
//           delay(2000L)// ……我们延迟 2 秒来保证 JVM 的存活
//       }
      val  coroutinContext: CoroutineContext = EmptyCoroutineContext
        val coroutineScope = CoroutineScope(coroutinContext)
//        coroutineScope.launch(Dispatchers.IO) {
//            Log.d(TAG,"threadname:io"+Thread.currentThread().name)
//            coroutineScope.launch (Dispatchers.Main){
//                Log.d(TAG,"threadname:main"+Thread.currentThread().name)
//            }
//        }

        coroutineScope.launch(Dispatchers.Main){

         withContext(Dispatchers.IO){
             Log.d(TAG,"threadname:"+Thread.currentThread().name)
         }
            Log.d(TAG,"threadname:main"+Thread.currentThread().name)
        }


    }


}
