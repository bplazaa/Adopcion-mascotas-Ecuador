package com.example.adopcionmascotas.ui.login



import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST






interface ApiServiceUser{
    @FormUrlEncoded
    @POST("register.php")
    fun registerUser(@Field("name") name:String,@Field("email") email:String, @Field("password") password:String) : Call<APIResponse>

    @POST("login.php")
    fun loginUser(@Field("email") email:String,@Field("password") password:String): Call<APIResponse>



}