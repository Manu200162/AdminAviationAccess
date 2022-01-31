package com.upb.aviation_access_admin.data.user

import com.upb.aviation_access_admin.UserInfo
import com.upb.aviation_access_admin.data.user.network.UserNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(val network:UserNetworkController) {
    fun login(username:String,password:String): Flow<UserInfo> {
        return flow{
            emit(network.login(username,password))
        }
    }
}