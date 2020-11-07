package com.salimisler.mvvmexp.app.repositories

import com.salimisler.mvvmexp.app.data.remote.ServiceDataSource
import com.salimisler.mvvmexp.app.utils.performGetOperation

class ServiceRepository(
    private val remoteDataSource: ServiceDataSource
) {
    fun getPosts() = performGetOperation {
        remoteDataSource.getPosts()
    }

    fun getPost(postId: Int) = performGetOperation {
        remoteDataSource.getPost(postId)
    }

    fun getStories() = performGetOperation {
        remoteDataSource.getStories()
    }
}