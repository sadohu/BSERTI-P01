package com.example.session_01.presentation.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.session_01.databinding.ActivityDetalleAprobacionDocumentoBinding
import com.example.session_01.domain.entity.AprobacionDocumento
import com.example.session_01.domain.viewModel.AprobracionDocumentoViewModel
import java.io.ByteArrayOutputStream

class DetalleAprobacionDocumentoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleAprobacionDocumentoBinding
    private lateinit var aprobracionDocumentoViewModel: AprobracionDocumentoViewModel
    private val PICK_IMAGE_REQUEST = 1
    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAprobacionDocumentoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
        initEvents()
        initObservers()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            // Obtiene la URI de la imagen seleccionada
            val selectedImageUri = data.data!!

            // Convierte la URI a un bitmap
            val bitmap =
                BitmapFactory.decodeStream(contentResolver.openInputStream(selectedImageUri))

            // Convierte el bitmap a base64
            val base64Image = convertBitmapToBase64(bitmap)

            println("Holi\n $base64Image")
        }
    }

    private fun initValues() {
        // Inicializar el ViewModel
        aprobracionDocumentoViewModel =
            ViewModelProvider(this)[AprobracionDocumentoViewModel::class.java]

        // Cambiar el título de la barra de navegación y mostrarla
        supportActionBar?.title = "Detalle de Aprobación"
        supportActionBar?.show()

        // Obtener el objeto enviado desde la actividad anterior
        val aprobacionDocumento =
            intent.getSerializableExtra("aprobacionDocumento") as AprobacionDocumento

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

    }

    private fun initEvents() {
        // Evento para abrir la galería
        binding.btnImagen.setOnClickListener {
            // Antes de abrir la galería, verifica si tienes el permiso
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Si no tienes el permiso, solicítalo al usuario
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                )
            } else {
                // Si ya tienes el permiso, abre la galería
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, PICK_IMAGE_REQUEST)
            }
        }
    }

    private fun initObservers() {
        aprobracionDocumentoViewModel.uploadImage.observe(this) {
            println(it)
        }
    }

    // Método para convertir un bitmap a una cadena de base64
    private fun convertBitmapToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}