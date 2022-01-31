package com.upb.aviation_access_admin

import java.io.Serializable

data class UserInfo (val Id_user:Int,
                     val username:String,
                     val lastinit:String,
                     val password:String,
                     val fullname: String): Serializable