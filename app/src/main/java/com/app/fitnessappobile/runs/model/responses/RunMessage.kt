package com.app.fitnessappobile.runs.model.responses


import com.google.gson.annotations.SerializedName

data class RunMessage(
    @SerializedName("message")
    val message: String?
)