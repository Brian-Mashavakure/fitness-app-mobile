package com.app.fitnessappobile.goals.model

import com.app.fitnessappobile.goals.model.responses.GoalMessage
import com.app.fitnessappobile.goals.model.responses.GoalResponse
import retrofit2.http.*

interface GoalService {
    @FormUrlEncoded
    @POST("fitness/goals/addgoal")
    suspend fun addGoal(
        @Header("Authorization") token: String?,
        @Field("title") title: String,
        @Field("goal_description") goalDesc: String,
        @Field("date_set") dateSet: String,
        @Field("finish_date") finishDate: String,
        @Field("username") userName: String,
        @Field("workout_nickname") workoutNickname: String,
    ): GoalMessage

    @FormUrlEncoded
    @GET("fitness/goals/getgoals")
    suspend fun getGoals(
        @Header("Authorization") token: String?,
        @Field("username") userName: String,
    ): GoalResponse


    @FormUrlEncoded
    @PUT("fitness/goals/deletegoal")
    suspend fun deleteGoal(
        @Header("Authorization") token: String?,
        @Field("username") userName: String,
        @Field("title") title: String,
    ): GoalMessage
}