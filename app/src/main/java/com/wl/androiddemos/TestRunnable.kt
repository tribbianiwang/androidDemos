package com.wl.androiddemos

import android.util.Log

class TestRunnable:Runnable{
    var i:Long=0

    override fun run() {

        while (!Thread.currentThread().isInterrupted){
            i++
            Log.d("testRunnable","startRun${i}")
        }
        Log.d("testRunnable","stop")
    }


}