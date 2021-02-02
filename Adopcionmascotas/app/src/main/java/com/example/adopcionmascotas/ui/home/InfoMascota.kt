package com.example.adopcionmascotas.ui.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.adopcionmascotas.R
import com.example.adopcionmascotasecuador.ApiRequest
import com.example.adopcionmascotasecuador.ApiService
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException
lateinit var idMascota:String

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

        var stringId = mascota?.get(0)
        idMascota = stringId!!
//        idMascota = stringId!!.toInt()

//        var idMascota = mascota?.get(0)
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

        var buttonAdoptar:Button = root.findViewById(R.id.buttonAdoptarMascota)

        // Dialog Adopcion
        var dialogMascota = AdoptarMascotaDialog()
        buttonAdoptar.setOnClickListener {
            dialogMascota.show(this.parentFragmentManager, "Dialog")
        }
        return root

    }

    class AdoptarMascotaDialog : DialogFragment(){
        lateinit var service: ApiService

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            return activity?.let {
                val builder = AlertDialog.Builder(it)
                builder.setMessage("¿Está seguro que desea realizar esta acción?")
                    .setPositiveButton("Confirmar",
                    DialogInterface.OnClickListener {dialog, id ->
                        // Adoptar

                        val retrofit: Retrofit = Retrofit.Builder()
                            .baseUrl("http://192.168.11.8/db/api/mascota/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                        service = retrofit.create<ApiService>(ApiService::class.java)

                        CoroutineScope(Dispatchers.IO).launch {
                            val response = service.deleteMascotas(mapOf<String,String>("id" to idMascota))
                            withContext(Dispatchers.Main) {
//                                if(response.){
//                                    Log.e("RETROFIT_ERROR","Error")
//                                }
//                                if (response.isExecuted) {
//
//                                    // Convert raw JSON to pretty JSON using GSON library
////                                    val gson = GsonBuilder().setPrettyPrinting().create()
////                                    val prettyJson = gson.toJson(
////                                        JsonParser.parseString(
//////                                            response.b
//////                                                ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
////                                        )
////                                    )
//
////                                    Log.d("Pretty Printed JSON :", prettyJson)
//
//                                } else {
//
////                                    Log.e("RETROFIT_ERROR", response.code().toString())
//
//                                }
                            }
                        }
                    })
                    .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener {dialog, id ->
                        // Cancelar
                    })
                builder.create()
            }?: throw IllegalStateException("Error")
        }

    }



    fun adoptarMascota(){

    }




}
