package com.upb.aviation_access_admin.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upb.aviation_access_admin.R
import com.upb.aviation_access_admin.ui.extras.NetworkUtils

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        NetworkUtils.updateIsOnline(this)
    }

}