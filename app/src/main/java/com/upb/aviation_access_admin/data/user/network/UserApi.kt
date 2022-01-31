package com.upb.aviation_access_admin.data.user.network

import com.upb.aviation_access_admin.UserInfo
import com.upb.aviation_access_admin.data.user.network.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): UserInfo
}