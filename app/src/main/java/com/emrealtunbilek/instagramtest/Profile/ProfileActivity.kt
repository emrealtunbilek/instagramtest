package com.emrealtunbilek.instagramtest.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.layout_bottom_navigation_view.*

class ProfileActivity : AppCompatActivity() {

    private val TAG = "ProfileActivity";
    private val ACTIVITY_NO = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigationView()
    }


    fun setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: bottom navigation ayarlanıyor");
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavViewBar)
        BottomNavigationViewHelper.enableNavigation(this, bottomNavViewBar)
        var menu=bottomNavViewBar.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }
}
