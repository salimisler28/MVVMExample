package com.salimisler.mvvmexp.ui.fragments.story.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.ui.fragments.story.StoryItemFragment

class StoryPagerAdapter(
    private val fragmentManager: FragmentManager,
    private val data: List<ViewStory>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Fragment {
        return StoryItemFragment.newInstance(position)
    }
}