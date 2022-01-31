package com.upb.aviation_access_admin.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.upb.aviation_access_admin.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginFragment: Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var idUser:Int
        binding.buttonNext.setOnClickListener {
            val username=binding.userNameLogin.text.toString()
            val password=binding.userPasswordLogIn.text.toString()
            loginViewModel.login(username,password).onEach {
                idUser=it.Id_user
                Toast.makeText(context,"Credenciales correctas", Toast.LENGTH_SHORT).show()
                Log.d("Main","Id usuario: $it")
                val goToAdmiMenu= LoginFragmentDirections.actionLoginFragmentToMenuAdminFragment(username,password,idUser)
                findNavController().navigate(goToAdmiMenu)
            }.catch {
                Toast.makeText(context,"Usuario o password incorrecto", Toast.LENGTH_SHORT).show()
            }.launchIn(CoroutineScope(Dispatchers.Main))
        }
    }



}