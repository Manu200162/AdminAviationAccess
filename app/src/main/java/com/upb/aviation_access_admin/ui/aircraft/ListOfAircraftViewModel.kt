package com.upb.aviation_access_admin.ui.aircraft

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.aviation_access_admin.Aircraft
import com.upb.aviation_access_admin.data.aircrafts.AircraftsRepository
import com.upb.aviation_access_admin.data.aircrafts.network.AircraftNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListOfAircraftViewModel: ViewModel() {

    val aircraftRepository= AircraftsRepository(AircraftNetworkControllerImp())
    val aircraft = MutableLiveData<List<Aircraft>>(listOf())

    fun updateAircraft(){
        aircraftRepository.getAllAircraft().onEach {
            aircraft.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun updateSelectedAircraft(query:String){
        aircraftRepository.getSomeAircraft(query,query).onEach {
            aircraft.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}