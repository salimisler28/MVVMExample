package com.salimisler.mvvmexp.ui.fragments.story

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.utils.Constants.STREAM_URL
import kotlinx.android.synthetic.main.fragment_story_item.*

class StoryItemFragment : Fragment() {

    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: DataSource.Factory
    private lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_story_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isVisible) {

            simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(ctx)

            mediaDataSourceFactory = DefaultDataSourceFactory(
                ctx, Util.getUserAgent(
                    ctx,
                    "mediaPlayerSample"
                )
            )

            val mediaSource = ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(
                Uri.parse(STREAM_URL)
            )

            simpleExoPlayer.prepare(mediaSource, false, false)
            simpleExoPlayer.playWhenReady = true

            epv.setShutterBackgroundColor(Color.TRANSPARENT)
            epv.player = simpleExoPlayer
            epv.requestFocus()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) = StoryItemFragment()
    }
}