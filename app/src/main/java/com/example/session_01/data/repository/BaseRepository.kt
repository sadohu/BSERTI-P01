package com.example.session_01.data.repository

import android.app.Application
import com.example.session_01.data.api.ApiService
import com.example.session_01.data.api.RetrofitInstance

open class BaseRepository (application: Application){
    protected var apiClient : ApiService = RetrofitInstance.api.create(ApiService::class.java)
}