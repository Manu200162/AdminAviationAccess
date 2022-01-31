package com.upb.aviation_access_admin.viewmodels

import androidx.lifecycle.ViewModel
import com.upb.aviation_access_admin.data.aircrafts.AircraftsRepository
import com.upb.aviation_access_admin.data.flights.FlightsRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class CreateObjectsViewModel:ViewModel() {

    private val aircraftsRepository by KoinJavaComponent.inject(AircraftsRepository::class.java)
    private val flightsRepository by KoinJavaComponent.inject(FlightsRepository::class.java)

    fun createAircraft( modelo:String,
                        fabricante:String,
                        descripcion:String,
                        imagen_url:String,
                        modernidad:Int): Flow<Any> {
        return aircraftsRepository.createAircraft(modelo, fabricante, descripcion, imagen_url, modernidad)
    }

    fun createFlight(
        id_aircraft:Int,
        nombre:String,
        aerolinea:String,
        paises:String,
        nacional:Int,
        origen:String,
        destino:String,
        tiempo_vuelo:String,
        img_vuelo:String,
        aeronave:String
    ):Flow<Any>{
        return flightsRepository.createFlight(id_aircraft, nombre, aerolinea, paises, nacional, origen, destino, tiempo_vuelo, img_vuelo, aeronave)
    }
}