package com.hama.hobbymaster.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.hama.hobbymaster.R
import com.hama.hobbymaster.adapter.BannerVpAdapter
import com.hama.hobbymaster.adapter.ShortCutRvAdapter
import com.hama.hobbymaster.data.BannerData
import com.hama.hobbymaster.data.ShortCut
import com.hama.hobbymaster.databinding.MenuHomeBinding
import com.hama.hobbymaster.viewmodel.BannerRvViewModel
import com.hama.hobbymaster.viewmodel.HomeViewModel
import com.hama.hobbymaster.viewmodel.ShortCutViewModel
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
    var bannerData2 = MutableLiveData<ArrayList<BannerData>>()
    var bannerData = ArrayList<BannerData>()

    //shortcut
    var shortCutData = ArrayList<ShortCut>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel


        //banner
        val bannerRvViewModel = ViewModelProvider(this)[BannerRvViewModel::class.java]
        bannerRvViewModel.bannerData.observe(requireActivity()) {
            bannerData = it
            bannerPosition = Int.MAX_VALUE / 2 - ceil(bannerData.size.toDouble() / 2).toInt()
            binding.vpBanner.setCurrentItem(bannerPosition, false)
            binding.vpBanner.apply {
                binding.vpBanner.adapter = BannerVpAdapter(bannerRvViewModel.bannerData)
                binding.vpBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL

                binding.tvBannerPage.text = "1 / "+bannerRvViewModel.bannerData.value!!.size+" 모두보기"

                binding.vpBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        binding.tvBannerPage.text = bannerRvViewModel.bannerData.value!!.get(position % bannerRvViewModel.bannerData.value!!.size).title.toString() + " / "+bannerRvViewModel.bannerData.value!!.size+" 모두보기"
                    }
                })
            }
        }

        //shortcut
        val shortCutViewModel = ViewModelProvider(this)[ShortCutViewModel::class.java]
        shortCutViewModel.shortCutData.observe(requireActivity()) {
                shortCutData = it
                binding.rvShortcut.apply{
                adapter = ShortCutRvAdapter(shortCutData)
            }

        }

    }
}