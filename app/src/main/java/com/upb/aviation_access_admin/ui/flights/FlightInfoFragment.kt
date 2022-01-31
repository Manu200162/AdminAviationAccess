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
import com.upb.aviation_access_admin.databinding.FragmentFlightDetailsBinding
import com.upb.aviation_access_admin.databinding.FragmentFlightsMainBinding
import com.upb.aviation_access_admin.viewmodels.DeleteElementsViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FlightInfoFragment:Fragment() {

    private lateinit var binding: FragmentFlightDetailsBinding
    private val args: FlightInfoFragmentArgs by navArgs()
    private val deleteElementsViewModel: DeleteElementsViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlightDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.flightD=args.flightInfo
        binding.buttonEliminarUsuario.setOnClickListener {
            deleteElementsViewModel.deleteFlights(args.flightInfo.Id_flight).onEach {
                val goToSuccessPage = FlightInfoFragmentDirections.actionFlightInfoFragmentToDeleteSuccessFragment()
                findNavController().navigate(goToSuccessPage)
            }.catch {
                Toast.makeText(context,"No se pudo eliminar correctamente",Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
        binding.btUpdateFlight.setOnClickListener {
            val goToUpdatePage = FlightInfoFragmentDirections.actionFlightInfoFragmentToUpdateFlightFragment(args.flightInfo)
            findNavController().navigate(goToUpdatePage)
        }
    }
}