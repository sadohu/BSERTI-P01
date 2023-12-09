package com.example.session_01.domain.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.session_01.data.repository.AprobacionDocumentoRepostitory
import com.example.session_01.domain.entity.AprobacionDocumento
import com.example.session_01.domain.entity.User
import kotlinx.coroutines.launch

class AprobracionDocumentoViewModel(application: Application) : AndroidViewModel(application){
    private var repository = AprobacionDocumentoRepostitory(application)

    private var _listAprobacionDocumento = MutableLiveData<List<AprobacionDocumento>>()
    val listAprobacionDocumento : LiveData<List<AprobacionDocumento>> = _listAprobacionDocumento

    fun getListAprobacionDocumento (user : User) = viewModelScope.launch {
        try {
            val result = repository.getAprobacionDocumentos(user)
            _listAprobacionDocumento.postValue(result)
        }catch (e: Exception){
            Log.d("Error: ", e.message.toString())
        }
    }
}