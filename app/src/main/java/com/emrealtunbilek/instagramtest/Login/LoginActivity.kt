package com.emrealtunbilek.instagramtest.Login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.emrealtunbilek.instagramtest.Home.HomeActivity
import com.emrealtunbilek.instagramtest.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity";

    private var mAuth: FirebaseAuth? = null
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressBar.visibility = View.GONE
        tvpleaseawait.visibility = View.GONE

        setupFirebaseAuth()

        init()
    }

    private fun init() {
        btn_login.setOnClickListener {


            val email = input_email.text.toString()
            val password = input_password.text.toString()

            if (!email.isEmpty() && !password.isEmpty()) {

                progressBar.visibility = View.VISIBLE
                tvpleaseawait.visibility = View.VISIBLE
                mAuth?.signInWithEmailAndPassword(email, password)!!
                        .addOnCompleteListener { p0 ->
                            if (!p0.isSuccessful) {
                                Toast.makeText(this@LoginActivity, "Email / şifre hatalı ", Toast.LENGTH_SHORT).show()
                                progressBar.visibility = View.GONE
                                tvpleaseawait.visibility = View.GONE
                            } else {
                                Toast.makeText(this@LoginActivity, "Giriş başarılı ", Toast.LENGTH_SHORT).show()
                                progressBar.visibility = View.GONE
                                tvpleaseawait.visibility = View.GONE

                            }
                        }

            } else {
                Toast.makeText(this@LoginActivity, "Boş alanları doldurunuz ", Toast.LENGTH_SHORT).show()
            }


        }

        link_signup.setOnClickListener {

            var intent=Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)

        }

    }

    private fun setupFirebaseAuth() {

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener { p0 ->
            val user = p0.currentUser


            if (user != null) {
                Log.d(TAG, "onAuthStateChanged: Kullanıcı bağlı:" + user.uid);
                var intent=Intent(this@LoginActivity, HomeActivity::class.java)
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
