package com.hama.hobbymaster.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object ImgBindingAdapters {
//    @BindingAdapter("app:imageUrl","app:placeholder")
    @JvmStatic fun loadImage(imageView: ImageView, url: String, placeholder: Drawable){
        GlideApp.with(imageView.context)
            .load(url)
            .placeholder(placeholder)
            .error(placeholder)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .apply(RequestOptions().fitCenter())
            .into(imageView)
    }
}