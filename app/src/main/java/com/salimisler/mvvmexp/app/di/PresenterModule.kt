package com.salimisler.mvvmexp.app.di

import com.salimisler.mvvmexp.ui.activities.main.MainActivityPresenter
import com.salimisler.mvvmexp.ui.fragments.posts.PostsFragmentPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object PresenterModule {
    @Provides
    fun provideMainPresenter() =
        MainActivityPresenter()

    @Provides
    fun providePostsFragmentPresenter() =
        PostsFragmentPresenter()
}