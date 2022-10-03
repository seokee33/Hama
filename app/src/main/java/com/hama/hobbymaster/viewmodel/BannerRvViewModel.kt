package com.hama.hobbymaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hama.hobbymaster.data.BannerData
import com.hama.hobbymaster.model.BannerDataModel

class BannerRvViewModel: ViewModel() {

    private var bannerDataModel: BannerDataModel = BannerDataModel()


    //banner
    private val _bannerData = MutableLiveData<ArrayList<BannerData>>()

    val bannerData: LiveData<ArrayList<BannerData>>
        get() = _bannerData

    init{
        //banner
        _bannerData.value = bannerDataModel.updateBannerData()
    }

    fun updateValue(){
        _bannerData.postValue(bannerDataModel.updateBannerData())
    }
}