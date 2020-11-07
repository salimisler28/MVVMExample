package com.salimisler.mvvmexp.app.entities.viewentities

data class ViewPost(
    val id: Int,
    val userId: Int,
    val title: String?,
    val body: String?
)