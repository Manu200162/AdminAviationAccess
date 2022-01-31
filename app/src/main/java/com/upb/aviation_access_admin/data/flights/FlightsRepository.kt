package com.upb.aviation_access_admin.data.flights

import com.upb.aviation_access_admin.Flight
import com.upb.aviation_access_admin.data.flights.network.FlightsNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlightsRepository(val network:FlightsNetworkController) {

    fun getAllFlights(): Flow<List<Flight>> {
        return flow {
            emit(network.getAllFlights())
        }
    }

    fun deleteFlights(id_flight:Int):Flow<Any>{
        return flow {
            emit(network.deleteFlights(id_flight))
        }
    }

    fun createFlight(id_aircraft:Int,
                     nombre:String,
                     aerolinea:String,
                     paises:String,
                     nacional:Int,
                     origen:String,
                     destino:String,
                     tiempo_vuelo:String,
                     img_vuelo:String,
                     aeronave:String):Flow<Any>{
        return flow{
            emit(network.createFlight(id_aircraft, nombre, aerolinea, paises, nacional, origen, destino, tiempo_vuelo, img_vuelo, aeronave))
        }
    }

    fun updateFlight(id_aircraft:Int,
                     aeronave:String,
                     id_flight:Int,
                     img_vuelo:String):Flow<Any>{
        return flow{
            emit(network.updateFlight(id_aircraft, aeronave, id_flight, img_vuelo))
        }
    }
    fun getSomeFlights(nombre: String,aerolinea: String,aeronave: String):Flow<List<Flight>>{
        return flow {
            emit(network.getSomeFlights(nombre, aerolinea, aeronave))
        }
    }
}