package com.example.adopcionmascotasecuador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.adopcionmascotas.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mascota_gallery.view.*

class AdaptadorMascota(
    private val mascotas: MutableList<Mascota>): RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> (){

    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mascotaNombre = itemView.textMascotaNombre
        var mascotaRaza = itemView.textMascotaRaza
        var mascotaFoto = itemView.imageMascota

        fun initialize(item: Mascota){
            // Inicializa datos para elemento de RecyclerView
            mascotaNombre.text = item.nombre
            mascotaRaza.text = item.raza
            Picasso.get().load(item.foto).into(mascotaFoto)

            itemView.setOnClickListener{

                // Envio de argumentos a InfoMascota
                val idMascota:String =  item.id.toString()
                val infoMascota = arrayOf<String>(idMascota, item.nombre, item.raza,item.contacto,item.sexo, item.foto)
                val bundle = bundleOf("mascotaInfo" to infoMascota)

                // Navigation hacia mascotas_info.xml
                var navInfoMascotas = this.itemView.findNavController().navigate(R.id.nav_info_mascotas,bundle)
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
        holder.initialize(mascotas.get(position))
    }
}
