package com.salimisler.mvvmexp.ui.fragments.posts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salimisler.mvvmexp.R
import com.salimisler.mvvmexp.app.entities.serviceentities.ServicePost
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(
    private val data: List<ServicePost>
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.cl_post.setOnClickListener {

        }

        holder.tx_tittle.text = item.title
        holder.tx_body.text = item.body
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val cl_post = itemview.cl_post
        val tx_tittle = itemview.tx_tittle
        val tx_body = itemview.tx_body
    }
}