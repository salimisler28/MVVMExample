package com.salimisler.mvvmexp.app.data.remote

import com.salimisler.mvvmexp.app.base.BaseDataSource

class ServiceDataSource (
    private val service: Service
): BaseDataSource() {
    suspend fun getPosts() = getResult { service.getPosts() }
    suspend fun getPost(postId: Int) = getResult { service.getPost(postId) }
    suspend fun getStories() = getResult { service.getPhotos() }
}