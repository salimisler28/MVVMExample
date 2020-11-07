package com.salimisler.mvvmexp.ui.fragments.posts

import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory

interface PostsListener {
    fun setOnStoryItemClickListener(story: ViewStory?)
}