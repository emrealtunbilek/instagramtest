package com.emrealtunbilek.instagramtest.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.emrealtunbilek.instagramtest.Home.HomeActivity
import com.emrealtunbilek.instagramtest.R
import com.emrealtunbilek.instagramtest.utils.FirebaseMethods
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private val TAG = "RegisterActivity";

    private var mAuth: FirebaseAuth? = null
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null
    private lateinit var firebaseMethods: FirebaseMethods


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseMethods = FirebaseMethods(this,progressBar,tvlutfenbekleyin)

        progressBar.visibility = View.GONE
        tvlutfenbekleyin.visibility = View.GONE

        setupFirebaseAuth()

        init()
    }

    private fun init() {

        btn_register.setOnClickListener {


            var email = input_email.text.toString()
            var username = input_username.text.toString()
            var password = input_password.text.toString()

            if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty()) {

                firebaseMethods.registerNewEmail(email, password, username)



            } else {
                Toast.makeText(this@RegisterActivity, "Boş alanları doldurunuz", Toast.LENGTH_SHORT).show()

            }



        }

    }



    private fun setupFirebaseAuth() {

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener { p0 ->
            val user = p0.currentUser


            if (user != null) {
                Log.d(TAG, "onAuthStateChanged: Kullanıcı bağlı:" + user.uid);
                var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Log.d(TAG, "onAuthStateChanged: Kullanıcı bağlı değil");
            }
        }
    }

    override fun onStart() {
        super.onStart()
        mAuth?.addAuthStateListener(mAuthListener!!)

    }

    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) {
            mAuth?.removeAuthStateListener(mAuthListener!!)
        }
    }

}
