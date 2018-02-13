package com.emrealtunbilek.instagramtest.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Emre on 13.02.2018.
 */
class SectionsStatePagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var mFragmentList=ArrayList<Fragment>()
    var mFragments=HashMap<Fragment, Int>()
    var mFragmentNumbers=HashMap<String, Int>()
    var mFragmentName=HashMap<Int, String>()


    override fun getItem(position: Int): Fragment {
       return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, fragmentName:String){
        mFragmentList.add(fragment)
        mFragments.put(fragment, mFragmentList.size-1)
        mFragmentNumbers.put(fragmentName, mFragmentList.size-1)
        mFragmentName.put(mFragmentList.size-1, fragmentName)
    }

    fun getFragmentNumber(fragmentName:String):Int?{
        if(mFragmentNumbers.containsKey(fragmentName)){
            return mFragmentNumbers.get(fragmentName)
        }else{
            return null
        }
    }

    fun getFragmentNumber(fragment:Fragment):Int?{
        if(mFragments.containsKey(fragment)){
            return mFragments.get(fragment)
        }else{
            return null
        }
    }

    fun getFragmentName(fragmentNumber:Int):String?{
        if(mFragmentName.containsKey(fragmentNumber)){
            return mFragmentName.get(fragmentNumber)
        }else return null
    }
}