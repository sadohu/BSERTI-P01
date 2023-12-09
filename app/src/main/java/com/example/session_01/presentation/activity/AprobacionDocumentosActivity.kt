package com.example.session_01.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.session_01.R
import com.example.session_01.databinding.ActivityAprobacionDocumentosBinding
import com.example.session_01.presentation.adapter.AprobacionDocumentosAdapter

class AprobacionDocumentosActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAprobacionDocumentosBinding
    private lateinit var aprobacionDocsAdapter : AprobacionDocumentosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAprobacionDocumentosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
    }

    private fun initValues(){
        // Cambiar el título de la barra de navegación y mostrarla
        supportActionBar?.title = "Aprobación de Documentos"
        supportActionBar?.show()


    }


}