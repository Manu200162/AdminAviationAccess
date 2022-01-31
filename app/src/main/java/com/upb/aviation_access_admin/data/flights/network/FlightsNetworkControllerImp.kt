package com.upb.aviation_access_admin.data.flights.network

import com.upb.aviation_access_admin.Flight
import com.upb.aviation_access_admin.data.flights.network.model.NewFlightRequest
import com.upb.aviation_access_admin.data.flights.network.model.SelectFlightRequest
import com.upb.aviation_access_admin.data.flights.network.model.UpdateFlightRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightsNetworkControllerImp:FlightsNetworkController {

    val client= Retrofit.Builder()
        .baseUrl("https://aviation-access.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FlightsAPI::class.java)


    override suspend fun getAllFlights(): List<Flight> {
        return client.getAllFlights()
    }

    override suspend fun deleteFlights(id_flight: Int) {
        return client.deleteFlights(id_flight)
    }

    override suspend fun createFlight(
        id_aircraft: Int,
        nombre: String,
        aerolinea: String,
        paises: String,
        nacional: Int,
        origen: String,
        destino: String,
        tiempo_vuelo: String,
        img_vuelo: String,
        aeronave: String
    ) {
        return client.createFlight(NewFlightRequest(id_aircraft, nombre, aerolinea, paises, nacional, origen, destino, tiempo_vuelo, img_vuelo, aeronave))
    }

    override suspend fun updateFlight(
        id_aircraft: Int,
        aeronave: String,
        id_flight: Int,
        img_vuelo: String
    ) {
        return client.updateFlight(UpdateFlightRequest(id_aircraft, aeronave, id_flight, img_vuelo))
    }

    override suspend fun getSomeFlights(
        nombre: String,
        aerolinea: String,
        aeronave: String
    ): List<Flight> {
        return client.getSomeFlights(SelectFlightRequest(nombre, aerolinea, aeronave))
    }
}