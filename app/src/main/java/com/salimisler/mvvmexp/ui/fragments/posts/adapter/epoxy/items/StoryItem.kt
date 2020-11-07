package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.viewentities.ViewStory
import com.salimisler.mvvmexp.ui.fragments.posts.PostsListener
import kotlinx.android.synthetic.main.item_posts_story.view.*

@EpoxyModelClass(layout = R.layout.item_posts_story)
abstract class StoryItem : EpoxyModelWithHolder<StoryItem.ViewHolder>() {
    @EpoxyAttribute
    var listener: PostsListener? = null

    @EpoxyAttribute
    var story: ViewStory? = null

    @EpoxyAttribute
    var backgroundResource: Int? = null

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        holder.apply {
            Glide.with(img_story)
                .load(story?.thumbnailUrl)
                .into(img_story)

            cl_story.setBackgroundResource(backgroundResource!!)

            img_story.setOnClickListener {
                listener?.setOnStoryItemClickListener(story)
            }

            tx_story.setOnClickListener {
                listener?.setOnStoryItemClickListener(story)
            }
        }
    }

    class ViewHolder : EpoxyHolder() {
        lateinit var cl_story: ConstraintLayout
        lateinit var img_story: ImageView
        lateinit var tx_story: TextView

        override fun bindView(itemView: View) {
            cl_story = itemView.cl_story
            img_story = itemView.img_story
            tx_story = itemView.tx_story
        }
    }
}