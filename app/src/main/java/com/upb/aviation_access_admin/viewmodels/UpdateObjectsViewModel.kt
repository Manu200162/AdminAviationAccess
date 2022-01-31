package com.upb.aviation_access_admin.viewmodels

import androidx.lifecycle.ViewModel
import com.upb.aviation_access_admin.data.aircrafts.AircraftsRepository
import com.upb.aviation_access_admin.data.flights.FlightsRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class UpdateObjectsViewModel:ViewModel() {
    private val aicraftRepository by KoinJavaComponent.inject(AircraftsRepository::class.java)
    private val flightsRepository by KoinJavaComponent.inject(FlightsRepository::class.java)

    fun updateAircraft(id_aircraft:Int, descripcion:String): Flow<Any> {
        return aicraftRepository.updateAircraft(id_aircraft, descripcion)
    }

    fun updateFlight(id_aircraft:Int,
                     aeronave:String,
                     id_flight:Int,
                     img_vuelo:String):Flow<Any>{
        return flightsRepository.updateFlight(id_aircraft, aeronave, id_flight, img_vuelo)
    }
}