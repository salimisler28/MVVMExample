package com.salimisler.mvvmexp.ui.fragments.posts

import androidx.lifecycle.Observer
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.toViewStory
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.app.utils.Resource

class PostsFragmentPresenter : PostsFragmentContract.Presenter {
    private lateinit var view: PostsFragmentContract.View
    private lateinit var viewModel: PostsFragmentViewModel

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
                    it.data?.let {
                        view.setStoryData(it.toViewStory())
                        view.setStoryStatusData(viewModel.getStoryStatusData())
                        view.requestModelBuildForStroies()
                        view.requestModelBuildForPosts()
                    }
                }

                Resource.Status.LOADING -> {

                }

                Resource.Status.ERROR -> {

                }
            }
        })


    }

    override fun setOnStoryItemClickListener(story: ViewStory?) {
        viewModel.updateStoryStatusData(story?.id!!)
        view.requestModelBuildForStroies()
    }
}