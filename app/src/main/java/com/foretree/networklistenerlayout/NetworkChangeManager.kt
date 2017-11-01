package com.foretree.networklistenerlayout

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.util.Log

/**
 * Created by silen on 01/11/2017.
 */
class NetworkChangeManager(private var context: Context) {
    public var mContext: Context? = null
    var broadcastReceiver: NetworkChangeBroadcastReceiver? = null
    var isRegister: Boolean = false

    companion object {
        private var mInstance: NetworkChangeManager? = null
        fun instance(context: Context) : NetworkChangeManager?{
            if (mInstance == null) {
                synchronized(NetworkChangeManager::class) {
                    if (mInstance == null) {
                        mInstance = NetworkChangeManager(context)
                    }
                }
            }
            return mInstance
        }
    }

    fun register(networkChangeListener: NetworkChangeListener) {
        try {
            Log.d("xy==>", "是否注册:")
            if (isRegister) {
                unregisterReceiver()
            }
            broadcastReceiver = NetworkChangeBroadcastReceiver()
            broadcastReceiver!!.setNetworkChangeListener(networkChangeListener)
            val mFilter = IntentFilter()
            mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
            mContext!!.registerReceiver(broadcastReceiver, mFilter)
            isRegister = true
            Log.d("xy==>", "是否注册:" + mContext?.isRestricted)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("xy==>", "是否注册:" + e.printStackTrace())
        }

    }

    private fun unregisterReceiver() {
        try {
            if (broadcastReceiver != null) {
                mContext!!.unregisterReceiver(broadcastReceiver)
                isRegister = false
                broadcastReceiver = null
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
