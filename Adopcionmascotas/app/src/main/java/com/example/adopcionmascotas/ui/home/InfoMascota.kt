package com.example.adopcionmascotas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.adopcionmascotas.R
import com.squareup.picasso.Picasso

class InfoMascota : Fragment(){
    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.mascota_info, container, false)

        // Recibe argumento de AdaptadorMascota
        var mascota = arguments?.getStringArray("mascotaInfo")

        var idMascota = mascota?.get(0)
        var nombre = mascota?.get(1)
        var raza = mascota?.get(2)
        var contacto = mascota?.get(3)
        var sexo = mascota?.get(4)
        var foto = mascota?.get(5)

        // Update UI
        root.findViewById<TextView>(R.id.infoNombreMascota).text = nombre
        root.findViewById<TextView>(R.id.infoRazaMascota).text = raza
        root.findViewById<TextView>(R.id.infoSexoMascota).text = sexo
        root.findViewById<TextView>(R.id.infoContactoMascota).text = contacto

        // Carga de imagen desde url
        Picasso.get().load(foto).into(root.findViewById<ImageView>(R.id.infoFotoMascota))

        return root
    }
}
