package com.salimisler.mvvmexp.app.entities

import com.salimisler.mvvmexp.app.entities.serviceentities.ServicePost
import com.salimisler.mvvmexp.app.entities.serviceentities.ServiceStory
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
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

fun List<ServicePost>.toViewPost(): List<ViewPost> {
    var i = 0
    val list = mutableListOf<ViewPost>()

    for (item in this) {
        if (i < 5) {
            val viewPost = ViewPost(
                id = item.id,
                sourceImageUrl = "https://upload.wikimedia.org/wikipedia/commons/b/b0/Fanatik_400x400.jpg",
                postImageUrl = "https://iaftm.tmgrup.com.tr/62dc2a/829/469/0/0/943/533?u=https://iftm.tmgrup.com.tr/2020/11/07/son-dakika-abdullah-avci-trabzonsporda-3-yillik-1604765494103.jpg",
                source = "Fanatik",
                kind = "Futbol",
                title = item.title,
                body = item.body
            )
            list.add(viewPost)
        } else {
            break
        }
        i++
    }

    return list.toList()
}