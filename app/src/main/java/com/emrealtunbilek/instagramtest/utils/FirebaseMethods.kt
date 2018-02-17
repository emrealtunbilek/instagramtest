package com.emrealtunbilek.instagramtest.utils

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.emrealtunbilek.instagramtest.R
import kotlinx.android.synthetic.main.activity_register.*


/**
 * Created by Emre on 17.02.2018.
 */
class FirebaseMethods {

    private val TAG = "FirebaseMethods"

    //firebase
    private lateinit var mAuth: FirebaseAuth
    private val mAuthListener: FirebaseAuth.AuthStateListener? = null
    private var userID: String? = null

    private var textView: TextView? = null
    private var progressBar: ProgressBar? = null

    private lateinit var mContext: Context

    constructor(context: Context,progressBar: ProgressBar?,textView: TextView?) {
        mAuth = FirebaseAuth.getInstance()
        mContext = context
        this.textView = textView
        this.progressBar = progressBar

        if (mAuth.currentUser != null) {
            userID = mAuth.currentUser!!.uid
        }
    }

    fun registerNewEmail(email: String, password: String, username: String) {


        progressBarGoster()
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful)

                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful) {
                        Toast.makeText(mContext, "Üye oluşturulamadı:" + task.exception,
                                Toast.LENGTH_SHORT).show()
                        progressBarGizle()
                    } else if (task.isSuccessful) {
                        userID = mAuth.currentUser!!.uid
                        progressBarGizle()
                        Log.d(TAG, "onComplete: Authstate changed: " + userID!!)

                    }
                }

    }

     fun progressBarGizle() {

        if (textView != null) {
            textView?.visibility = View.GONE
        }
        if (progressBar != null) {
            progressBar?.visibility = View.GONE
        }
    }

     fun progressBarGoster() {
        if (textView != null) {
            textView?.visibility = View.VISIBLE
        }
        if (progressBar != null) {
            progressBar?.visibility = View.VISIBLE
        }
    }
}