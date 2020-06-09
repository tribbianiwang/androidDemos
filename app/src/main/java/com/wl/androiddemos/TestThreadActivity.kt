package com.wl.androiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.concurrent.TimeUnit

class TestThreadActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_thread)
        TestThread().start()
//        TestRunnable().run()

//        while (!Thread.currentThread().isInterrupted){
//            Log.d("testThread","线程未被阻塞")
//        }

        var testRunnable = TestRunnable()
        var testThread = Thread(testRunnable,"TestThread")
        testThread.start()
        TimeUnit.MILLISECONDS.sleep(10)
        testThread.interrupt()



    }
}
