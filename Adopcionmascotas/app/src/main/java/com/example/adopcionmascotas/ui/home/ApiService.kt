package com.example.adopcionmascotasecuador

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.lang.StringBuilder

interface ApiService {
    // Get ALL
    @GET("read.php")
    suspend fun getAllMascotasAPI():Response<NestedJSONModel>

    // Delete
    @Headers("Content-Type: application/json")
    @HTTP(method= "DELETE", path = "delete.php", hasBody = true)
    suspend fun deleteMascotas(@Body headers:Map<String, String>): Response<ResponseBody>
}

public class ApiRequest(id:Int) {


}
