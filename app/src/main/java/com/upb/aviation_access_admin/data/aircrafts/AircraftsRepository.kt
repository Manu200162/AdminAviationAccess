package com.upb.aviation_access_admin.data.aircrafts

import com.upb.aviation_access_admin.Aircraft
import com.upb.aviation_access_admin.data.aircrafts.network.AircraftNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AircraftsRepository(val network:AircraftNetworkController) {

    fun getAllAircraft():Flow<List<Aircraft>> {
        return flow {
            emit(network.getAllAircraft())
        }
    }

    fun deleteAircraft(id_aircraft:Int):Flow<Any>{
        return flow{
            emit(network.deleteAircraft(id_aircraft))
        }
    }

    fun createAircraft(modelo:String,
                       fabricante:String,
                       descripcion:String,
                       imagen_url:String,
                       modernidad:Int):Flow<Any>{
        return flow{
            emit(network.createNewAircraft(modelo, fabricante, descripcion, imagen_url, modernidad))
        }
    }
    fun updateAircraft(id_aircraft:Int, descripcion:String):Flow<Any>{
        return flow{
            emit(network.updateAircraft(id_aircraft, descripcion))
        }
    }
    fun getSomeAircraft(modelo:String,fabricante:String):Flow<List<Aircraft>>{
        return flow{
            emit(network.getSomeAircraft(modelo, fabricante))
        }
    }


}