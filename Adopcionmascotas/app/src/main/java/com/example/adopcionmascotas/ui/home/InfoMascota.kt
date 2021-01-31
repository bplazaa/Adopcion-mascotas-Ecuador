package com.example.adopcionmascotas.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adopcionmascotas.R
import com.example.adopcionmascotasecuador.Mascota
import kotlinx.android.synthetic.main.fragment_home.view.*

class InfoMascota : Fragment(){
//    lateinit var mascota: Mascota

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.mascota_info, container, false)

        root.viewMascotas.layoutManager = LinearLayoutManager(this.context)
        root.viewMascotas.setHasFixedSize(true)

        return root
    }







}
