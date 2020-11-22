package com.salimisler.mvvmexp.ui.fragments.story

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager.widget.ViewPager
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.toViewStory
import com.salimisler.mvvmexp.ui.activities.main.MainActivity
import com.salimisler.mvvmexp.ui.fragments.PostsFragmentViewModel
import com.salimisler.mvvmexp.ui.fragments.story.adapter.StoryPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_story.*

class StoryFragment : Fragment() {
    private val viewModel: PostsFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).bottomNavigationView.visibility = View.GONE
        vp_story.adapter = StoryPagerAdapter(
            this.requireActivity().supportFragmentManager,
            viewModel.getStoryData().value?.data!!.toViewStory()
        )
        vp_story.offscreenPageLimit = 1
        vp_story.setPageTransformer(true, CubeOutTransformer())
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as MainActivity).bottomNavigationView.visibility = View.VISIBLE
    }
}