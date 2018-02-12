package com.emrealtunbilek.instagramtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.emrealtunbilek.instagramtest.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.layout_bottom_navigation_view.*

class LikesActivity : AppCompatActivity() {

    private val TAG = "LikesActivity";
    private val ACTIVITY_NO = 3;

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
