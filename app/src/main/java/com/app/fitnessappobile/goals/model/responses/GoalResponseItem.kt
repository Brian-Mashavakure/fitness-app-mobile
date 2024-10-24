package com.app.fitnessappobile.goals.model.responses


import com.google.gson.annotations.SerializedName

data class GoalResponseItem(
    @SerializedName("CreatedAt")
    val createdAt: String?,
    @SerializedName("date_set")
    val dateSet: String?,
    @SerializedName("DeletedAt")
    val deletedAt: Any?,
    @SerializedName("finish_date")
    val finishDate: String?,
    @SerializedName("goal_description")
    val goalDescription: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("UpdatedAt")
    val updatedAt: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("workout_nickname")
    val workoutNickname: String?
)