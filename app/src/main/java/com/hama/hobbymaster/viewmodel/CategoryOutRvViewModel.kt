package com.hama.hobbymaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hama.hobbymaster.data.CategoryInRvData
import com.hama.hobbymaster.model.CategoryDataModel

class CategoryOutRvViewModel():ViewModel(){
    private val categoryDataModel : CategoryDataModel = CategoryDataModel()
    var titleList: Array<String>

    private var _categoryData = MutableLiveData<ArrayList<ArrayList<CategoryInRvData>>>()

    val categoryData: LiveData<ArrayList<ArrayList<CategoryInRvData>>>
        get() = _categoryData

    
    init {
        _categoryData.value = categoryDataModel.getData()
        titleList = categoryDataModel.subjects
    }
}