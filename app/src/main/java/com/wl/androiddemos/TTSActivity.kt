package com.wl.androiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tts.*
import java.util.*

class TTSActivity : AppCompatActivity() {
    lateinit var textToSpeech: TextToSpeech
    val TAG = "TTSActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tts)

        textToSpeech = TextToSpeech(this,
            TextToSpeech.OnInitListener { i ->
                //如果装载TTS引擎成功
                if (i == TextToSpeech.SUCCESS) {


                    //设置使用美式英语朗读
                    val result = textToSpeech.setLanguage(Locale.CHINESE)
                    //如果不支持所设置的语言
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        Log.d(TAG,"暂时不支持这种语言的朗读")
                        Toast.makeText(this@TTSActivity, "暂时不支持这种语言的朗读", Toast.LENGTH_SHORT)
                            .show()
                    }else{
                        Log.d(TAG,"执行朗读")
                        //执行朗读

                        bt_play.setOnClickListener {
                            textToSpeech.speak(
                                et_speak_content.text.toString(),
                                TextToSpeech.QUEUE_ADD, null
                            )

                        }

                    }

                } else {
                    Log.d(TAG,"ERROR")

                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()

    }
}
