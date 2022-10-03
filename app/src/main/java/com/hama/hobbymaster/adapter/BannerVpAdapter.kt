package com.hama.hobbymaster.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.hama.hobbymaster.R
import com.hama.hobbymaster.databinding.ItemVpBannerBinding
import com.hama.hobbymaster.data.BannerData

class BannerVpAdapter(private val listData: LiveData<ArrayList<BannerData>>) :
    RecyclerView.Adapter<ViewHolderPage>() {
    lateinit var binding: ItemVpBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPage {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_vp_banner,
            parent,
            false
        )
        return ViewHolderPage(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderPage, position: Int) {
        val viewHolder: ViewHolderPage = holder
        viewHolder.onBind(listData.value!!.get(position % listData.value!!.size))
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

}

class ViewHolderPage(val binding: ItemVpBannerBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: BannerData) {
        Log.d("count",data.title.toString())
        binding.ivBannerIMG.setBackgroundResource(data.img)
    }
}