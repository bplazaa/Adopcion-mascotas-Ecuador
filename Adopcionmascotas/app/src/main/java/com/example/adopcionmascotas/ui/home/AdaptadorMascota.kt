package com.example.adopcionmascotasecuador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adopcionmascotas.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mascota_gallery.view.*

class AdaptadorMascota(
    private val mascotas: MutableList<Mascota>): RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> (){

    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        return MascotaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.mascota_gallery,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return mascotas.size
    }

    fun addMascotas(mascota:Mascota){
        // Agrega item mascota a lista Recycler View
        mascotas.add(mascota)
        notifyItemInserted(mascotas.size-1)
    }


    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascotaActual = mascotas[position]

        holder.itemView.apply {
            textMascotaNombre.text = mascotaActual.nombre
            textMascotaRaza.text = mascotaActual.raza
            Picasso.get().load(mascotaActual.foto).into(imageMascota)
        }
    }


}