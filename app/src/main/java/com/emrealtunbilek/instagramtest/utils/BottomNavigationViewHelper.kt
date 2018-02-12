package com.emrealtunbilek.instagramtest.utils


import android.util.Log
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
    }
}