package com.hama.hobbymaster.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hama.hobbymaster.R
import com.hama.hobbymaster.databinding.ActivityMainBinding

import com.hama.hobbymaster.view.category.MenuCategory
import com.hama.hobbymaster.view.home.MenuHome
import com.hama.hobbymaster.view.match.MenuMatch
import com.hama.hobbymaster.view.setting.MenuSetting
import com.hama.hobbymaster.view.sub.MenuSub

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    private lateinit var menuHome: MenuHome
    private lateinit var menuCategory: MenuCategory
    private lateinit var menuSub: MenuSub
    private lateinit var menuMatch: MenuMatch
    private lateinit var menuSetting: MenuSetting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        menuHome = MenuHome.newInstance()
        supportFragmentManager.beginTransaction().replace(binding.fragMain.id,menuHome).commit()

    }



    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.menu_home ->{
                menuHome = MenuHome.newInstance()
                supportFragmentManager.beginTransaction().replace(binding.fragMain.id,menuHome).commit()
            }
            R.id.menu_category ->{
                menuCategory = MenuCategory.newInstance()
                supportFragmentManager.beginTransaction().replace(binding.fragMain.id,menuCategory).commit()
            }
            R.id.menu_sub ->{
                menuSub = MenuSub.newInstance()
                supportFragmentManager.beginTransaction().replace(binding.fragMain.id,menuSub).commit()
            }
            R.id.menu_match ->{
                menuMatch = MenuMatch.newInstance()
                supportFragmentManager.beginTransaction().replace(binding.fragMain.id,menuMatch).commit()
            }
            R.id.menu_setting ->{
                menuSetting = MenuSetting.newInstance()
                supportFragmentManager.beginTransaction().replace(binding.fragMain.id,menuSetting).commit()
            }
        }
        true
    }

}