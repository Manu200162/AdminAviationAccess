package com.upb.aviation_access_admin.ui.successPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upb.aviation_access_admin.databinding.FragmentDeleteSuccessBinding

class DeleteSuccessFragment: Fragment(){
    private lateinit var binding:FragmentDeleteSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDeleteSuccessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btConfirmarEliminacion.setOnClickListener {
            val goToMainMenu = DeleteSuccessFragmentDirections.actionDeleteSuccessFragmentToMenuAdminFragment("dfg","df",1)
            findNavController().navigate(goToMainMenu)
        }
    }
}