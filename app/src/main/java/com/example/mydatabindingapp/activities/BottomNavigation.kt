package com.example.mydatabindingapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mydatabindingapp.R
import com.example.mydatabindingapp.databinding.ActivityBottomNavigationBinding
import com.example.mydatabindingapp.fragments.HomeFragment
import com.example.mydatabindingapp.fragments.ProfileFragment
import com.example.mydatabindingapp.fragments.SettingFragment

class BottomNavigation : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bottom_navigation)

        replaceFragment(HomeFragment())


        binding.BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.setting -> replaceFragment(SettingFragment())

                else->{

                }
            }
            true
        }



    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}