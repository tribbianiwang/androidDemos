package com.wl.androiddemos

import android.app.Application
import com.tencent.tinker.entry.ApplicationLifeCycle
import com.tencent.tinker.entry.ApplicationLike
import com.tinkerpatch.sdk.TinkerPatch
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike

class MyApplication: Application() {

    lateinit var tinkerApplicationLike: ApplicationLike
    override fun onCreate() {
        super.onCreate()
        // 我们可以从这里获得Tinker加载过程的信息
        tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();

        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
        TinkerPatch.init(tinkerApplicationLike)
            .reflectPatchLibrary()
            .setPatchRollbackOnScreenOff(true)
            .setPatchRestartOnSrceenOff(true)
            .setFetchPatchIntervalByHours(1);

        // 每隔3个小时(通过setFetchPatchIntervalByHours设置)去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
    }

}