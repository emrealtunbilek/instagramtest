package com.emrealtunbilek.instagramtest.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.layout_bottom_navigation_view.*
import kotlinx.android.synthetic.main.snippet_top_profilebar.*

class ProfileActivity : AppCompatActivity() {

    private val TAG = "ProfileActivity";
    private val ACTIVITY_NO = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
       // setupBottomNavigationView()

        setupToolbar()
    }


    fun setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: bottom navigation ayarlanıyor");
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavViewBar)
        BottomNavigationViewHelper.enableNavigation(this, bottomNavViewBar)
        var menu=bottomNavViewBar.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

    fun setupToolbar(){
        profileToolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.profileMenu -> {
                        return true
                    }
                }
                return false
            }

        })

        setSupportActionBar(profileToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu,menu)
        return true
    }
}
