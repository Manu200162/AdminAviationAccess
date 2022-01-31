package com.upb.aviation_access_admin.data.user.network

import com.upb.aviation_access_admin.UserInfo

interface UserNetworkController {
    suspend fun login(username:String,password:String): UserInfo
}