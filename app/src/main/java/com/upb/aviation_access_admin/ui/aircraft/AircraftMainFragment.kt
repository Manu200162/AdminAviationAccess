package com.upb.aviation_access_admin.ui.aircraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.upb.aviation_access_admin.databinding.FragmentAircraftMainBinding

class AircraftMainFragment: Fragment() {

    private val listOfAircraftAdapter = ListOfAircraftAdapter()
    private val listOfAircraftViewModel: ListOfAircraftViewModel by viewModels()
    private lateinit var binding: FragmentAircraftMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAircraftMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listOfAircraftViewModel.updateAircraft()
        binding.rvAircraftList.adapter=listOfAircraftAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvAircraftList.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvAircraftList)
        listOfAircraftViewModel.aircraft.observe(viewLifecycleOwner){
            listOfAircraftAdapter.addAll(it)
        }

        listOfAircraftAdapter.setOnAircratClickListener {
            val goToAircraftInfoPage= AircraftMainFragmentDirections.actionAircraftMainFragmentToAircraftInfoFragment(it)
            findNavController().navigate(goToAircraftInfoPage)
        }

        binding.btAddAircraft.setOnClickListener {
            val goToAddAircraftPage= AircraftMainFragmentDirections.actionAircraftMainFragmentToNewAircraftFragment()
            findNavController().navigate(goToAddAircraftPage)
        }
        binding.iconSearch2.setOnClickListener {
            listOfAircraftViewModel.updateSelectedAircraft(binding.txTextoBusquedaAeronave.text.toString())
            listOfAircraftViewModel.aircraft.observe(viewLifecycleOwner){
                listOfAircraftAdapter.addAll(it)
            }
        }

    }
}