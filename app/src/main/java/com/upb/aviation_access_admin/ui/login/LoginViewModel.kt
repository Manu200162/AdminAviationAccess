package com.upb.aviation_access_admin.ui.login

import androidx.lifecycle.ViewModel
import com.upb.aviation_access_admin.UserInfo
import com.upb.aviation_access_admin.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

class LoginViewModel:ViewModel() {
    private val userRepository by inject(UserRepository::class.java)

    fun login(username:String,password:String): Flow<UserInfo> {
        return userRepository.login(username,password)
    }
}