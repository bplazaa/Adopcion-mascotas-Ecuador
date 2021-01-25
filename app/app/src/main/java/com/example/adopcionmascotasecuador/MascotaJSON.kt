package com.example.adopcionmascotasecuador

import com.google.gson.annotations.SerializedName

data class NestedJSONModel(
    var records:List<Record>?
)

data class Record(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("nombre")
    val nombre: String?,

    @SerializedName("raza")
    val raza: String?,

    @SerializedName("contacto")
    val contacto: String?,

    @SerializedName("sexo")
    val sexo: String?,

    @SerializedName("especie")
    val especie: String?,

    @SerializedName("foto")
    val foto: String?

)