package com.app.fitnessappobile.goals.model.responses


import com.google.gson.annotations.SerializedName

data class GoalMessage(
    @SerializedName("message")
    val message: String?
)