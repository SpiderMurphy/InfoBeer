package com.hero.infobeer.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hero.infobeer.R
import com.hero.infobeer.models.ItemView
import com.hero.infobeer.presenters.ItemPresenter
import kotlinx.android.synthetic.main.adapter_item.view.*

/**
 * Created by Cyan on 12/03/2018.
 */
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    lateinit var presenter : ItemPresenter

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_item, parent, false))
    }

    override fun getItemCount(): Int = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        presenter.bindView(holder!!, position)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), PresenterBehaviors  {
        override fun bindItem(item: ItemView) {
            itemView.title.text = item.item.title
            itemView.subtitle.text = item.item.key
        }
    }
}