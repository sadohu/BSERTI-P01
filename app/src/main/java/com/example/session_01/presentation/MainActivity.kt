package com.example.session_01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.session_01.R
import com.example.session_01.data.preference.PreferenceUser
import com.example.session_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.show()
        initValues()
    }

    private fun initValues(){
        var user = PreferenceUser.getPreferenceUser(this)!!
        supportActionBar?.title = "Usuario: ${user.IDUsuario} - BSERTI MOBILE"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mainMenu_aprobacionRequerimientos -> {
                Toast.makeText(this, "Seleccionó Aprobación de Requerimientos", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}