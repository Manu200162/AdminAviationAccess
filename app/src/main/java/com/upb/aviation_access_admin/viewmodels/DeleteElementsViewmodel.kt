package com.upb.aviation_access_admin.viewmodels

import androidx.lifecycle.ViewModel
import com.upb.aviation_access_admin.Aircraft
import com.upb.aviation_access_admin.data.aircrafts.AircraftsRepository
import com.upb.aviation_access_admin.data.flights.FlightsRepository
import com.upb.aviation_access_admin.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class DeleteElementsViewmodel:ViewModel() {
    private val aicraftRepository by KoinJavaComponent.inject(AircraftsRepository::class.java)
    private val flightsRepository by KoinJavaComponent.inject(FlightsRepository::class.java)
    fun deleteAircraft(id_aircraft:Int): Flow<Any> {
        return aicraftRepository.deleteAircraft(id_aircraft)
    }

    fun deleteFlights(id_flight:Int):Flow<Any>{
        return flightsRepository.deleteFlights(id_flight)
    }


}