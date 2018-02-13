package com.emrealtunbilek.instagramtest.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Emre on 12.02.2018.
 */
class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private var mFragmentList: ArrayList<Fragment> = ArrayList<Fragment>()


    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }
}