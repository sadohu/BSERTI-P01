package com.example.session_01.presentation.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.session_01.databinding.ActivityDetalleAprobacionDocumentoBinding
import com.example.session_01.domain.entity.AprobacionDocumento

class DetalleAprobacionDocumentoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetalleAprobacionDocumentoBinding
    private val PICK_IMAGE_REQUEST = 1
    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1

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
//        binding.btnNumero.text = aprobacionDocumento.NumeroDocumento
        binding.tvTipoDocumento.text = aprobacionDocumento.TipoDocumento
        binding.tvAbrevacion.text = aprobacionDocumento.Abreviacion
        binding.tvEstadoItem.text = aprobacionDocumento.EstadoItem
        binding.tvDescripcion.text = aprobacionDocumento.Descripcion
        binding.tvUsuarioRegistro.text = aprobacionDocumento.UsuarioRegistro
        binding.tvFechaRegistro.text = aprobacionDocumento.FechaRegistro
        binding.tvHoraRegistro.text = aprobacionDocumento.HoraRegistro
        binding.tvObservacion.text = aprobacionDocumento.Observacion

        initEvents()

    }

    private fun initEvents(){
        binding.btnImagen.setOnClickListener {
            // Antes de abrir la galería, verifica si tienes el permiso
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                // Si no tienes el permiso, solicítalo al usuario
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                )
            } else {
                // Si ya tienes el permiso, abre la galería
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, PICK_IMAGE_REQUEST)
            }
        }
    }
}