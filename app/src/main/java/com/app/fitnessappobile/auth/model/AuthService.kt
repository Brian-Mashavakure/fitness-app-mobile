package com.app.fitnessappobile.auth.model

import retrofit2.http.*

interface  AuthService{
    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("age") age : String,
        @Field("gender") gender : String,
        @Field("username") username : String,
        @Field("password") password : String,
    ): AuthResponse


    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Header("Token") token: String?,
        @Field("username") username: String,
        @Field("password") password: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("auth/deleteuser")
    suspend fun deleteUser(@Field("username") username : String): AuthResponse


    @FormUrlEncoded
    @POST("auth/tokenstatus")
    suspend fun tokenStatus(@Field("username") username : String): AuthResponse
}
