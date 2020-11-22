package com.salimisler.mvvmexp.app.utils.extentions

import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.ui.fragments.StoryStatus
import java.lang.Exception

fun <T> Class<T>.tag(): String {
    return this::class.java.simpleName
}

fun List<StoryStatus>.getById(id: Int): StoryStatus {
    for (item in this) {
        if (item.id == id) {
            return item
        }
    }

    throw Exception()
}
fun List<ViewStory>.getById(id: Int): ViewStory {
    for (item in this) {
        if (item.id == id) {
            return item
        }
    }

    throw Exception()
}