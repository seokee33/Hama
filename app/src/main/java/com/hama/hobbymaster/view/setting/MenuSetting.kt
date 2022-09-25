package com.hama.hobbymaster.view.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hama.hobbymaster.R
import com.hama.hobbymaster.databinding.MenuSettingBinding
import com.hama.hobbymaster.view.home.MenuHome
import com.hama.hobbymaster.viewmodel.SettingViewModel


class MenuSetting : Fragment() {


    companion object {
        const val TAG: String = "MenuSetting"

        fun newInstance(): MenuSetting {
            return MenuSetting()
        }

    }

    private lateinit var binding: MenuSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu_setting, container, false)
        Log.d(TAG,"MenuSetting")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(SettingViewModel::class.java)
        binding.settingViewModel = viewModel

    }
}