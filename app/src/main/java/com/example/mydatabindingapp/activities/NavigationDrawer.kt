package com.example.mydatabindingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mydatabindingapp.R
import com.example.mydatabindingapp.databinding.ActivityNavigationDrawerBinding
import com.example.mydatabindingapp.fragments.HomeFragment
import com.example.mydatabindingapp.fragments.ProfileFragment
import com.example.mydatabindingapp.fragments.SettingFragment
import com.google.android.material.navigation.NavigationView

class NavigationDrawer : AppCompatActivity() {
    private lateinit var navigationbinding : ActivityNavigationDrawerBinding

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationbinding = DataBindingUtil.setContentView(this,
            R.layout.activity_navigation_drawer
        )




        val drawerLayout : DrawerLayout = navigationbinding.DrawerLayout
        val navView : NavigationView = navigationbinding.navView

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toggle.isDrawerIndicatorEnabled = true

//        navigationbinding.nextactivity.setOnClickListener {
//            val intent = Intent(this@NavigationDrawer, BottomNavigation::class.java)
//            startActivity(intent)
//        }

        replaceFragment(HomeFragment())


        navigationbinding.BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.setting -> replaceFragment(SettingFragment())

                else->{

                }
            }
            true
        }




        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
                R.id.nav_setting -> Toast.makeText(applicationContext,"Clicked Settings",Toast.LENGTH_SHORT).show()
                R.id.nav_sync -> Toast.makeText(applicationContext,"Clicked Sync",Toast.LENGTH_SHORT).show()
                R.id.nav_login -> Toast.makeText(applicationContext,"Clicked Log in",Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext,"Clicked Share",Toast.LENGTH_SHORT).show()


            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }


}