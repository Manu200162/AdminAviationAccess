package com.upb.aviation_access_admin.ui.flights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.aviation_access_admin.databinding.FragmentUpdateFlightBinding
import com.upb.aviation_access_admin.viewmodels.UpdateObjectsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UpdateFlightFragment: Fragment() {

    private lateinit var binding:FragmentUpdateFlightBinding
    private val args: UpdateFlightFragmentArgs by navArgs()
    private val updateObjectsViewModel: UpdateObjectsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentUpdateFlightBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.flightInfo=args.flightInfo
        binding.btUpdateFlight.setOnClickListener {
            val idAircraft:Int = binding.edtxIdAircraftUpdate.text.toString().toInt()
            val aeronave=binding.edtxAeronaveUpdate.text.toString()
            val img = binding.edtxImgVueloUpdate.text.toString()
            updateObjectsViewModel.updateFlight(idAircraft,aeronave,args.flightInfo.Id_flight,img).onEach {
                val goToSuccessPage= UpdateFlightFragmentDirections.actionUpdateFlightFragmentToUpdateSuccessFragment()
                findNavController().navigate(goToSuccessPage)
            }.catch {
                Toast.makeText(context,"No se pudo actualizar el vuelo", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
    }
}