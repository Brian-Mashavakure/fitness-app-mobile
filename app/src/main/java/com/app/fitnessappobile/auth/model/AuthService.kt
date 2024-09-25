package com.app.fitnessappobile.auth.model

import retrofit2.http.*

interface AuthService{
    @POST("auth/register")
    suspend fun register(@Body user: User): String
   
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(@Field("username") username: String, @Field("password") password: String): String

    @FormUrlEncoded
    @POST("auth/deleteuser")
    suspend fun deleteUser(@Field("username") username : String): String


    @FormUrlEncoded
    @POST("auth/tokenstatus")
    suspend fun tokenStatus(@Field("username") username : String): String
}
