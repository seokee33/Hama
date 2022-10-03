package com.hama.hobbymaster.model

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hama.hobbymaster.data.CategoryInRvData

class CategoryDataModel {
    var subjects = arrayOf("스포츠", "여행&레저", "컴퓨터", "게임")
    val db = Firebase.firestore
    private var categories = ArrayList<ArrayList<CategoryInRvData>>(4)
//    init {
//        categories.add(ArrayList<CategoryInRvData>())
//        categories.add(ArrayList<CategoryInRvData>())
//        categories.add(ArrayList<CategoryInRvData>())
//        categories.add(ArrayList<CategoryInRvData>())
//    }
    fun getData():ArrayList<ArrayList<CategoryInRvData>>
    {
        db.collection("Category")
                .get()
                .addOnSuccessListener { result ->
                    for(document in result){
                        when(document.get("category").toString()){
                            subjects[0] -> categories[0].add(CategoryInRvData(document.get("name").toString(),document.get("category").toString(),document.get("img").toString()))
                            subjects[1] -> categories[1].add(CategoryInRvData(document.get("name").toString(),document.get("category").toString(),document.get("img").toString()))
                            subjects[2] -> categories[2].add(CategoryInRvData(document.get("name").toString(),document.get("category").toString(),document.get("img").toString()))
                            subjects[3] -> categories[3].add(CategoryInRvData(document.get("name").toString(),document.get("category").toString(),document.get("img").toString()))
                        }
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("CategoryDataModel",exception)
                }
        return categories
    }
}