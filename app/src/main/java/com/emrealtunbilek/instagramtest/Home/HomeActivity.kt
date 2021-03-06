package com.emrealtunbilek.instagramtest.Home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.emrealtunbilek.instagramtest.Login.LoginActivity
import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.BottomNavigationViewHelper
import com.emrealtunbilek.instagramtest.utils.SectionsPagerAdapter
import com.emrealtunbilek.instagramtest.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.layout_bottom_navigation_view.*
import kotlinx.android.synthetic.main.layout_center_viewpager.*
import kotlinx.android.synthetic.main.layout_top_tabs.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class HomeActivity : AppCompatActivity() {

    private val TAG = "HomeActivity";
    private val ACTIVITY_NO = 0;

    private var mAuth: FirebaseAuth? = null
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupFirebaseAuth()
        mAuth?.signOut()

        initImageLoader()
        setupBottomNavigationView()

        setupViewPager()
    }


    private fun setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: bottom navigation ayarlanıyor");
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavViewBar)
        BottomNavigationViewHelper.enableNavigation(this, bottomNavViewBar)
        var menu = bottomNavViewBar.menu
        var menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }


    private fun setupViewPager() {
        var sectionViewPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionViewPagerAdapter.addFragment(CameraFragment())
        sectionViewPagerAdapter.addFragment(HomeFragment())
        sectionViewPagerAdapter.addFragment(MessageFragment())

        viewPager.adapter = sectionViewPagerAdapter

        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)?.setIcon(R.drawable.ic_camera)
        tabs.getTabAt(1)?.setIcon(R.drawable.logo)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_arrow)

        viewPager.setCurrentItem(1)
    }

    fun initImageLoader() {
        var universalImageLoader = UniversalImageLoader(applicationContext)
        ImageLoader.getInstance().init(universalImageLoader.getConfig())
    }

    fun setupFirebaseAuth() {

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener { p0 ->
            var user = p0?.currentUser
            checkCurrentUser(user)

            if (user != null) {
                Log.d(TAG, "onAuthStateChanged: Kullanıcı bağlı:" + user.uid);
            } else {
                Log.d(TAG, "onAuthStateChanged: Kullanıcı bağlı değil");
            }
        }
    }

    fun checkCurrentUser(user:FirebaseUser?){
        if(user == null){
            val intent=Intent(this@HomeActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        mAuth?.addAuthStateListener(mAuthListener!!)
        checkCurrentUser(mAuth?.currentUser)
    }

    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) {
            mAuth?.removeAuthStateListener(mAuthListener!!)
        }
    }
}
