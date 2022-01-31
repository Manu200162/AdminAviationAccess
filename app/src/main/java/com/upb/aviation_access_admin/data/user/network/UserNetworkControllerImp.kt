package com.upb.aviation_access_admin.data.user.network

import com.upb.aviation_access_admin.UserInfo
import com.upb.aviation_access_admin.data.user.network.model.LoginRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp:UserNetworkController {
    val client= Retrofit.Builder()
        .baseUrl("https://aviation-access.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserApi::class.java)

    override suspend fun login(username: String, password: String): UserInfo {
        return client.login(LoginRequest(username,password))
    }
}
