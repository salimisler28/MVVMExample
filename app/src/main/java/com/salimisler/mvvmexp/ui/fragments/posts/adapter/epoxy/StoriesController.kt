package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy

import com.airbnb.epoxy.EpoxyController
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.serviceentities.ServiceStory
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.ui.fragments.posts.PostsListener
import com.salimisler.mvvmexp.ui.fragments.posts.StoryStatus
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items.storyItem

class StoriesController : EpoxyController() {
    var listener: PostsListener? = null
    var storyData: List<ViewStory>? = null
    var storyStatusData: List<StoryStatus>? = null

    override fun buildModels() {
        storyData?.forEach {

        }

        storyStatusData?.sortedBy { it.seen }?.forEach {
            storyItem {
                id("story${it.id}")
                story(storyData?.get(it.id -1 ))
                listener(listener)
                if (storyStatusData?.get(it.id - 1)!!.seen) backgroundResource(R.drawable.border_posts_seenstory)
                else backgroundResource(R.drawable.border_posts_unseenstory)
            }
        }
    }
}