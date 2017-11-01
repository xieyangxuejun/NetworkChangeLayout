package com.foretree.networklistenerlayout

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

/**
 * Created by silen on 01/11/2017.
 */
class NetworkChangeBroadcastReceiver : BroadcastReceiver() {

    private var mNetworkChangeListener: NetworkChangeListener? = null

    fun setNetworkChangeListener(networkChangeListener: NetworkChangeListener) {
        this.mNetworkChangeListener = networkChangeListener
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (mNetworkChangeListener == null) {
            return
        }
        val action = intent.action
        if (action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val mConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = mConnectivityManager.activeNetworkInfo
            //网络连接
            if (networkInfo != null && networkInfo.isAvailable) {
                mNetworkChangeListener!!.onAvailable(networkInfo.type)
            } else {
                //网络断开
                mNetworkChangeListener!!.onUnavailable()
            }
        }

    }
}