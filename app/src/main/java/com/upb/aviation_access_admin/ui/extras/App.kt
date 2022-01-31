package com.upb.aviation_access_admin.ui.extras

import android.app.Application
import androidx.room.Room
import com.upb.aviation_access_admin.data.aircrafts.AircraftsRepository
import com.upb.aviation_access_admin.data.aircrafts.network.AircraftNetworkController
import com.upb.aviation_access_admin.data.aircrafts.network.AircraftNetworkControllerImp
import com.upb.aviation_access_admin.data.flights.FlightsRepository
import com.upb.aviation_access_admin.data.flights.network.FlightsNetworkController
import com.upb.aviation_access_admin.data.flights.network.FlightsNetworkControllerImp
import com.upb.aviation_access_admin.data.user.UserRepository
import com.upb.aviation_access_admin.data.user.network.UserNetworkController
import com.upb.aviation_access_admin.data.user.network.UserNetworkControllerImp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    companion object{
        lateinit var db : AppDatabase
    }
    val appModule = module {
        single<UserNetworkController>{ UserNetworkControllerImp() }
        single{ UserRepository(get()) }
        single<FlightsNetworkController>{FlightsNetworkControllerImp()}
        single{FlightsRepository(get())}
        single<AircraftNetworkController>{AircraftNetworkControllerImp()}
        single{AircraftsRepository(get())}

    }
    override fun onCreate() {
        super.onCreate()
        //db = Room.databaseBuilder(this, AppDatabase::class.java,"app-db").build()


        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}