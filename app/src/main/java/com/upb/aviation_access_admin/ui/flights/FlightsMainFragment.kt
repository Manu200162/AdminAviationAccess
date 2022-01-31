package com.upb.aviation_access_admin.ui.flights

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
import com.upb.aviation_access_admin.databinding.FragmentFlightsMainBinding

class FlightsMainFragment: Fragment() {

    private val listOfFlightsAdapter = ListOfFlightsAdapter()
    private val listOfFlightsViewModel: ListOfFlightsViewModel by viewModels()
    private lateinit var binding: FragmentFlightsMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlightsMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listOfFlightsViewModel.updateFlights()
        binding.rvFlightList.adapter=listOfFlightsAdapter
        val layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvFlightList.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvFlightList)
        listOfFlightsViewModel.flights.observe(viewLifecycleOwner){
            listOfFlightsAdapter.addAll(it)
        }
        listOfFlightsAdapter.setOnFlightClickListener {
            val goToFlightDetails= FlightsMainFragmentDirections.actionFlightsMainFragmentToFlightInfoFragment(it)
            findNavController().navigate(goToFlightDetails)
        }
        binding.btAddFlight.setOnClickListener {
            val goToAddFlightPage= FlightsMainFragmentDirections.actionFlightsMainFragmentToNewFlightFragment()
            findNavController().navigate(goToAddFlightPage)
        }

        binding.btSearchFlight.setOnClickListener {
            listOfFlightsViewModel.getSomeFlights(binding.txTextoBusquedaVuelo.text.toString())
            listOfFlightsViewModel.flights.observe(viewLifecycleOwner){
                listOfFlightsAdapter.addAll(it)
            }
        }




    }
}