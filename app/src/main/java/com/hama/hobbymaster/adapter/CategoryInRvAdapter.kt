package com.hama.hobbymaster.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.hama.hobbymaster.data.CategoryInRvData
import com.hama.hobbymaster.databinding.RvItemCategoryInBinding

class CategoryInRvAdapter (context: Context, val itemList: ArrayList<CategoryInRvData>): RecyclerView.Adapter<CategoryInRvAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RvItemCategoryInBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.bind(item)


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: RvItemCategoryInBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryInRvData) {
            binding.rvCategoryInModel = item
        }
    }
}