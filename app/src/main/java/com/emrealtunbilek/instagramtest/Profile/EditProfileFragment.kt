package com.emrealtunbilek.instagramtest.Profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.snippet_top_editprofiletoolbar.*

/**
 * Created by Emre on 13.02.2018.
 */
class EditProfileFragment : Fragment() {

    lateinit var profileImage: ImageView
    lateinit var backArrow:ImageView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_editprofile, container, false)
        profileImage = view?.findViewById(R.id.profile_photo)!!
        backArrow=view?.findViewById(R.id.backArrow)

        setProfileImage()

        backArrow.setOnClickListener {
            activity.finish()
        }

        return view
    }



    fun setProfileImage() {
        var imageURL = "http://emrealtunbilek.com/wp-content/uploads/2016/10/apple-icon-72x72.png"
        UniversalImageLoader.setImage(imageURL, profileImage,null,"")
    }
}