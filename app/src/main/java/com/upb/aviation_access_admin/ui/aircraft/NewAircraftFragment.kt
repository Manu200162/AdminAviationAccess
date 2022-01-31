package com.upb.aviation_access_admin.ui.aircraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upb.aviation_access_admin.databinding.FragmentNewAircraftBinding
import com.upb.aviation_access_admin.viewmodels.CreateObjectsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewAircraftFragment: Fragment() {

    private lateinit var binding:FragmentNewAircraftBinding
    private val createObjectsViewModel: CreateObjectsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNewAircraftBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imgAcceptButtonAddAircraft.setOnClickListener {
            val modelo = binding.edtxModeloAirplane.text.toString()
            val fabricante = binding.edtxFabricanteAirplane.text.toString()
            val descripcion = binding.edtxDescripcionAirplane.text.toString()
            val imagen_url = binding.edtxImagenAeronave.text.toString()
            val modernidad:Int = binding.edtxModernidadAirplane.text.toString().toInt()
            createObjectsViewModel.createAircraft(modelo, fabricante, descripcion, imagen_url, modernidad).onEach {
                val goToSuccessPage= NewAircraftFragmentDirections.actionNewAircraftFragmentToCreateSuccessFragment()
                findNavController().navigate(goToSuccessPage)
            }.catch {
                Toast.makeText(context,"No se puede crear la aeronave",Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))

        }
    }
}
