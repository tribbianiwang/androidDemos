package com.wl.androiddemos.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wl.androiddemos.R

class KotlinTestActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test)
        var age = -12
        require(age>0){
            "age must > 0"
        }

        var name = ""
        checkNotNull(name){
         "name is not null"
        }

    }
}