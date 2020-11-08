package com.salimisler.mvvmexp.ui.fragments.posts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.salimisler.mvvmexp.app.entities.serviceentities.ServicePost
import com.salimisler.mvvmexp.app.entities.serviceentities.ServiceStory
import com.salimisler.mvvmexp.app.repositories.ServiceRepository
import com.salimisler.mvvmexp.app.utils.Resource

class PostsFragmentViewModel @ViewModelInject constructor(
    private var serviceRepo: ServiceRepository
) : ViewModel() {
    private val postData = serviceRepo.getPosts()
    private val storyData = serviceRepo.getStories()
    private val storyStatusData = createStoryStatusData()
    private val postCommentData = createPostCommentData()

    fun getPostsData(): LiveData<Resource<List<ServicePost>>> {
        return postData
    }

    fun getStoryData(): LiveData<Resource<List<ServiceStory>>> {
        return storyData
    }

    fun getStoryStatusData(): List<StoryStatus> {
        return storyStatusData
    }

    fun getPostCommentData(): List<PostComment> {
        return postCommentData
    }

    fun updateStoryStatusData(id: Int) {
        for (item in storyStatusData) {
            if (item.id == id) {
                item.seen = true
                break
            }
        }
    }

    private fun createStoryStatusData(): MutableList<StoryStatus> {
        val list = mutableListOf<StoryStatus>()

        val id1 = StoryStatus(
            1,
            true
        )
        val id2 = StoryStatus(
            2,
            false
        )
        val id3 = StoryStatus(
            3,
            false
        )
        val id4 = StoryStatus(
            4,
            false
        )
        val id5 = StoryStatus(
            5,
            false
        )
        list.add(id1)
        list.add(id2)
        list.add(id3)
        list.add(id4)
        list.add(id5)
        return list
    }

    private fun createPostCommentData(): MutableList<PostComment> {
        val list = mutableListOf<PostComment>()

        val id1 = PostComment(
            1,
            3
        )
        val id2 = PostComment(
            2,
            1
        )
        val id3 = PostComment(
            3,
            61
        )
        val id4 = PostComment(
            4,
            28
        )
        val id5 = PostComment(
            5,
            3
        )
        list.add(id1)
        list.add(id2)
        list.add(id3)
        list.add(id4)
        list.add(id5)
        return list
    }
}

data class StoryStatus(
    var id: Int,
    var seen: Boolean
)

data class PostComment(
    var id: Int,
    var commentCount: Int
)