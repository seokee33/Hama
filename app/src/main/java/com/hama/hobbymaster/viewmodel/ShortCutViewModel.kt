package com.hama.hobbymaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hama.hobbymaster.data.ShortCut
import com.hama.hobbymaster.model.ShortCutModel

class ShortCutViewModel : ViewModel() {

    private var shortCutModel : ShortCutModel = ShortCutModel()
    private val _shortCutData = MutableLiveData<ArrayList<ShortCut>>()
    val shortCutData: LiveData<ArrayList<ShortCut>>
        get() = _shortCutData

    init{
        //shortcut
        _shortCutData.value = shortCutModel.updateShortCutData()
    }

    fun updateValue(){
        _shortCutData.postValue(shortCutModel.updateShortCutData())
    }

}