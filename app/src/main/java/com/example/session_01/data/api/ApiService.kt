package com.example.session_01.data.api

import com.example.session_01.domain.entity.LoginUser
import com.example.session_01.domain.entity.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("api/Consulta/fn_Login")
    suspend fun loginUser(@Body loginUser: LoginUser) : User
}