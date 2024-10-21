package com.app.fitnessappobile.workouts.model

import com.app.fitnessappobile.workouts.model.responses.WorkoutMessage
import com.app.fitnessappobile.workouts.model.responses.WorkoutResponse
import retrofit2.http.*

interface WorkoutService {
    @FormUrlEncoded
    @POST("fitness/workouts/createworkout")
    suspend fun createWorkout(
        @Header("Authorization") token : String?,
        @Field("workout_nickname") workoutNickname: String,
        @Field("warmup_activity") warmupActivity: String,
        @Field("warmup_time") warmupTime: String,
        @Field("cardio_activity") cardioActivity: String,
        @Field("cardio_time") cardioTime: String,
        @Field("strength_activity") strengthActivity: String,
        @Field("strength_time") strengthTime: String,
        @Field("core_activity") coreActivity: String,
        @Field("core_time") coreTime: String,
        @Field("flex_activity") flexActivity: String,
        @Field("flex_time") flexTime: String,
        @Field("cooldown_activity") cooldownActivity: String,
        @Field("cooldown_time") cooldownTime: String,
        @Field("username") userName: String,
    ): WorkoutMessage

    @FormUrlEncoded
    @GET("fitness/workouts/getworkouts")
    suspend fun getWorkouts(
        @Header("Authorization") token : String?,
        @Field("username") userName: String
    ): WorkoutResponse

    @FormUrlEncoded
    @PUT("fitness/workouts/updatestreak")
    suspend fun updateStreak(
        @Header("Authorization") token : String?,
        @Field("username") userName: String,
        @Field("workout_nickname") workoutNickname: String
    ): WorkoutMessage


    @FormUrlEncoded
    @PUT("fitness/workouts/deleteworkout")
    suspend fun deleteWorkout(
        @Header("Authorization") token : String?,
        @Field("username") userName: String,
        @Field("workout_nickname") workoutNickname: String
    ): WorkoutMessage

}