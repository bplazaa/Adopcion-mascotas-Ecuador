package com.example.adopcionmascotasecuador

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.lang.StringBuilder

interface ApiService {
    @GET("read.php")
//    suspend fun getAllPosts():Response<ResponseBody>
    suspend fun getAllMascotasAPI():Response<NestedJSONModel>

//    @HTTP(method= "DELETE", path = "delete.php", hasBody = true)
//    suspend fun deleteMascotas(@Body requestMascota:ApiRequest): Call<ResponseBody>

    @DELETE("delete.php")
    suspend fun deleteMascotas(@HeaderMap headers:Map<String, String>)


//    Call<Analysis_Delete_RequestResult_Api10> analysis_delete_api10(@Field("seq") String seq);
//
//    @DELETE("delete.php")
//    suspend fun deleteMascota(@Body requestMascota:ApiRequest):Response<ResponseBody>

}

public class ApiRequest(id:Int) {


}
