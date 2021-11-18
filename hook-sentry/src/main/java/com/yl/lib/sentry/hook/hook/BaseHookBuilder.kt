package com.yl.lib.sentry.hook.hook

import com.yl.lib.sentry.hook.printer.BasePrinter

/**
 * @author yulun
 * @sinice 2021-09-24 14:51
 * https://juejin.cn/post/6844903985258692621 locationManager
 */
class BaseHookBuilder {
    // 敏感API名单 ,key是方法名，value是别名，方便劣迹
    val blackList: Map<String, String>

    val name: String

    var mPrinterList: ArrayList<BasePrinter>? = null


    constructor(
        name: String,
        blackList: Map<String, String>,
        printerList: ArrayList<BasePrinter>?
    ) {
        this.name = name
        this.blackList = blackList
        this.mPrinterList = printerList
    }

    fun doPrinter(msg: String) {
        mPrinterList?.forEach {
            it.print(name!!, msg)
        }
    }
}