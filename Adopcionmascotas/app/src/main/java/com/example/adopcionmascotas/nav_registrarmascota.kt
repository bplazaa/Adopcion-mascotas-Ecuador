package com.example.adopcionmascotas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.adopcionmascotasecuador.ApiService
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class nav_registrarmascota : Fragment() {

    lateinit var root:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.nav_registrarmascota, container, false)
        return root
        
    }


     private fun addPet(){

         lateinit var service: ApiService

         // Valor de lo que ingresa
         var nombre = root.findViewById<TextInputEditText>(R.id.txtNombre).text.toString()
         var raza = root.findViewById<TextInputEditText>(R.id.txtRaza).text.toString()
         var contacto = root.findViewById<TextInputEditText>(R.id.txtContacto).text.toString()
         var sexo = root.findViewById<TextInputEditText>(R.id.txtSexo).text.toString()
         var foto = root.findViewById<TextInputEditText>(R.id.txtFoto).text.toString()
         var radio = root.findViewById<RadioGroup>(R.id.RadioGroupEspecie)
         val radioButtonId: Int = radio.getCheckedRadioButtonId()
         val radioButton: View = radio .findViewById(radioButtonId)
         val indice: Int = radio.indexOfChild(radioButton)
         val rb = radio .getChildAt(indice) as RadioButton
         val especie = rb.text.toString()

         //mapa del post
         var mapa = mapOf<String,String>("nombre" to nombre,"raza" to raza,"contacto" to contacto,"sexo" to sexo ,"especie" to especie,"foto" to foto)

         // boton registrar
         var buttonRegistrar: Button = root.findViewById(R.id.btnRegistrar)

         // evento del boton
         buttonRegistrar.setOnClickListener{
             val retrofit: Retrofit = Retrofit.Builder()
                 .baseUrl("http://192.168.11.8/db/api/mascota/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()

             service = retrofit.create<ApiService>(ApiService::class.java)
             CoroutineScope(Dispatchers.IO).launch {
                 val response =service.createMascotas(mapa)
                 withContext(Dispatchers.Main) {

                     if(response.isSuccessful){
                         Log.i("POST HTTP okay",response.body()!!.string())

                     }
                     else{
                         Log.e("POST HTPP ERROR", response.body().toString())
                     }
                 }
             }
         }
     }

}