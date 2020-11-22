package com.salimisler.mvvmexp.ui.fragments.posts

import androidx.lifecycle.Observer
import com.salimisler.mvvmexp.app.entities.toViewPost
import com.salimisler.mvvmexp.app.entities.toViewStory
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.app.utils.Resource
import com.salimisler.mvvmexp.ui.fragments.PostsFragmentViewModel

class PostsFragmentPresenter : PostsFragmentContract.Presenter {
    private lateinit var view: PostsFragmentContract.View
    private lateinit var viewModel: PostsFragmentViewModel

    private var storyList: List<ViewStory>? = null

    override fun setViewModel(viewModel: PostsFragmentViewModel) {
        this.viewModel = viewModel
    }

    override fun setView(view: PostsFragmentContract.View) {
        this.view = view
    }

    override fun onStart() {
        view.setPostsEpoxyController()
        view.setPostsEpoxyAdapter()
        view.setStoriesEpoxyController()
        view.setListener(this)
        view.setContext((view as PostsFragment).requireContext())

        viewModel.getPostsData().observe(view as PostsFragment, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        view.setPostData(it.toViewPost())
                        view.setPostCommentData(viewModel.getPostCommentData())
                        view.requestModelBuildForPosts()
                    }
                }

                Resource.Status.LOADING -> {

                }

                Resource.Status.ERROR -> {

                }
            }
        })

        viewModel.getStoryData().observe(view as PostsFragment, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    view.setStoryProgressBarVisibility(false)
                    it.data?.let {
                        storyList = it.toViewStory()
                        view.setStoryData(it.toViewStory())

                        viewModel.getStoryStatusData().observe(view as PostsFragment, Observer {
                            view.setStoryStatusData(it.toList())
                            view.requestModelBuildForStroies()
                        })

                        view.requestModelBuildForPosts()
                    }
                }

                Resource.Status.LOADING -> {
                    view.setStoryProgressBarVisibility(true)
                }

                Resource.Status.ERROR -> {
                    view.setStoryProgressBarVisibility(false)
                }
            }
        })
    }

    override fun setOnStoryItemClickListener(story: ViewStory?) {
        viewModel.updateStoryStatusData(story?.id!!)
        view.startStoryFragment()
    }
}