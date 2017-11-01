package com.foretree.networklistenerlayout

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.view_normal.view.*

/**
 * Created by silen on 01/11/2017.
 */
class NormalAdapter(var items: List<UserModel>) : RecyclerView.Adapter<Holder>() {
    override fun onBindViewHolder(holder: Holder?, position: Int) {
        val controler = Fresco.newDraweeControllerBuilder()
                .setUri(items[position].icon)
                .setAutoPlayAnimations(true)
                .build()
        holder?.itemView?.iv_icon?.controller = controler
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent?.context).inflate(R.layout.view_normal, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView)