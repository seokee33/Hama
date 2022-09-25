package com.hama.hobbymaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hama.hobbymaster.R
import com.hama.hobbymaster.model.*

class HomeViewModel :ViewModel() {

    private lateinit var homeModel: HomeModel
    private var shortCutModel :ShortCutModel = ShortCutModel()
    private var bannerDataModel:BannerDataModel = BannerDataModel()

    //banner
    var bannerLiveData : MutableLiveData<ArrayList<BannerData>> = MutableLiveData<ArrayList<BannerData>>()

    //shortcut
    var shortCutLiveData : MutableLiveData<ArrayList<ShortCut>> = MutableLiveData<ArrayList<ShortCut>>()

    init{
        shortCutLiveData.postValue(shortCutModel.updateShortCutData())
        bannerLiveData.postValue(bannerDataModel.updateBannerData())
    }






}