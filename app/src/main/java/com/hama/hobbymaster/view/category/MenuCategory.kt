package com.hama.hobbymaster.view.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hama.hobbymaster.R
import com.hama.hobbymaster.adapter.CategoryOutRvAdapter
import com.hama.hobbymaster.data.CategoryInRvData
import com.hama.hobbymaster.databinding.MenuCategoryBinding
import com.hama.hobbymaster.viewmodel.CategoryOutRvViewModel
import com.hama.hobbymaster.viewmodel.CategoryViewModel


class MenuCategory : Fragment(){
    companion object {
        const val TAG : String = "MenuCategory"

        fun newInstance() : MenuCategory {
            return MenuCategory()
        }

    }
    private lateinit var binding : MenuCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.menu_category,container,false)
        Log.d(TAG,"MenuCategory")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        binding.categoryViewModel = viewModel


        var categoryList:ArrayList<ArrayList<CategoryInRvData>>

        val categoryOutRvViewModel = ViewModelProvider(this)[CategoryOutRvViewModel::class.java]
        categoryOutRvViewModel.categoryData.observe(requireActivity()){
            categoryList = it
            binding.rvCategoryListOut.apply {
                adapter = CategoryOutRvAdapter(requireContext(),categoryList)
            }
        }

    }
}