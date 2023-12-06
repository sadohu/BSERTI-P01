package com.example.session_01.data.repository

import android.app.Application
import com.example.session_01.domain.entity.LoginUser

class UserRepository (application: Application) : BaseRepository(application) {
        suspend fun login(loginUser : LoginUser) = apiClient.loginUser(loginUser)
}