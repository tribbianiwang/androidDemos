package com.wl.androiddemos

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import com.iflytek.cloud.*
import com.iflytek.cloud.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_ji_guang_tts.*

class JiGuangTTSActivity : AppCompatActivity() {

    // 语音合成对象
    lateinit var mTts: SpeechSynthesizer

    // 引擎类型
    private var mEngineType = SpeechConstant.TYPE_LOCAL

    // 默认本地发音人
    var voicerLocal = "xiaoyan"
    val TAG = "JiGuangTTSActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ji_guang_tts)
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=5dca1715");

        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(this, object:TextToSpeech.OnInitListener,
            InitListener {
            override fun onInit(code: Int) {
                Log.d(TAG, "InitListener init() code = $code")
                if (code != ErrorCode.SUCCESS) {
                    Log.d(TAG,"初始化失败,错误码：$code,请点击网址https://www.xfyun.cn/document/error-code查询解决方案")

                } else {
                    // 初始化成功，之后可以调用startSpeaking方法
                    // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                    // 正确的做法是将onCreate中的startSpeaking调用移至这里
                }
            }

        })

        mTts.setParameter( SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL );

        mTts.setParameter( ResourceUtil.TTS_RES_PATH, getResourcePath() );


         var strTextToSpeech  = "科大讯飞，让世界聆听我们的声音";
        bt_say.setOnClickListener {
            mTts.startSpeaking( strTextToSpeech, object:SynthesizerListener{
                override fun onBufferProgress(p0: Int, p1: Int, p2: Int, p3: String?) {
                    Log.d(TAG, "onBufferProgress")
                }

                override fun onSpeakBegin() {
                    Log.d(TAG, "onSpeakBegin")
                }

                override fun onSpeakProgress(p0: Int, p1: Int, p2: Int) {
                    Log.d(TAG, "onSpeakProgress")
                }

                override fun onEvent(p0: Int, p1: Int, p2: Int, p3: Bundle?) {
                    Log.d(TAG, "onEvent")
                }

                override fun onSpeakPaused() {
                    Log.d(TAG, "onSpeakPaused")
                }

                override fun onSpeakResumed() {
                    Log.d(TAG, "onSpeakResumed")
                }

                override fun onCompleted(p0: SpeechError?) {
                    Log.d(TAG, "onCompleted")
                }

            } );
        }

    }

    //获取发音人资源路径
    private fun getResourcePath(): String {
        val tempBuffer = StringBuffer()
        var type = "tts"
        if (mEngineType == SpeechConstant.TYPE_XTTS) {
            type = "xtts"
        }
        //合成通用资源
        tempBuffer.append(
            ResourceUtil.generateResourcePath(
                this, ResourceUtil.RESOURCE_TYPE.assets,
                "$type/common.jet"
            )
        )
        tempBuffer.append(";")

            tempBuffer.append(
                ResourceUtil.generateResourcePath(
                    this,
                    ResourceUtil.RESOURCE_TYPE.assets,
                    type + "/" + this.voicerLocal + ".jet"
                )
            )


        return tempBuffer.toString()
    }

}
