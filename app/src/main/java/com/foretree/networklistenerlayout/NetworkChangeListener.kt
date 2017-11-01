package com.foretree.networklistenerlayout

/**
 * Created by silen on 01/11/2017.
 */
interface NetworkChangeListener {
    /**
     * 网络连接
     * ConnectivityManager.TYPE_WIFI = WiFi网络
     * ConnectivityManager.TYPE_ETHERNET = 有线网络
     * ConnectivityManager.TYPE_MOBILE = 移动网络
     * ConnectivityManager.TYPE_BLUETOOTH = 蓝牙网络
     *
     */
    fun onAvailable(type: Int)

    /**
     * 网络断开
     */
    fun onUnavailable()
}