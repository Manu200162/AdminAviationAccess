package com.upb.aviation_access_admin.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.upb.aviation_access_admin.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed( {
            val intent  =  Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000 )
    }
}