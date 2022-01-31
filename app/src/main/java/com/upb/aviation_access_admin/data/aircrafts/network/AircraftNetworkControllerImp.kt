package com.upb.aviation_access_admin.data.aircrafts.network

import com.upb.aviation_access_admin.Aircraft
import com.upb.aviation_access_admin.data.aircrafts.network.model.NewAircraftRequest
import com.upb.aviation_access_admin.data.aircrafts.network.model.SelectAircraftRequest
import com.upb.aviation_access_admin.data.aircrafts.network.model.UpdateAircraftRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AircraftNetworkControllerImp:AircraftNetworkController {

    val client= Retrofit.Builder()
        .baseUrl("https://aviation-access.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AircraftAPI::class.java)

    override suspend fun getAllAircraft(): List<Aircraft> {
        return client.getAllAircraft()
    }

    override suspend fun deleteAircraft(id_aircraft: Int) {
        return client.deleteAircraft(id_aircraft)
    }

    override suspend fun createNewAircraft(
        modelo: String,
        fabricante: String,
        descripcion: String,
        imagen_url: String,
        modernidad: Int
    ) {
        return client.createAircraft(NewAircraftRequest(modelo,fabricante,descripcion, imagen_url, modernidad))
    }

    override suspend fun updateAircraft(id_aircraft: Int, descripcion: String) {
        return client.updateAircraft(UpdateAircraftRequest(id_aircraft, descripcion))
    }

    override suspend fun getSomeAircraft(modelo: String, fabricante: String):List<Aircraft> {
        return client.getSelectionAAircraft(SelectAircraftRequest(modelo, fabricante))
    }
}