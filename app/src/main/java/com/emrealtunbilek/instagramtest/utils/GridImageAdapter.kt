package com.emrealtunbilek.instagramtest.utils

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import com.emrealtunbilek.instagramtest.R
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener
import kotlinx.android.synthetic.main.tek_satir_gridview.view.*

/**
 * Created by Emre on 13.02.2018.
 */
class GridImageAdapter(var gelenContext: Context, resource: Int, var arrayList: ArrayList<String>) : ArrayAdapter<String>(gelenContext, resource, arrayList) {

    private val TAG = "GridImageAdapter";
    var kontrol=0


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var tek_satir_view = convertView
        var viewholder:ViewHolder?=null

        var inflater = LayoutInflater.from(gelenContext)
        if(convertView == null){
            tek_satir_view = inflater.inflate(R.layout.tek_satir_gridview, parent, false)
            Log.e(TAG, "inflate: tetiklendi" );
            viewholder= ViewHolder(tek_satir_view)
            tek_satir_view?.setTag(viewholder)
        }else{
            viewholder=tek_satir_view?.getTag() as ViewHolder
            Log.e(TAG, "inflate: TETIKLENMEDI" + kontrol++);
        }


        var imgURL = arrayList.get(position)
        ImageLoader.getInstance()
                .displayImage(imgURL, viewholder.resim, object : ImageLoadingListener{
                    override fun onLoadingComplete(imageUri: String?, view: View?, loadedImage: Bitmap?) {
                        if(viewholder.progressBar != null){
                            viewholder.progressBar.visibility=View.GONE
                        }
                    }

                    override fun onLoadingStarted(imageUri: String?, view: View?) {
                        if(viewholder.progressBar != null){
                            viewholder.progressBar.visibility=View.VISIBLE
                        }
                    }

                    override fun onLoadingCancelled(imageUri: String?, view: View?) {
                        if(viewholder.progressBar != null){
                            viewholder.progressBar.visibility=View.GONE
                        }
                    }

                    override fun onLoadingFailed(imageUri: String?, view: View?, failReason: FailReason?) {
                        if(viewholder.progressBar != null){
                            viewholder.progressBar.visibility=View.GONE
                        }
                    }

                })


        return tek_satir_view!!
    }

    class ViewHolder(tek_satir:View){

        var resim:ImageView
        var progressBar:ProgressBar

        init {
            this.resim=tek_satir.imvGrid
            this.progressBar=tek_satir.progressBarGrid
        }

    }


}