package com.app.fitnessappobile.runs.model.responses


import com.google.gson.annotations.SerializedName

data class RunsresponseItem(
    @SerializedName("covered_distance")
    val coveredDistance: String?,
    @SerializedName("CreatedAt")
    val createdAt: String?,
    @SerializedName("DeletedAt")
    val deletedAt: Any?,
    @SerializedName("end_time")
    val endTime: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("run_date")
    val runDate: String?,
    @SerializedName("set_distance")
    val setDistance: String?,
    @SerializedName("start_time")
    val startTime: String?,
    @SerializedName("time_taken")
    val timeTaken: String?,
    @SerializedName("UpdatedAt")
    val updatedAt: String?,
    @SerializedName("username")
    val username: String?
)