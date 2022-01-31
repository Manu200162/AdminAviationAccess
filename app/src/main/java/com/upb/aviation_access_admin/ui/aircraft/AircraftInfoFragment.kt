package com.upb.aviation_access_admin.ui.aircraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.aviation_access_admin.databinding.FragmentAircraftDetailsBinding
import com.upb.aviation_access_admin.databinding.FragmentFlightDetailsBinding
import com.upb.aviation_access_admin.viewmodels.DeleteElementsViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AircraftInfoFragment: Fragment() {

    private lateinit var binding: FragmentAircraftDetailsBinding
    private val args: AircraftInfoFragmentArgs by navArgs()
    private val deleteElementsViewModel:DeleteElementsViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAircraftDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.aircraftInfo=args.aircraftInfo
        binding.btDeleteAircraft.setOnClickListener {
            deleteElementsViewModel.deleteAircraft(args.aircraftInfo.Id_aircraft).onEach {
                val goToSuccessPage= AircraftInfoFragmentDirections.actionAircraftInfoFragmentToDeleteSuccessFragment()
                findNavController().navigate(goToSuccessPage)
            }.catch {
                Toast.makeText(context,"No se puede borrar esta aeronave",Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
        binding.btUpdateAircraft.setOnClickListener {
            val goToUpdatePage = AircraftInfoFragmentDirections.actionAircraftInfoFragmentToUpdateAircraftFragment(args.aircraftInfo)
            findNavController().navigate(goToUpdatePage)
        }
    }
}