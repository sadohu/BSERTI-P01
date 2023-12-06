package com.example.session_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.session_01.databinding.ActivityLoginBinding
import com.example.session_01.domain.entity.LoginUser
import com.example.session_01.domain.entity.User
import com.example.session_01.presentation.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var loginViewModel : LoginViewModel
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
        initObservers()
    }

    private fun initValues(){
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.btnIngresar.setOnClickListener {
            var username = binding.etUsuario.text;
            var password = binding.etPassword.text;
            println("Usuario: $username, Password: $password")
            var loginUser = LoginUser()
            loginUser.Usuario = username.toString()
            loginUser.Clave = password.toString()
            loginUser.IDCompania = 1

            loginViewModel.login(loginUser)
        }


    }

    private fun initObservers(){
    loginViewModel.userLogin.observe(this){
            print("Resultado: $it")
            user = it
            if(user.IDUsuario.isNullOrEmpty()){
                Toast.makeText(this, user.Respuesta, Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, user.Respuesta, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun mensajeGuardar(message : String){
        AlertDialog.Builder(this)
            .setTitle("Guadar Cliente")
            .setMessage(message)
            .setNeutralButton("Ok"){dialog,_->
                finish()
            }
            .setCancelable(false)
            .show()
    }


}