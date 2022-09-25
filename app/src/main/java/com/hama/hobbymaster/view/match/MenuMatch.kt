package com.hama.hobbymaster.view.match

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hama.hobbymaster.R
import com.hama.hobbymaster.databinding.MenuMatchBinding
import com.hama.hobbymaster.viewmodel.MatchViewModel


class MenuMatch : Fragment() {

    companion object {
        const val TAG: String = "MenuMatch"

        fun newInstance(): MenuMatch {
            return MenuMatch()
        }

    }

    private lateinit var binding: MenuMatchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu_match, container, false)
        Log.d(TAG, "MenuMatch")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MatchViewModel::class.java)
        binding.matchViewModel = viewModel
    }
}