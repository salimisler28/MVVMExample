package com.salimisler.mvvmexp.app.entities.serviceentities

data class ServicePost(
    val id: Int,
    val userId: Int,
    val title: String?,
    val body: String?
)