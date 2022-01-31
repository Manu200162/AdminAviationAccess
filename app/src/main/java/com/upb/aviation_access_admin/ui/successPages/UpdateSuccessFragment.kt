package com.upb.aviation_access_admin.ui.successPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.aviation_access_admin.databinding.FragmentUpdateSuccessBinding

class UpdateSuccessFragment: Fragment() {

    private lateinit var binding:FragmentUpdateSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateSuccessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btConfirmarActualizacion.setOnClickListener {
            val goToMainPage= UpdateSuccessFragmentDirections.actionUpdateSuccessFragmentToMenuAdminFragment("das","asda",1)
            findNavController().navigate(goToMainPage)
        }
    }
}