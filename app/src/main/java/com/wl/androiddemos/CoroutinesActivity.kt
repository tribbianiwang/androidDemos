package com.wl.androiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.wl.androiddemos.bean.ResultBean
import com.wl.androiddemos.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class CoroutinesActivity : AppCompatActivity() {

    lateinit var myViewModel:MyViewModel

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        myViewModel =  ViewModelProviders.of(this).get(MyViewModel::class.java)




        lifecycleScope.launch {
            Log.d("scope","lifecyclescope-launch")
        }

        lifecycleScope.launchWhenCreated {
            Log.d("scope","lifecyclescope-oncreate")
        }

        lifecycleScope.launchWhenStarted {
            Log.d("scope","lifecyclescope-start")
        }

        lifecycleScope.launchWhenResumed {
            Log.d("scope","lifecyclescope-resume")
        }

        myViewModel.result.observe(this,object:Observer<String>{
            override fun onChanged(t: String?) {
                Log.d("scope","getonChange${t}")
            }

        })

//        excuse()

//        executeTogether()


        lifecycleScope.launch(Dispatchers.IO){
            testFlow().collect {
                withContext(Dispatchers.Main){
                    if(isActive){
                        Log.d("resultIoflow","content${it}")
                        tv_together.text = it
                    }
                }
            }

        }




    }

    fun excuse(){
        GlobalScope.launch(Dispatchers.Main){
            var result = withContext(Dispatchers.IO){
                "result"
            }

            //回到主线程
            Log.d("scope","回到主线程${result}")

        }
    }



//    fun execute2() {
//            GlobalScope.launch(Dispatchers.Main) {
//                        //使用async发起两个异步请求
//                    val one = async { one() }
//                    val two = async { two() }
//                            //使用await进行合并
//                    val result = one.await() + two.await()
//                    tv_content.text = result
//                }
//    }

    fun executeTogether(){
        GlobalScope.launch(Dispatchers.Main){

            val one = async {
                      one()
            }
            val two = async {
                two()
            }


            tv_together.text = one.await().toString()+two.await().toString()

        }
    }

    suspend fun one(): ResultBean {
        return ResultBean(1,"success")
    }

    suspend fun two():ResultBean{
        return ResultBean(0,"error")
    }



     fun testFlow():Flow<String> = flow {
        var counter = 0
        while(true) {
            counter++
            delay(2000)
            emit(getFlowString(counter))
        }
    }

    fun getFlowString(counter:Int):String{
        return counter.toString()
    }





}
