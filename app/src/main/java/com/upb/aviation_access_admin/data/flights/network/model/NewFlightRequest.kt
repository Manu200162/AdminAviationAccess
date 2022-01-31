package com.upb.aviation_access_admin.data.flights.network.model

data class NewFlightRequest (val id_aircraft:Int,
                             val nombre:String,
                             val aerolinea:String,
                             val paises:String,
                             val nacional:Int,
                             val origen:String,
                             val destino:String,
                             val tiempo_vuelo:String,
                             val img_vuelo:String,
                             val aeronave:String)