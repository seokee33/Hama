package com.hama.hobbymaster.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.hama.hobbymaster.databinding.RvMenuhomeShortcutBinding
import com.hama.hobbymaster.model.ShortCut

class ShortCutRvAdapter (private val data: LiveData<ArrayList<ShortCut>>): RecyclerView.Adapter<ShortCutRvAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rvMenuhomeShortcutBinding = RvMenuhomeShortcutBinding.inflate(inflater, parent, false)
        return MyViewHolder(rvMenuhomeShortcutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data.value!!.get(position))
    }

    override fun getItemCount(): Int {
        return data.value!!.size
    }

    inner class MyViewHolder(val binding: RvMenuhomeShortcutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShortCut) {
            binding.ivShortcut.setBackgroundResource(item.img)
            binding.tvShortcut.text = item.name
        }
    }
}