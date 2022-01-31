package com.upb.aviation_access_admin.data.aircrafts.network.model

data class NewAircraftRequest (val modelo:String,
                               val fabricante:String,
                               val descripcion:String,
                               val imagen_url:String,
                               val modernidad:Int)