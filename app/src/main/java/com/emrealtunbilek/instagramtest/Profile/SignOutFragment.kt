package com.emrealtunbilek.instagramtest.Profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emrealtunbilek.instagramtest.R

/**
 * Created by Emre on 13.02.2018.
 */
class SignOutFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater!!.inflate(R.layout.fragment_signout, container, false)

        return view
    }
}