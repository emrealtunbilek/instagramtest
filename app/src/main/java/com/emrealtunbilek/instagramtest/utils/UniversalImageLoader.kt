package com.emrealtunbilek.instagramtest.utils

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.emrealtunbilek.instagramtest.R
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener

/**
 * Created by Emre on 13.02.2018.
 */
class UniversalImageLoader(context: Context) {

    var myContext = context
    var defaultImage = R.drawable.ic_user

    companion object {


        fun setImage(imgURL: String, image: ImageView, progressBar:ProgressBar?, append:String){
                var imageLoader=ImageLoader.getInstance()
            imageLoader.displayImage(append+imgURL,image, object :ImageLoadingListener{
                override fun onLoadingComplete(imageUri: String?, view: View?, loadedImage: Bitmap?) {
                    if(progressBar != null){
                        progressBar.visibility=View.GONE
                    }
                }

                override fun onLoadingStarted(imageUri: String?, view: View?) {
                   if(progressBar != null){
                       progressBar.visibility=View.VISIBLE
                   }
                }

                override fun onLoadingCancelled(imageUri: String?, view: View?) {
                    if(progressBar != null){
                        progressBar.visibility=View.GONE
                    }
                }

                override fun onLoadingFailed(imageUri: String?, view: View?, failReason: FailReason?) {
                    if(progressBar != null){
                        progressBar.visibility=View.GONE
                    }
                }

            })
        }
    }

    fun getConfig(): ImageLoaderConfiguration {

        var defaultOption = DisplayImageOptions.Builder()
                .showImageForEmptyUri(defaultImage)
                .showImageOnLoading(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(FadeInBitmapDisplayer(300)).build()

        var configuration = ImageLoaderConfiguration.Builder(myContext)
                .defaultDisplayImageOptions(defaultOption)
                .memoryCache(WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024).build()

        return configuration
    }


}