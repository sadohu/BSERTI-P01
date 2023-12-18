package com.example.session_01.data.api

import com.example.session_01.domain.entity.AprobacionDocumento
import com.example.session_01.domain.entity.LoginUser
import com.example.session_01.domain.entity.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    // Login
    @POST("api/Consulta/fn_Login")
    suspend fun loginUser(@Body loginUser: LoginUser): User

    // Aprobación de documentos
    @POST("api/Consulta/fn_PendienteAprobacion")
    suspend fun getAprobacionDocumentos(@Body user: User): List<AprobacionDocumento>

    // Envio de imagenes
    @POST("api/Consulta/fn_EnviarImagen")
    suspend fun uploadImage(@Body aprobacionDocumento: AprobacionDocumento): Response<ResponseBody>
}