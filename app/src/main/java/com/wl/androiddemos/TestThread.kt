package com.wl.androiddemos

import android.util.Log

class TestThread: Thread() {
    override fun run() {
        super.run()
        Log.d("thread--","startrun")
    }
}