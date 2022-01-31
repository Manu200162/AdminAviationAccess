package com.upb.aviation_access_admin.data.aircrafts.network

import com.upb.aviation_access_admin.Aircraft
import com.upb.aviation_access_admin.data.aircrafts.network.model.NewAircraftRequest
import com.upb.aviation_access_admin.data.aircrafts.network.model.SelectAircraftRequest
import com.upb.aviation_access_admin.data.aircrafts.network.model.UpdateAircraftRequest
import retrofit2.http.*

interface AircraftAPI {
    @GET("api/aircrafts/findAll")
    suspend fun getAllAircraft():List<Aircraft>

    @DELETE("api/aircrafts/delete/{id}")
    suspend fun deleteAircraft(@Path("id")id_aircraft:Int)

    @POST("api/aircrafts/")
    suspend fun createAircraft(@Body newAircraftRequest:NewAircraftRequest)

    @PUT("api/aircrafts/update")
    suspend fun updateAircraft(@Body updateAircraftRequest:UpdateAircraftRequest)

    @POST("api/aircrafts/findSelection")
    suspend fun getSelectionAAircraft(@Body selectAircraftRequest: SelectAircraftRequest):List<Aircraft>
}