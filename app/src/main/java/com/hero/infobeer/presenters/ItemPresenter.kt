package com.hero.infobeer.presenters

import com.hero.infobeer.adapters.PresenterBehaviors
import com.hero.infobeer.models.ItemView

/**
 * Created by Cyan on 12/03/2018.
 */
class ItemPresenter {
    var items = mutableListOf<ItemView>()

    fun add(item: ItemView){ items.add(item) }
    fun getCount() : Int = items.size

    fun bindView(holder: PresenterBehaviors, position : Int){
        holder.bindItem(items.get(position))
    }
}