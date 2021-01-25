package com.example.adopcionmascotasecuador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var service: ApiService
    lateinit var mascotasAdapter:AdaptadorMascota
    var itemMascota:ArrayList<Mascota> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        getAllMascotas()
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        viewMascotas.layoutManager = layoutManager
        viewMascotas.setHasFixedSize(true)
    }

    fun getAllMascotas(){
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
                    if (items != null) {
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

                            mascotasAdapter = AdaptadorMascota(itemMascota)
                            mascotasAdapter.notifyDataSetChanged()

                            Log.d("Todo belen ", mascota.toString())
                        }
                    }
                    viewMascotas.adapter = mascotasAdapter

                }else {
                    Log.e("ERROR: ", response.code().toString())
                }
            }
        }

    }


}