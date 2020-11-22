package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy

import com.airbnb.epoxy.EpoxyController
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.app.utils.extentions.getById
import com.salimisler.mvvmexp.ui.fragments.posts.PostsListener
import com.salimisler.mvvmexp.ui.fragments.StoryStatus
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items.storyItem

class StoriesController : EpoxyController() {
    var listener: PostsListener? = null
    var storyData: List<ViewStory>? = null
    var storyStatusData: List<StoryStatus>? = null

    override fun buildModels() {

        storyStatusData?.sortedBy { it.seen }?.forEach {
            storyItem {
                id("story${it.id}")
                story(storyData?.getById(it.id))
                listener(listener)
                if (storyStatusData!!.getById(it.id).seen) backgroundResource(R.drawable.border_posts_seenstory)
                else backgroundResource(R.drawable.border_posts_unseenstory)
            }
        }
    }
}