package com.salimisler.mvvmexp.app.entities

import com.salimisler.mvvmexp.app.entities.serviceentities.ServiceStory
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory

fun List<ServiceStory>.toViewStory(): List<ViewStory> {
    var i = 0
    val list = mutableListOf<ViewStory>()

    for (item in this) {
        if (i < 5) {
            val viewStory = ViewStory(
                id = item.id,
                title = item.title,
                url = item.url,
                thumbnailUrl = item.thumbnailUrl
            )
            list.add(viewStory)
        } else {
            break
        }
        i++
    }

    return list.toList()
}