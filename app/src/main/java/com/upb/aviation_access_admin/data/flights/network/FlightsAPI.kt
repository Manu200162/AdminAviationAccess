package com.upb.aviation_access_admin.data.flights.network

import com.upb.aviation_access_admin.Flight
import com.upb.aviation_access_admin.data.flights.network.model.NewFlightRequest
import com.upb.aviation_access_admin.data.flights.network.model.SelectFlightRequest
import com.upb.aviation_access_admin.data.flights.network.model.UpdateFlightRequest
import retrofit2.http.*

interface FlightsAPI {
    @GET("api/flights/findAll")
    suspend fun getAllFlights():List<Flight>

    @DELETE("api/flights/delete/{id}")
    suspend fun deleteFlights(@Path("id") id_flight:Int)

    @POST("api/flights/")
    suspend fun createFlight(@Body newFlightRequest:NewFlightRequest)

    @PUT("api/flights/update")
    suspend fun updateFlight(@Body newFlightRequest: UpdateFlightRequest)

    @POST("api/flights/findSelection")
    suspend fun getSomeFlights(@Body selectFlightRequest: SelectFlightRequest):List<Flight>

}