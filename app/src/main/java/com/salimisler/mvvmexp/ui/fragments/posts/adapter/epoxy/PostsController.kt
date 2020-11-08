package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.salimisler.mvvmexp.app.base.items.verticalSpaceItem
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
import com.salimisler.mvvmexp.ui.fragments.posts.PostComment
import com.salimisler.mvvmexp.ui.fragments.posts.PostsListener
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items.headerItem
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items.postItem

class PostsController : EpoxyController() {
    var context: Context? = null
    var listener: PostsListener? = null
    var controller: StoriesController? = null

    var postData: List<ViewPost>? = null
    var commentCountData: List<PostComment>? = null
    var storyProgressBarVisibility: Boolean? = null

    override fun buildModels() {
        verticalSpaceItem {
            id("space1")
            height(40)
        }

        headerItem {
            id("header")
            controller(controller)
            context(context)
            controller(controller)
            progressBarVisibility(storyProgressBarVisibility)
        }

        verticalSpaceItem {
            id("space1")
            height(40)
        }

        postData?.forEach {
            postItem {
                id("post${it.id}")
                listener(listener)
                post(it)
                commentCount(commentCountData?.get(it.id - 1)?.commentCount.toString())
            }

            verticalSpaceItem {
                id("space1")
                height(20)
            }
        }
    }
}