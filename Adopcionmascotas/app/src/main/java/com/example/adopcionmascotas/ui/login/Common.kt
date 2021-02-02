package com.example.adopcionmascotas.ui.login


object Common
{
    val BASE_URL="http://10.0.2.2/db/api/usuario/"
    val api: ApiServiceUser
        get()= Client.getClient(BASE_URL).create(ApiServiceUser::class.java)
}