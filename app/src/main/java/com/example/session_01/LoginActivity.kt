package com.example.session_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.session_01.data.preference.PreferenceUser
import com.example.session_01.databinding.ActivityLoginBinding
import com.example.session_01.domain.entity.LoginUser
import com.example.session_01.domain.entity.User
import com.example.session_01.domain.viewModel.LoginViewModel
import com.example.session_01.presentation.activity.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var loginViewModel : LoginViewModel
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // User logged
        if (PreferenceUser.getPreferenceUser(applicationContext) != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initValues()
        initObservers()
    }

    private fun initValues(){
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.btnIngresar.setOnClickListener {
            val username = binding.etUsuario.text
            val password = binding.etPassword.text
            println("Usuario: $username, Password: $password")
            val loginUser = LoginUser()
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
                if (PreferenceUser.setPreferenceUser(applicationContext, user) == 1){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
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