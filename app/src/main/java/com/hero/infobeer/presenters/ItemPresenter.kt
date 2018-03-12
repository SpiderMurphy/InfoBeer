package com.hero.infobeer.presenters

import com.hero.infobeer.adapters.PresenterBehaviors
import com.hero.infobeer.models.ItemView
import java.util.*

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

    fun sort(asc: Boolean = false) {
        if(!asc)
            Collections.sort(items, kotlin.Comparator { t1, t -> if (t1.item.title.compareTo(t.item.title) > 0)  -1
            else ( if(t1.item.title.compareTo(t.item.title) < 0) 1 else 0)  })
        else
            Collections.sort(items, kotlin.Comparator { t1, t -> if (t1.item.title.compareTo(t.item.title) > 0) 1
            else ( if(t1.item.title.compareTo(t.item.title) < 0) -1 else 0)  })
    }
}