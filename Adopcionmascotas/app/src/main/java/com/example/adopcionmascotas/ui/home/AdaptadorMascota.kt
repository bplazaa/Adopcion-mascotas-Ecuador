package com.example.adopcionmascotasecuador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.adopcionmascotas.R
import com.example.adopcionmascotas.ui.home.InfoMascota
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mascota_gallery.view.*

class AdaptadorMascota(
    private val mascotas: MutableList<Mascota>, var clickListener: OnMascotaItemClickListener): RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> (){

    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mascotaNombre = itemView.textMascotaNombre
        var mascotaRaza = itemView.textMascotaRaza
        var mascotaFoto = itemView.imageMascota

        fun initialize(item: Mascota,action:OnMascotaItemClickListener){
            mascotaNombre.text = item.nombre
            mascotaRaza.text = item.raza
            Picasso.get().load(item.foto).into(mascotaFoto)

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
                var navInfoMascotas = this.itemView.findNavController().navigate(R.id.nav_info_mascotas)



//                val textNombre:TextView = itemView.findViewById(R.id.infoNombreMascota)
//                textNombre.text = nombre


            }
        }

    }

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
//        val mascotaActual = mascotas[position]
//
//        holder.itemView.apply {
//            textMascotaNombre.text = mascotaActual.nombre
//            textMascotaRaza.text = mascotaActual.raza
//            Picasso.get().load(mascotaActual.foto).into(imageMascota)
//        }

        holder.initialize(mascotas.get(position), clickListener)


    }
}

interface OnMascotaItemClickListener{
    fun onItemClick(item:Mascota, position: Int)

}