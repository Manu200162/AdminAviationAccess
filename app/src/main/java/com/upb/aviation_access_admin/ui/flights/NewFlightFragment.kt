package com.upb.aviation_access_admin.ui.flights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upb.aviation_access_admin.databinding.FragmentNewFlightBinding
import com.upb.aviation_access_admin.viewmodels.CreateObjectsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewFlightFragment: Fragment() {

    private lateinit var binding: FragmentNewFlightBinding
    private val createObjectsViewModel: CreateObjectsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNewFlightBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imgAcceptButtonAddFlight.setOnClickListener {
            val idAircraft:Int = binding.edtxIdAircraft.text.toString() .toInt()
            val nombre = binding.edtxNombreFlight.text.toString()
            val aerolinea = binding.edtxAirlineFlight.text.toString()
            val paises= binding.edtxPaisesFlight.text.toString()
            val nacional:Int = binding.edtxNacionalFlight.text.toString().toInt()
            val origen= binding.edtxOrigenFlight.text.toString()
            val destino = binding.edtxDestinoFlight.text.toString()
            val tiempoVuelo = binding.edtxTiempoVueloFlight.text.toString()
            val img_vuelo = binding.edtxImagenFlight.text.toString()
            val aeronave = binding.edtxAeronaveFlight.text.toString()
            createObjectsViewModel.createFlight(idAircraft,nombre,aerolinea,paises,nacional,origen,destino,tiempoVuelo,img_vuelo,aeronave).onEach {
                val goToSuccessPage = NewFlightFragmentDirections.actionNewFlightFragmentToCreateSuccessFragment()
                findNavController().navigate(goToSuccessPage)
            }.catch {
                Toast.makeText(context,"No se puede crear el vuelo", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
    }

}