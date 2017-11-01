package com.foretree.networklistenerlayout

import android.content.Context
import android.content.res.Resources

/**
 * Created by silen on 01/11/2017.
 */
object DensityUtil {

    val density: Int
        get() {
            val scale = Resources.getSystem().displayMetrics.density
            return (scale + 0.5f).toInt()
        }

    /* 获取手机的通知栏的高度 */
    val statusBarHeight: Int
        get() = Resources.getSystem().getDimensionPixelSize(
                Resources.getSystem().getIdentifier("status_bar_height",
                        "dimen", "android"))

    /* 根据手机的分辨率从 dp 的单位 转成为 px(像素) */
    fun dip2px(dpValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dip(pxValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Int): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return ((spValue - 0.5f) * fontScale).toInt()
    }

    /* 获取手机屏幕的宽度 */
    fun getMetricsWidth(context: Context?): Int {
        return context?.resources?.displayMetrics?.widthPixels ?: 0
    }

    /* 获取手机屏幕的高度 */
    fun getMetricsHeight(context: Context?): Int {
        return context?.resources?.displayMetrics?.heightPixels ?: 0
    }
}