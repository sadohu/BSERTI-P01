package com.example.session_01.data.repository

import android.app.Application
import com.example.session_01.domain.entity.User

class AprobacionDocumentoRepostitory (application: Application) : BaseRepository(application) {
    suspend fun getAprobacionDocumentos(user : User) = apiClient.getAprobacionDocumentos(user)
}