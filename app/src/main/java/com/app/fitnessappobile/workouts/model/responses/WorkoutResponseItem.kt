package com.app.fitnessappobile.workouts.model.responses


import com.google.gson.annotations.SerializedName

data class WorkoutResponseItem(
    @SerializedName("cardio_activity")
    val cardioActivity: String?,
    @SerializedName("cardio_time")
    val cardioTime: String?,
    @SerializedName("cooldown_activity")
    val cooldownActivity: String?,
    @SerializedName("cooldown_time")
    val cooldownTime: String?,
    @SerializedName("core_activity")
    val coreActivity: String?,
    @SerializedName("core_time")
    val coreTime: String?,
    @SerializedName("CreatedAt")
    val createdAt: String?,
    @SerializedName("DeletedAt")
    val deletedAt: Any?,
    @SerializedName("flex_activity")
    val flexActivity: String?,
    @SerializedName("flex_time")
    val flexTime: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("streak")
    val streak: String?,
    @SerializedName("strength_activity")
    val strengthActivity: String?,
    @SerializedName("strength_time")
    val strengthTime: String?,
    @SerializedName("UpdatedAt")
    val updatedAt: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("warmup_activity")
    val warmupActivity: String?,
    @SerializedName("warmupt_time")
    val warmuptTime: String?,
    @SerializedName("workout_date")
    val workoutDate: String?,
    @SerializedName("workout_nickname")
    val workoutNickname: String?
)