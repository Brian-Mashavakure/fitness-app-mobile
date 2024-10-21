package com.app.fitnessappobile.workouts.model.responses


import com.google.gson.annotations.SerializedName

data class WorkoutMessage(
    @SerializedName("message")
    val message: String
)