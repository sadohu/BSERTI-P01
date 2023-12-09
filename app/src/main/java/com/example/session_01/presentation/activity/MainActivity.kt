package com.example.session_01.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.session_01.R
import com.example.session_01.data.preference.PreferenceUser
import com.example.session_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
    }

    private fun initValues(){
        // Cambiar el título de la barra de navegación y mostrarla
        val user = PreferenceUser.getPreferenceUser(this)!!
        supportActionBar?.title = "Usuario: ${user.IDUsuario} - BSERTI MOBILE"
        supportActionBar?.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mainMenu_aprobacionRequerimientos -> {
                startActivity(Intent(this, AprobacionDocumentosActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}