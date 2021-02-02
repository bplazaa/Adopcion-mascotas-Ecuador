package com.example.adopcionmascotas.ui.login

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client{
    private var client : Retrofit?=null
    fun getClient(baseUrl:String): Retrofit{
        if(client ==null){
            client =Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return client!!

    }

}