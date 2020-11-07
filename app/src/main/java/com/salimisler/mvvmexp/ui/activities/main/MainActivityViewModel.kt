package com.salimisler.mvvmexp.ui.activities.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.salimisler.mvvmexp.app.repositories.ServiceRepository

class MainActivityViewModel @ViewModelInject constructor(
    private val serviceRepository: ServiceRepository
): ViewModel() {
    val posts = serviceRepository.getPosts()

}