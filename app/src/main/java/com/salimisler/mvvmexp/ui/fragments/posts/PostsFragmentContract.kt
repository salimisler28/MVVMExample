package com.salimisler.mvvmexp.ui.fragments.posts

import android.content.Context
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.ui.fragments.PostComment
import com.salimisler.mvvmexp.ui.fragments.PostsFragmentViewModel
import com.salimisler.mvvmexp.ui.fragments.StoryStatus

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

        fun setStoryProgressBarVisibility(value: Boolean)
        fun setPostData(data: List<ViewPost>)
        fun setStoryData(data: List<ViewStory>)
        fun setStoryStatusData(data: List<StoryStatus>)
        fun setPostCommentData(data: List<PostComment>)

        fun startStoryFragment()
    }

    interface Presenter : PostsListener {
        fun setViewModel(viewModel: PostsFragmentViewModel)
        fun setView(view: View)
        fun onStart()
    }
}