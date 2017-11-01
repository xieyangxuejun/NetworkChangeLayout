package com.foretree.networklistenerlayout

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NetworkChangeListener {
    val items = listOf(
            UserModel("张"), UserModel("张"), UserModel("张"), UserModel("张"),
            UserModel("张"), UserModel("张"), UserModel("张"), UserModel("张"),
            UserModel("张"), UserModel("张"), UserModel("张"), UserModel("张"),
            UserModel("张"), UserModel("张"), UserModel("张"), UserModel("张")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_list.adapter = NormalAdapter(items)
//        NetworkChangeManager.instance(this)?.register(this)
        NetworkChangeManager(this).register(this)
        Log.d("xy", "xy==>" + "=============")
    }

    /**
     * 监听网络变化
     *
     * @param type
     */
    private var networkErrorLayout: LinearLayoutCompat? = null

    override fun onAvailable(type: Int) {
        if (networkErrorLayout != null) rl_container.removeView(networkErrorLayout)
    }

    override fun onUnavailable() {
        val cardMargin = resources.getDimensionPixelSize(R.dimen.home_recommend_card_margin)
        val margin = resources.getDimensionPixelSize(R.dimen.home_recommend_margin)
        networkErrorLayout = LinearLayoutCompat(this)
        val height = DensityUtil.dip2px(30f)
        networkErrorLayout!!.layoutParams = LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)
        val textView = TextView(this)
        textView.layoutParams = LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)
        val start = resources.getDrawable(R.drawable.icon_editor_nav_text_font_recovery)
        start.setBounds(0, 0, height / 2, height / 2)
        val right = resources.getDrawable(R.drawable.icon_arrow_right)
        right.setBounds(0, 0, (28 / 58.0 * (height / 2)).toInt(), height / 2)
        textView.setCompoundDrawables(start, null, right, null)
        textView.text = "网络不可用, 请检查!"
        textView.gravity = Gravity.START or Gravity.CENTER_VERTICAL
        textView.compoundDrawablePadding = 12
        textView.setOnClickListener { view ->
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }
        networkErrorLayout?.setBackgroundColor(resources.getColor(R.color.colorAccent))
        networkErrorLayout?.setPadding(cardMargin + margin, 0, cardMargin + margin, 0)
        networkErrorLayout?.addView(textView)
        rl_container.addView(networkErrorLayout, 0)
    }


}
