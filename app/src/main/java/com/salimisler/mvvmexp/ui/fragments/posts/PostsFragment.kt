package com.salimisler.mvvmexp.ui.fragments.posts

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.ui.fragments.PostComment
import com.salimisler.mvvmexp.ui.fragments.PostsFragmentViewModel
import com.salimisler.mvvmexp.ui.fragments.StoryStatus
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.PostsController
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.StoriesController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

@AndroidEntryPoint
class PostsFragment : Fragment(),
    PostsFragmentContract.View {
    private val postsFragmentViewModel: PostsFragmentViewModel by activityViewModels()

    @Inject
    lateinit var presenter: PostsFragmentPresenter
    private lateinit var postsController: PostsController
    private lateinit var storiesController: StoriesController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("PostsFragment", "onCreateView run")
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("PostsFragment", "onViewCreated run")

        presenter.setViewModel(postsFragmentViewModel)
        presenter.setView(this)
        presenter.onStart()
    }

    override fun setPostsEpoxyController() {
        postsController =
            PostsController()
    }

    override fun setStoriesEpoxyController() {
        storiesController =
            StoriesController()
        postsController.controller = storiesController
    }

    override fun setPostsEpoxyAdapter() {
        erv_posts.layoutManager = LinearLayoutManager(this.requireActivity())
        erv_posts.adapter = postsController.adapter
    }

    override fun requestModelBuildForPosts() {
        postsController.requestModelBuild()
    }

    override fun requestModelBuildForStroies() {
        storiesController.requestModelBuild()
    }

    override fun setContext(context: Context) {
        postsController.context = context
    }

    override fun setListener(listener: PostsListener) {
        postsController.listener = listener
        storiesController.listener = listener
    }

    override fun setStoryProgressBarVisibility(value: Boolean) {
        postsController.storyProgressBarVisibility = value
    }

    override fun setPostData(data: List<ViewPost>) {
        postsController.postData = data
    }

    override fun setStoryData(data: List<ViewStory>) {
        storiesController.storyData = data
    }

    override fun setStoryStatusData(data: List<StoryStatus>) {
        storiesController.storyStatusData = data
    }

    override fun setPostCommentData(data: List<PostComment>) {
        postsController.commentCountData = data
    }

    override fun startStoryFragment() {
        findNavController().navigate(R.id.action_postsFragment_to_storyFragment)
    }
}