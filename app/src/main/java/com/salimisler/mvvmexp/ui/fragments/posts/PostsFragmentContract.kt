package com.salimisler.mvvmexp.ui.fragments.posts

import android.content.Context
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory

interface PostsFragmentContract {
    interface View {
        fun setPostsEpoxyController()
        fun setStoriesEpoxyController()
        fun setPostsEpoxyAdapter()

        // fun setStoriesEpoxyAdapter()
        fun requestModelBuildForPosts()
        fun requestModelBuildForStroies()

        fun setContext(context: Context)
        fun setListener(listener: PostsListener)
        fun setPostData(data: List<ViewPost>)
        fun setStoryData(data: List<ViewStory>)
        fun setStoryStatusData(data: List<StoryStatus>)

        fun startStoryActivity(story: ViewStory)
    }

    interface Presenter : PostsListener {
        fun setViewModel(viewModel: PostsFragmentViewModel)
        fun setView(view: View)
        fun onStart()
    }
}