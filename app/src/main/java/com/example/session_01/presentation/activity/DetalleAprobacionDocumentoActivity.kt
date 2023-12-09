package com.example.session_01.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.session_01.databinding.ActivityDetalleAprobacionDocumentoBinding
import com.example.session_01.domain.entity.AprobacionDocumento

class DetalleAprobacionDocumentoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetalleAprobacionDocumentoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAprobacionDocumentoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
    }

    private fun initValues(){
        // Cambiar el título de la barra de navegación y mostrarla
        supportActionBar?.title = "Detalle de Aprobación"
        supportActionBar?.show()

        // Obtener el objeto enviado desde la actividad anterior
        val aprobacionDocumento = intent.getSerializableExtra("aprobacionDocumento") as AprobacionDocumento

        // Mostrar los datos en los componentes
        binding.tvNumero.text = aprobacionDocumento.NumeroDocumento
        binding.btnNumero.text = aprobacionDocumento.NumeroDocumento
        binding.tvTipoDocumento.text = aprobacionDocumento.TipoDocumento
        binding.tvAbrevacion.text = aprobacionDocumento.Abreviacion
        binding.tvEstadoItem.text = aprobacionDocumento.EstadoItem
        binding.tvDescripcion.text = aprobacionDocumento.Descripcion
        binding.tvUsuarioRegistro.text = aprobacionDocumento.UsuarioRegistro
        binding.tvFechaRegistro.text = aprobacionDocumento.FechaRegistro
        binding.tvHoraRegistro.text = aprobacionDocumento.HoraRegistro
        binding.tvObservacion.text = aprobacionDocumento.Observacion
    }
}