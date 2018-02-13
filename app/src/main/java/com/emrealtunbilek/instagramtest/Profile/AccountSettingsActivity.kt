package com.emrealtunbilek.instagramtest.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.emrealtunbilek.instagramtest.R
import kotlinx.android.synthetic.main.layout_center_accountsettings.*
import kotlinx.android.synthetic.main.snippet_top_accountsettingtoolbar.*

class AccountSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accountsettings)

        setupSettingsList()

        backArrow.setOnClickListener {
            finish()
        }
    }

    fun setupSettingsList(){
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, resources.getStringArray(R.array.edit_profile_options))
        lvAccountSettings.adapter=adapter

    }
}
