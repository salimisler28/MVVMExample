package com.salimisler.mvvmexp.app.entities.viewentities

data class ViewPost(
    val id: Int,
    val sourceImageUrl: String?,
    val postImageUrl: String?,
    val source: String?,
    val kind: String?,
    val title: String?,
    val body: String?
)