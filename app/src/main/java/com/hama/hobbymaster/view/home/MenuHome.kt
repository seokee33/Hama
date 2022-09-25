package com.hama.hobbymaster.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.hama.hobbymaster.R
import com.hama.hobbymaster.adapter.BannerVpAdapter
import com.hama.hobbymaster.adapter.ShortCutRvAdapter
import com.hama.hobbymaster.databinding.MenuHomeBinding
import com.hama.hobbymaster.model.BannerData
import com.hama.hobbymaster.model.ShortCut
import com.hama.hobbymaster.viewmodel.HomeViewModel
import java.lang.Math.ceil


class MenuHome : Fragment() {
    companion object {
        const val TAG: String = "MenuHome"

        fun newInstance(): MenuHome {
            return MenuHome()
        }

    }

    private lateinit var binding: MenuHomeBinding

    //banner
    private var bannerPosition : Int = 0
    var bannerData = MutableLiveData<ArrayList<BannerData>>()


    //shortcut
    private lateinit var rv_ShortCut_Manager: RecyclerView.LayoutManager
    var shortCutData = MutableLiveData<ArrayList<ShortCut>>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu_home, container, false)
        Log.d(TAG, "MenuHome")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel


        //banner
        val bannerDataObserver: Observer<ArrayList<BannerData>> =
            Observer { livedata->
                bannerData.value = livedata
                bannerPosition =
                    Int.MAX_VALUE / 2 - ceil(bannerData.value!!.size.toDouble() / 2).toInt()
                binding.vpBanner.setCurrentItem(bannerPosition, false)
                binding.vpBanner.apply {
                    binding.vpBanner.adapter = BannerVpAdapter(homeViewModel.bannerLiveData)
                    binding.vpBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL

                    binding.tvBannerPage.text = "1 / "+homeViewModel.bannerLiveData.value!!.size+" 모두보기"

                    binding.vpBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                            binding.tvBannerPage.text = homeViewModel.bannerLiveData.value!!.get(position % homeViewModel.bannerLiveData.value!!.size).title.toString() + " / "+homeViewModel.bannerLiveData.value!!.size+" 모두보기"
                        }
                    })
                }
            }
        homeViewModel.bannerLiveData.observe(requireActivity(),bannerDataObserver)




        //shortcut
        val shortCutDataObserver: Observer<ArrayList<ShortCut>> =
            Observer { livedata ->
                shortCutData.value = livedata

                binding.rvShortcut.apply{
                    adapter = ShortCutRvAdapter(shortCutData)
                }
            }
        homeViewModel.shortCutLiveData.observe(requireActivity(), shortCutDataObserver)


        //


    }
}