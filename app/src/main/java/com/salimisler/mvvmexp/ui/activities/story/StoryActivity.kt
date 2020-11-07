package com.salimisler.mvvmexp.ui.activities.story

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.salimisler.mvvmexp.R

class StoryActivity : AppCompatActivity() {
    var id: Int? = null
    var bigImageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val bundle = intent.extras
        id = bundle?.getInt("storyId")
        bigImageUrl = bundle?.getString("storyBigImageUrl")

    }
}