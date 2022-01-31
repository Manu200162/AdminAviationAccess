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
import com.upb.aviation_access_admin.databinding.FragmentUpdateAircraftBinding
import com.upb.aviation_access_admin.viewmodels.UpdateObjectsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class UpdateAircraftFragment: Fragment() {

    private lateinit var binding: FragmentUpdateAircraftBinding
    private val args: UpdateAircraftFragmentArgs by navArgs()
    private val updateObjectsViewModel:UpdateObjectsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateAircraftBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.aircraftInfo= args.aircraftInfo
        binding.btUpdateAircraft.setOnClickListener {
            val descripcion =binding.edtxDescripcionUpdate.text.toString()
            updateObjectsViewModel.updateAircraft(args.aircraftInfo.Id_aircraft,descripcion).onEach {
                val goToSuccesPage= UpdateAircraftFragmentDirections.actionUpdateAircraftFragmentToUpdateSuccessFragment()
                findNavController().navigate(goToSuccesPage)
            }.catch {
                Toast.makeText(context,"No se pudo actualizar la aeronave", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
    }
}