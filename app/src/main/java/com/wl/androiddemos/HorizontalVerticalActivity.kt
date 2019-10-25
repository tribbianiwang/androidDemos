package com.wl.androiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wl.androiddemos.adapter.RvDemoAdapter
import com.wl.androiddemos.bean.RvDataBean
import kotlinx.android.synthetic.main.activity_horizontal_vertical.*

class HorizontalVerticalActivity : AppCompatActivity() {

    var datalist:ArrayList<RvDataBean> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_vertical)

        rv_content.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        initData()
        var rvDemoAdapter = RvDemoAdapter(datalist)
        rv_content.adapter = rvDemoAdapter


    }

    private fun initData() {
        for(i in 1..1000){
            var rvDataBean = RvDataBean()
            rvDataBean.name= "王大雷"+i
            rvDataBean.gender="男"+i
            rvDataBean.age = i*2
            rvDataBean.telephoneNum = "152383225"+i
            rvDataBean.address = "河南省郑州市金水区国基路"+i+"号"
            rvDataBean.birthday = "1995-05-07"
            rvDataBean.hobby = "爱好"+i
            rvDataBean.jog = "程序员"
            rvDataBean.jobage =i.toString()+"年"
            rvDataBean.isMarried = false
            datalist.add(rvDataBean)
        }


    }
}
