package com.example.adopcionmascotas.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adopcionmascotas.R
import com.example.adopcionmascotasecuador.AdaptadorMascota
import com.example.adopcionmascotasecuador.ApiService
import com.example.adopcionmascotasecuador.Mascota
import com.example.adopcionmascotasecuador.OnMascotaItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment(), OnMascotaItemClickListener{

    lateinit var service: ApiService
    lateinit var mascotasAdapter: AdaptadorMascota
    var itemMascota:ArrayList<Mascota> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        root.viewMascotas.layoutManager = LinearLayoutManager(this.context)
        root.viewMascotas.setHasFixedSize(true)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.11.8/db/api/mascota/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<ApiService>(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val response = service.getAllMascotasAPI()

            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {

                    val items = response.body()?.records
                    if (items != null && itemMascota.isEmpty()) {
                        for (i in 0 until items.count()) {

                            val id = items[i].id ?: 0
                            val nombre = items[i].nombre ?: "N/A"
                            val raza = items[i].raza ?: "N/A"
                            val contacto = items[i].contacto ?: "N/A"
                            val sexo = items[i].sexo ?: "N/A"
                            val especie = items[i].especie ?: "N/A"
                            val foto = items[i].foto ?: "N/A"


                            val mascota = Mascota(id,nombre,raza,contacto,sexo,especie,foto)

                            itemMascota.add(mascota)

                            mascotasAdapter = AdaptadorMascota(itemMascota,this@HomeFragment)
                            mascotasAdapter.notifyDataSetChanged()

                            Log.d("Correcto", mascota.toString())
                        }
                    }
                    viewMascotas.adapter = mascotasAdapter
                }
                else {
                    Log.e("ERROR: ", response.code().toString())
                }
            }
        }
        return root

    }

    override fun onItemClick(item: Mascota, position: Int) {
//        Toast.makeText(this.context,item.nombre,Toast.LENGTH_LONG).show()
//
//        val intent = Intent(this.context,DatosMascota::class.java)
//        intent.putExtra("MASCOTANAME", item.nombre)
//
//        startActivity(intent)






    }


}