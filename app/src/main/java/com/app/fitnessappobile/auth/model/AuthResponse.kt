package com.app.fitnessappobile.auth.model


import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("message")
    val message: String
)