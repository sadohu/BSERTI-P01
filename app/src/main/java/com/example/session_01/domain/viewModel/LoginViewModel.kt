package com.example.session_01.domain.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.session_01.data.repository.UserRepository
import com.example.session_01.domain.entity.LoginUser
import com.example.session_01.domain.entity.User
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = UserRepository(application)

    private var _userLogin = MutableLiveData<User>()
    val userLogin: LiveData<User> = _userLogin

    fun login(loginUser: LoginUser) = viewModelScope.launch {
        try {
            val result = repository.login(loginUser)
            _userLogin.postValue(result)
        } catch (e: Exception) {
            Log.d("Error: ", e.message.toString())
        }
    }
}