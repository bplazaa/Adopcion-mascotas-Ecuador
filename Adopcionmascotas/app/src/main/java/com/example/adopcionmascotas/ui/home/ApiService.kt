package com.example.adopcionmascotasecuador

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("read.php")
//    suspend fun getAllPosts():Response<ResponseBody>
    suspend fun getAllMascotasAPI():Response<NestedJSONModel>

//    @GET("posts/{id}")
//    fun getPostById(@Path("id") id: Int): Call<Mascota>

//
//    @POST("posts/{id}")
//    fun editPostById(@Path("id") id: Int, @Body post: Mascota?): Call<Mascota>


}