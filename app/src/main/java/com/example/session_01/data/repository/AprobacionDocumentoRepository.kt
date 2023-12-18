package com.example.session_01.data.repository

import android.app.Application
import com.example.session_01.domain.entity.AprobacionDocumento
import com.example.session_01.domain.entity.User

class AprobacionDocumentoRepository(application: Application) : BaseRepository(application) {
    suspend fun getAprobacionDocumentos(user: User) = apiClient.getAprobacionDocumentos(user)
    suspend fun uploadImage(aprobacionDocumento: AprobacionDocumento) =
        apiClient.uploadImage(aprobacionDocumento)
}