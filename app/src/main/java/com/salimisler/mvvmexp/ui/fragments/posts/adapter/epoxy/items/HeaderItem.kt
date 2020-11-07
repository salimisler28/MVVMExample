package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.*
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.StoriesController
import kotlinx.android.synthetic.main.item_posts_header.view.*

@EpoxyModelClass(layout = R.layout.item_posts_header)
abstract class HeaderItem : EpoxyModelWithHolder<HeaderItem.ViewHolder>() {
    @EpoxyAttribute
    var context: Context? = null

    @EpoxyAttribute
    var controller: StoriesController? = null

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        holder.apply {

            erv_stories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            erv_stories.adapter = controller?.adapter

        }
    }

    class ViewHolder : EpoxyHolder() {
        lateinit var erv_stories: EpoxyRecyclerView

        override fun bindView(itemView: View) {
            erv_stories = itemView.erv_stories
        }
    }
}