package com.salimisler.mvvmexp.app.data.remote

import com.salimisler.mvvmexp.app.entities.serviceentities.ServicePost
import com.salimisler.mvvmexp.app.entities.serviceentities.ServiceStory
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("posts")
    suspend fun getPosts(): Response<List<ServicePost>>

    @GET("posts/{postId}")
    suspend fun getPost(@Path("postId") postId: Int): Response<ServicePost>

    @GET("photos")
    suspend fun getPhotos(): Response<List<ServiceStory>>
}