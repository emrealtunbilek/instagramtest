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

/**
 * Created by Emre on 13.02.2018.
 */
class EditProfileFragment : Fragment() {

    lateinit var profileImage: ImageView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_editprofile, container, false)
        profileImage = view?.findViewById(R.id.profile_photo)!!

        initImageLoader()

        setProfileImage()
        return view
    }

    fun initImageLoader(){
        var universalImageLoader=UniversalImageLoader(activity)
        ImageLoader.getInstance().init(universalImageLoader.getConfig())
    }

    fun setProfileImage() {
        var imageURL = "http://emrealtunbilek.com/wp-content/uploads/2016/10/apple-icon-72x72.png"
        UniversalImageLoader.setImage(imageURL, profileImage,null,"")
    }
}