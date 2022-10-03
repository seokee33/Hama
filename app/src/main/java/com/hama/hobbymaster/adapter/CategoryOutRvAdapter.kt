package com.hama.hobbymaster.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hama.hobbymaster.data.CategoryInRvData
import com.hama.hobbymaster.databinding.RvItemCategoryOutBinding
import com.hama.hobbymaster.viewmodel.CategoryInRvViewModel
import com.hama.hobbymaster.viewmodel.CategoryOutRvViewModel
import com.hama.hobbymaster.viewmodel.ShortCutViewModel

class CategoryOutRvAdapter(private val context:Context, private val data:ArrayList<ArrayList<CategoryInRvData>>): RecyclerView.Adapter<CategoryOutRvAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RvItemCategoryOutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(context,binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(var context : Context, var binding: RvItemCategoryOutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArrayList<CategoryInRvData>) {
            binding.tvCategoryListSub.text = item[0].category
            binding.rvCategoryListIn.adapter = CategoryInRvAdapter(context, item)
            binding.rvCategoryListIn.layoutManager = LinearLayoutManager(context)
        }
    }

}