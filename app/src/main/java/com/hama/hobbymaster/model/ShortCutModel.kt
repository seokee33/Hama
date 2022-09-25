package com.hama.hobbymaster.model

import com.hama.hobbymaster.R

class ShortCutModel {
    init {

    }
    fun updateShortCutData() : ArrayList<ShortCut>{
        val shortCutData = ArrayList<ShortCut>()
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"추천 취미"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"2"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"3"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"4"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"5"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"6"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"7"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"8"))
        shortCutData.add(ShortCut(R.drawable.ic_app_icon,"9"))
        return shortCutData
    }
}