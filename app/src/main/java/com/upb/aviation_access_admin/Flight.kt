package com.upb.aviation_access_admin

import java.io.Serializable

data class Flight (val Id_flight:Int,
                   val Id_aircraft:String,
                   val Nombre:String,
                   val Aerolinea:String,
                   val Paises:String,
                   val Nacional:Int,
                   val Origen:String,
                   val Destino:String,
                   val Hora_partida:String,
                   val Tiempo_vuelo:String,
                   val Img_vuelo:String,
                   val Aeronave:String):Serializable