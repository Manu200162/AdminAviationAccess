package com.upb.aviation_access_admin.ui.manuAdmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.aviation_access_admin.databinding.FragmentMenuAdminBinding

class MenuAdminFragment: Fragment() {
    private lateinit var binding: FragmentMenuAdminBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuAdminBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btBigAirplane.setOnClickListener {
            val goToAircraftPage= MenuAdminFragmentDirections.actionMenuAdminFragmentToAircraftMainFragment()
            findNavController().navigate(goToAircraftPage)
        }
        binding.btBigFlight.setOnClickListener {
            val goToFlightsPage= MenuAdminFragmentDirections.actionMenuAdminFragmentToFlightsMainFragment()
            findNavController().navigate(goToFlightsPage)
        }
    }
}