package com.upb.aviation_access_admin.ui.extras

import android.content.Context

object NetworkUtils {
    var isOnline = false

    fun updateIsOnline(context: Context) {
        isOnline = isNetworkConnected(context)
    }
}