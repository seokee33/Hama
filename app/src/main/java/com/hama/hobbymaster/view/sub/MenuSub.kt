package com.hama.hobbymaster.view.sub

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hama.hobbymaster.R
import com.hama.hobbymaster.databinding.MenuSubBinding
import com.hama.hobbymaster.viewmodel.SubViewModel


class MenuSub : Fragment(){



    companion object {
        const val TAG : String = "MenuSub"

        fun newInstance() : MenuSub {
            return MenuSub()
        }

    }
    private lateinit var binding : MenuSubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.menu_sub,container,false)
        Log.d(TAG,"MenuSub")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(SubViewModel::class.java)
        binding.subViewModel = viewModel

    }
}