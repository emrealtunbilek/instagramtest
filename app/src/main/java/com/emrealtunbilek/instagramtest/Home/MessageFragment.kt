package com.emrealtunbilek.instagramtest.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emrealtunbilek.instagramtest.R

/**
 * Created by Emre on 12.02.2018.
 */
class MessageFragment : Fragment() {

    private val TAG = "MessageFragment";

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view=inflater.inflate(R.layout.fragment_messages, container, false)

        return view
    }
}