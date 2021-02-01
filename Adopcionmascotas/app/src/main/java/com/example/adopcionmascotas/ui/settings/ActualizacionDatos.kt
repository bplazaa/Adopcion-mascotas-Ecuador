package com.example.adopcionmascotas.ui.settings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adopcionmascotas.R

class ActualizacionDatos : Fragment() {

    companion object {
        fun newInstance() =
            ActualizacionDatos()
    }

    private lateinit var viewModel: ActualizacionDatosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.actualizacion_datos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActualizacionDatosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}