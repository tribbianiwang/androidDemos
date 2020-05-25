package com.wl.androiddemos.bean

open class ResultBean {
    var resultCode:Int = 0
    var resultContent:String = ""

    constructor(resultCode: Int, resultContent: String) {
        this.resultCode = resultCode
        this.resultContent = resultContent
    }

    override fun toString(): String {
        return "ResultBean(resultCode=$resultCode, resultContent='$resultContent')"
    }


}