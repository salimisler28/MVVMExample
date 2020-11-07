package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.salimisler.mvvmexp.app.entities.serviceentities.ServicePost
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
import com.salimisler.mvvmexp.ui.fragments.posts.PostsListener
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items.headerItem
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items.postItem


class PostsController : EpoxyController() {
    var context: Context? = null
    var controller: StoriesController? = null
    var listener: PostsListener? = null
    var postData: List<ViewPost>? = null

    override fun buildModels() {
        headerItem {
            id("header")
            controller(controller)
            context(context)
            controller(controller)
        }

        postData?.forEach {
            postItem {
                id("post${it.id}")
                listener(listener)
                post(it)
            }
        }
    }
}