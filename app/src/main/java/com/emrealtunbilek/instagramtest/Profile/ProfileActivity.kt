package com.emrealtunbilek.instagramtest.Profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.BottomNavigationViewHelper
import com.emrealtunbilek.instagramtest.utils.GridImageAdapter
import com.emrealtunbilek.instagramtest.utils.UniversalImageLoader
import kotlinx.android.synthetic.main.layout_bottom_navigation_view.*
import kotlinx.android.synthetic.main.layout_center_profile.*
import kotlinx.android.synthetic.main.snippet_top_profilebar.*

class ProfileActivity : AppCompatActivity() {

    private val TAG = "ProfileActivity";
    private val ACTIVITY_NO = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBottomNavigationView()

        setupToolbar()

        setProfileImage()

        tempGridSetup()
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
        profileMenu.setOnClickListener {
            var i=Intent(this@ProfileActivity, AccountSettingsActivity::class.java)
            startActivity(i)
        }
        setSupportActionBar(profileToolbar)
    }

    fun setProfileImage(){
        var imageURL="http://emrealtunbilek.com/wp-content/uploads/2016/10/apple-icon-72x72.png"
        UniversalImageLoader.setImage(imageURL, profile_image,null,"")
    }

    private fun tempGridSetup() {
        val imgURLs = ArrayList<String>()
        imgURLs.add("https://img.youtube.com/vi/twZggnNbFqo/maxresdefault.jpg")
        imgURLs.add("http://emrealtunbilek.com/wp-content/uploads/2016/10/apple-icon-72x72.png")
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg")
        imgURLs.add("https://www.indir.vip/wp-content/uploads/2016/05/android.jpg")
        imgURLs.add("http://images.indianexpress.com/2018/01/android-main.jpg")
        imgURLs.add("https://voipfreak.net/wp-content/uploads/2014/01/Android-Applications.jpg")
        imgURLs.add("https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/82e2630d-ede6-4f7b-ba9a-e7b8a043f7e2/1.jpg")
        imgURLs.add("http://www.teknolopi.com/wp-content/uploads/2015/06/kaybolan-akilli-telefon-nasil-bulunur.jpg")
        imgURLs.add("http://makeitappeu.s3.amazonaws.com/wp-content/uploads/2015/06/15112640/Android-HD-Desktop-Wallpaper.jpg")
        imgURLs.add("http://www.sharingame.org/media/url3.jpg")
        imgURLs.add("http://www.androidwallpper.com/wp-content/uploads/2017/01/blue-machine-android-wallpaper-for-mobile.jpg")
        imgURLs.add("https://img.youtube.com/vi/twZggnNbFqo/maxresdefault.jpg")
        imgURLs.add("http://emrealtunbilek.com/wp-content/uploads/2016/10/apple-icon-72x72.png")
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg")
        imgURLs.add("https://www.indir.vip/wp-content/uploads/2016/05/android.jpg")
        imgURLs.add("http://images.indianexpress.com/2018/01/android-main.jpg")
        imgURLs.add("https://voipfreak.net/wp-content/uploads/2014/01/Android-Applications.jpg")
        imgURLs.add("https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/82e2630d-ede6-4f7b-ba9a-e7b8a043f7e2/1.jpg")
        imgURLs.add("http://www.teknolopi.com/wp-content/uploads/2015/06/kaybolan-akilli-telefon-nasil-bulunur.jpg")
        imgURLs.add("http://makeitappeu.s3.amazonaws.com/wp-content/uploads/2015/06/15112640/Android-HD-Desktop-Wallpaper.jpg")
        imgURLs.add("http://www.sharingame.org/media/url3.jpg")
        imgURLs.add("http://www.androidwallpper.com/wp-content/uploads/2017/01/blue-machine-android-wallpaper-for-mobile.jpg")
        imgURLs.add("https://img.youtube.com/vi/twZggnNbFqo/maxresdefault.jpg")
        imgURLs.add("http://emrealtunbilek.com/wp-content/uploads/2016/10/apple-icon-72x72.png")
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg")
        imgURLs.add("https://www.indir.vip/wp-content/uploads/2016/05/android.jpg")
        imgURLs.add("http://images.indianexpress.com/2018/01/android-main.jpg")
        imgURLs.add("https://voipfreak.net/wp-content/uploads/2014/01/Android-Applications.jpg")
        imgURLs.add("https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/82e2630d-ede6-4f7b-ba9a-e7b8a043f7e2/1.jpg")
        imgURLs.add("http://www.teknolopi.com/wp-content/uploads/2015/06/kaybolan-akilli-telefon-nasil-bulunur.jpg")
        imgURLs.add("http://makeitappeu.s3.amazonaws.com/wp-content/uploads/2015/06/15112640/Android-HD-Desktop-Wallpaper.jpg")
        imgURLs.add("http://www.sharingame.org/media/url3.jpg")
        imgURLs.add("http://www.androidwallpper.com/wp-content/uploads/2017/01/blue-machine-android-wallpaper-for-mobile.jpg")


        setupImageGrid(imgURLs)
    }

    fun setupImageGrid(imgURLs:ArrayList<String>){
        var myadapter=GridImageAdapter(this,R.layout.tek_satir_gridview, imgURLs)
        gridView.adapter=myadapter
    }


}
