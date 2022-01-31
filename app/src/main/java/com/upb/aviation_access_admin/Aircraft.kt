package com.upb.aviation_access_admin

import java.io.Serializable

data class Aircraft (val Id_aircraft:Int,
                     val Imagen_url:String,
                     val Descripcion:String,
                     val Fabricante:String,
                     val Modelo:String,
                     val Modernidad:Int):Serializable