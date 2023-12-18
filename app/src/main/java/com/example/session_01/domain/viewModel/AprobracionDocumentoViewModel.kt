package com.example.session_01.domain.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.session_01.data.repository.AprobacionDocumentoRepository
import com.example.session_01.domain.entity.AprobacionDocumento
import com.example.session_01.domain.entity.User
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class AprobracionDocumentoViewModel(application: Application) : AndroidViewModel(application){
    private var repository = AprobacionDocumentoRepository(application)

    private var _listAprobacionDocumento = MutableLiveData<List<AprobacionDocumento>>()
    val listAprobacionDocumento : LiveData<List<AprobacionDocumento>> = _listAprobacionDocumento

    private var _uploadImage = MutableLiveData<String>()
    val uploadImage : LiveData<String> = _uploadImage

    fun getListAprobacionDocumento (user : User) = viewModelScope.launch {
        try {
            val result = repository.getAprobacionDocumentos(user)
            _listAprobacionDocumento.postValue(result)
        }catch (e: Exception){
            Log.d("Error: ", e.message.toString())
        }
    }

    fun uploadImage(aprobacionDocumento: AprobacionDocumento) = viewModelScope.launch {
        try {
            val response = repository.uploadImage(aprobacionDocumento)

            if (response.isSuccessful) {
                val responseBody = response.body()
                // Aquí puedes convertir el responseBody según sea necesario (por ejemplo, a String)
                val result = responseBody?.string() ?: "No hay datos"
                _uploadImage.postValue(result)
            } else {
                // La solicitud no fue exitosa, manejar el error según sea necesario
                _uploadImage.postValue("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            // Manejar excepciones aquí (por ejemplo, problemas de red)
            _uploadImage.postValue("Error: ${e.message}")
        }
    }
}