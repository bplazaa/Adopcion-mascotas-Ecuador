package com.example.adopcionmascotas.ui.home

import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adopcionmascotas.R
import com.example.adopcionmascotasecuador.Mascota
import com.example.adopcionmascotasecuador.OnMascotaItemClickListener
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.mascota_gallery.view.*
import kotlinx.android.synthetic.main.mascota_info.*

class InfoMascota : Fragment(){

    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.mascota_info, container, false)

        return root

    }


}
