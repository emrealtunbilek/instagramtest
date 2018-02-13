package com.emrealtunbilek.instagramtest.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.SectionsPagerAdapter
import com.emrealtunbilek.instagramtest.utils.SectionsStatePagerAdapter
import kotlinx.android.synthetic.main.activity_accountsettings.*
import kotlinx.android.synthetic.main.layout_center_accountsettings.*
import kotlinx.android.synthetic.main.layout_center_viewpager.*
import kotlinx.android.synthetic.main.snippet_top_accountsettingtoolbar.*

class AccountSettingsActivity : AppCompatActivity() {

    lateinit var pagerAdapter: SectionsStatePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accountsettings)

        setupSettingsList()
        setupFragments()

        backArrow.setOnClickListener {
            finish()
        }
    }

    fun setupSettingsList() {
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.edit_profile_options))
        lvAccountSettings.adapter = adapter

        lvAccountSettings.setOnItemClickListener { parent, view, position, id ->
            setViewPager(position)
        }


    }

    fun setupFragments() {
        pagerAdapter = SectionsStatePagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(EditProfileFragment(), resources.getStringArray(R.array.edit_profile_options).get(0))
        pagerAdapter.addFragment(SignOutFragment(), resources.getStringArray(R.array.edit_profile_options).get(1))
    }

    fun setViewPager(fragmentNumbers:Int){
        relLayout1.visibility=View.GONE
        viewPager.adapter=pagerAdapter
        viewPager.setCurrentItem(fragmentNumbers)
    }
}
