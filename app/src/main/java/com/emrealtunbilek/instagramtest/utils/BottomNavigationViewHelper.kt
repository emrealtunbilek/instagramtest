package com.emrealtunbilek.instagramtest.utils


import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem
import com.emrealtunbilek.instagramtest.*
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

/**
 * Created by Emre on 12.02.2018.
 */
class BottomNavigationViewHelper {


    companion object {
        private val TAG = "BottomNavigationViewHlp";
        fun setupBottomNavigationView(bottomNavigationViewEx: BottomNavigationViewEx){
            Log.d(TAG, "setupBottomNavigationView: ayarlanıyor");
            bottomNavigationViewEx.enableAnimation(false)
            bottomNavigationViewEx.enableItemShiftingMode(false)
            bottomNavigationViewEx.enableShiftingMode(false)
        }


        fun enableNavigation(context: Context, bottomNavigationViewEx: BottomNavigationViewEx){
            bottomNavigationViewEx.onNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.ic_home -> {
                            val intent=Intent(context, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }

                        R.id.ic_search -> {
                            val intent=Intent(context, SearchActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }

                        R.id.ic_share -> {
                            val intent=Intent(context, ShareActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.ic_likes -> {
                            val intent=Intent(context, LikesActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }

                        R.id.ic_user -> {
                            val intent=Intent(context, ProfileActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }


                    }


                    return false
                }

            }
        }
    }
}