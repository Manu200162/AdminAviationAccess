package com.upb.aviation_access_admin.ui.flights

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.aviation_access_admin.Flight
import com.upb.aviation_access_admin.data.flights.FlightsRepository
import com.upb.aviation_access_admin.data.flights.network.FlightsNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListOfFlightsViewModel: ViewModel() {
    val flightsRepository = FlightsRepository(FlightsNetworkControllerImp())
    val flights = MutableLiveData<List<Flight>>(listOf())

    fun updateFlights(){
        flightsRepository.getAllFlights().onEach {
            flights.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun getSomeFlights(query:String){
        flightsRepository.getSomeFlights(query,query,query).onEach {
            flights.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}