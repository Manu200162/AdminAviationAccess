package com.upb.aviation_access_admin.data.flights.network.model

data class UpdateFlightRequest (val id_aircraft:Int,
                                val aeronave:String,
                                val id_flight:Int,
                                val img_vuelo:String)