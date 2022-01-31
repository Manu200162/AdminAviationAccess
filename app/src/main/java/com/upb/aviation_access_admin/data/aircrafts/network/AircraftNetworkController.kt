package com.upb.aviation_access_admin.data.aircrafts.network

import com.upb.aviation_access_admin.Aircraft

interface AircraftNetworkController {
    suspend fun getAllAircraft():List<Aircraft>
    suspend fun deleteAircraft(id_aircraft:Int)
    suspend fun createNewAircraft( modelo:String, fabricante:String, descripcion:String, imagen_url:String, modernidad:Int)
    suspend fun updateAircraft(id_aircraft:Int, descripcion:String)
    suspend fun getSomeAircraft(modelo:String,fabricante:String):List<Aircraft>
}