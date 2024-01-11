package com.bipin.recipieapp.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object BindingAdapters {
    @BindingAdapter(value = ["setImageUrl", "placeHolder"], requireAll = false)
    @JvmStatic
    fun setImageUrl(
        imageView: ImageView,
        url: String?,
        placeHolder: Drawable? = null,
    ) {
        when {
            url.isNullOrEmpty() && placeHolder == null -> return
            url.isNullOrEmpty() && placeHolder != null -> Glide.with(imageView).load(placeHolder)
                .into(imageView)
            !url.isNullOrEmpty() && placeHolder == null -> Glide.with(imageView).load(url)
                .into(imageView)
            !url.isNullOrEmpty() && placeHolder != null -> Glide.with(imageView).load(url)
                .placeholder(placeHolder).error(placeHolder).into(imageView)
        }
    }



    @BindingAdapter(
        value = ["setRecyclerAdapter", "rvScrollListener", "rvSwipe"],
        requireAll = false
    )
    @JvmStatic
    fun setRecyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>?,
        listener: RecyclerView.OnScrollListener?,
        swipeListener: ItemTouchHelper.SimpleCallback?,
    ) {
        recyclerView.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        adapter?.let {
            recyclerView.adapter = it
        }
        listener?.let { recyclerView.addOnScrollListener(listener) }
        swipeListener?.let {
            val checker = ItemTouchHelper(it)
            checker.attachToRecyclerView(recyclerView)
        }
    }


}