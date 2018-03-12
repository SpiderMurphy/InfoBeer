package com.hero.infobeer.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.hero.infobeer.models.ItemView

/**
 * Created by Cyan on 12/03/2018.
 */
class ItemAdapter {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), PresenterBehaviors  {
        override fun bindItem(item: ItemView) {

        }
    }
}