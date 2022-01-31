package com.upb.aviation_access_admin.data.flights.network

import com.upb.aviation_access_admin.Flight

interface FlightsNetworkController {
    suspend fun getAllFlights():List<Flight>
    suspend fun deleteFlights(id_flight:Int)
    suspend fun createFlight(id_aircraft:Int,
                             nombre:String,
                             aerolinea:String,
                             paises:String,
                             nacional:Int,
                             origen:String,
                             destino:String,
                             tiempo_vuelo:String,
                             img_vuelo:String,
                             aeronave:String)
    suspend fun updateFlight(id_aircraft:Int,
                             aeronave:String,
                             id_flight:Int,
                             img_vuelo:String)
    suspend fun getSomeFlights(nombre: String,aerolinea: String,aeronave: String):List<Flight>
}