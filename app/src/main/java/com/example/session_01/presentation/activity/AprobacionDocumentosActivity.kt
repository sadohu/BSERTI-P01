package com.example.session_01.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.session_01.data.preference.PreferenceUser
import com.example.session_01.databinding.ActivityAprobacionDocumentosBinding
import com.example.session_01.domain.entity.AprobacionDocumento
import com.example.session_01.domain.viewModel.AprobracionDocumentoViewModel
import com.example.session_01.presentation.adapter.AprobacionDocumentosAdapter

class AprobacionDocumentosActivity : AppCompatActivity(), AprobacionDocumentosAdapter.ICard {
    private lateinit var binding : ActivityAprobacionDocumentosBinding
    private lateinit var aprobacionDocsAdapter : AprobacionDocumentosAdapter
    private var lstAprobacionDocs : MutableList<AprobacionDocumento> = ArrayList()
    private lateinit var aprobracionDocViewModel : AprobracionDocumentoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAprobacionDocumentosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
        initObservers()
    }

    private fun initValues(){
        // Cambiar el título de la barra de navegación y mostrarla
        supportActionBar?.title = "Aprobación de Documentos"
        supportActionBar?.show()

        // User logged
        val user = PreferenceUser.getPreferenceUser(this)!!

        // Inicializar el viewModel
        aprobracionDocViewModel = ViewModelProvider(this)[AprobracionDocumentoViewModel::class.java]
        aprobracionDocViewModel.getListAprobacionDocumento(user)

        // Inicializar el adaptador
        aprobacionDocsAdapter = AprobacionDocumentosAdapter(lstAprobacionDocs, this)

        // Inicializar el RecyclerView
        binding.rvAprobacionDocumentos.layoutManager = LinearLayoutManager(this)
        binding.rvAprobacionDocumentos.adapter = aprobacionDocsAdapter


    }

    private fun initObservers(){
        aprobracionDocViewModel.listAprobacionDocumento.observe(this){
            aprobacionDocsAdapter.update(it)
        }
    }

    override fun onCardClick(item: AprobacionDocumento) {
        TODO("Not yet implemented")
    }


}