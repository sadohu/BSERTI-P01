package com.example.session_01.domain.entity

import java.io.Serializable

class AprobacionDocumento : Serializable {
    var Id: Int = 0
    var NumeroDocumento: String = ""
    var TipoDocumento: String = ""
    var Abreviacion: String = ""
    var EstadoItem: String = ""
    var Descripcion: String = ""
    var UsuarioRegistro: String = ""
    var FechaRegistro: String = ""
    var HoraRegistro: String = ""
    var Observacion: String = ""
    var Imagen: String = ""
}