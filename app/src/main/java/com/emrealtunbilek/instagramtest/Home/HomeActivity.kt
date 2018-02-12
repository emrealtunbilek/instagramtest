package com.emrealtunbilek.instagramtest.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.layout_bottom_navigation_view.*
import kotlinx.android.synthetic.main.layout_center_viewpager.*
import kotlinx.android.synthetic.main.layout_top_tabs.*

class HomeActivity : AppCompatActivity() {

   private val TAG = "HomeActivity";
   private val ACTIVITY_NO = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupBottomNavigationView()

        setupViewPager()
    }


    fun setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: bottom navigation ayarlanıyor");
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavViewBar)
        BottomNavigationViewHelper.enableNavigation(this, bottomNavViewBar)
        var menu=bottomNavViewBar.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }


    fun setupViewPager(){
        var sectionViewPagerAdapter=SectionsPagerAdapter(supportFragmentManager)
        sectionViewPagerAdapter.addFragment(CameraFragment())
        sectionViewPagerAdapter.addFragment(HomeFragment())
        sectionViewPagerAdapter.addFragment(MessageFragment())

        viewPager.adapter=sectionViewPagerAdapter

        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)?.setIcon(R.drawable.ic_camera)
        tabs.getTabAt(1)?.setIcon(R.drawable.logo)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_arrow)

        viewPager.setCurrentItem(1)
    }
}
