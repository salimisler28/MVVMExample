package com.salimisler.mvvmexp.app.base.items

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.salimisler.mvvmexp.R
import kotlinx.android.synthetic.main.item_vertical_space.view.*

@EpoxyModelClass(layout = R.layout.item_vertical_space)
abstract class VerticalSpaceItem : EpoxyModelWithHolder<VerticalSpaceItem.ViewHolder>() {
    @EpoxyAttribute
    var height: Int? = null

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        holder.apply {
            val params: ViewGroup.LayoutParams = ll_space.layoutParams
            params.height = height!!
            ll_space.layoutParams = params
        }
    }

    class ViewHolder : EpoxyHolder() {
        lateinit var ll_space: LinearLayout

        override fun bindView(itemView: View) {
            ll_space = itemView.ll_space
        }
    }
}