package com.app.fitnessappobile.runs.model

import com.app.fitnessappobile.runs.model.responses.RunMessage
import com.app.fitnessappobile.runs.model.responses.Runsresponse
import retrofit2.http.*

interface RunsService {
    @FormUrlEncoded
    @POST("fitness/runs/createrun")
    suspend fun createRun(
        @Header("Authorization") token : String?,
        @Field("set_distance") setDistance: String,
        @Field("start_time") startTime: String,
        @Field("end_time") endTime: String,
        @Field("covered_distance") coveredDistance: String,
        @Field("time_taken") timeTaken: String,
        @Field("run_date") runDate: String,
        @Field("username") userName: String,
    ): RunMessage

    @FormUrlEncoded
    @GET("fitness/runs/getruns")
    suspend fun getRuns(
        @Header("Authorization") token : String?,
        @Field("username") userName: String
    ): Runsresponse

    @FormUrlEncoded
    @GET("fitness/runs/runsleaderboard")
    suspend fun getLeaderboard(
        @Header("Authorization") token : String?,
        @Field("username") userName : String,
        @Field("run_date") runDate: String
    ): Runsresponse

    @FormUrlEncoded
    @PUT("fitness/runs/deleterun")
    suspend fun deleteRun(
        @Header("Authorization") token : String?,
        @Field("username") userName: String,
        @Field("id") ID: String?
    ): RunMessage

}