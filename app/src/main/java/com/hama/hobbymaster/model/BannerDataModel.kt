package com.hama.hobbymaster.model

import com.hama.hobbymaster.R
import com.hama.hobbymaster.data.BannerData

class BannerDataModel (){
    init {

    }
    fun updateBannerData() : ArrayList<BannerData>{
        val list: ArrayList<BannerData> = ArrayList()
        list.add(BannerData(R.drawable.banner1, list.size+1))
        list.add(BannerData(R.drawable.banner2, list.size+1))
        list.add(BannerData(R.drawable.banner3, list.size+1))
        return list
    }
}