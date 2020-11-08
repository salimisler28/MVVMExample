package com.salimisler.mvvmexp.ui.fragments.posts.adapter.epoxy.items

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.viewentities.ViewPost
import com.salimisler.mvvmexp.ui.fragments.posts.PostsListener
import kotlinx.android.synthetic.main.item_posts_post.view.*

@EpoxyModelClass(layout = R.layout.item_posts_post)
abstract class PostItem : EpoxyModelWithHolder<PostItem.ViewHolder>() {
    @EpoxyAttribute
    var listener: PostsListener? = null

    @EpoxyAttribute
    var post: ViewPost? = null

    @EpoxyAttribute
    var commentCount: String? = null

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        holder.apply {
            Glide.with(img_source)
                .load(post?.sourceImageUrl)
                .into(img_source)

            tx_source.text = post?.source
            tx_kind.text = post?.kind

            Glide.with(img_header)
                .load(post?.postImageUrl)
                .into(img_header)

            tx_header.text = post?.title
            tx_body.text = post?.body
            tx_comment_count.text = commentCount
        }
    }

    class ViewHolder : EpoxyHolder() {
        lateinit var img_source: ImageView
        lateinit var tx_source: TextView
        lateinit var tx_kind: TextView
        lateinit var img_header: ImageView
        lateinit var tx_header: TextView
        lateinit var tx_body: TextView
        lateinit var tx_comment_count: TextView

        override fun bindView(itemView: View) {
            img_source = itemView.img_source
            tx_source = itemView.tx_source
            tx_kind = itemView.tx_kind
            img_header = itemView.img_header
            tx_header = itemView.tx_header
            tx_body = itemView.tx_body
            tx_comment_count = itemView.tx_comment_count
        }
    }

}