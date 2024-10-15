package com.app.fitnessappobile.auth.model

import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService
){
    suspend fun registerUser(
        name: String,
        email: String,
        age: String,
        gender: String,
        username: String,
        password: String,
    ): AuthResponse
    {
        return authService.register(
            name,
            email,
            age,
            gender,
            username,
            password
        )
    }

    suspend fun loginUser(token: String?, username : String, password : String): AuthResponse{
        return authService.login(token ,username, password)
    }

    suspend fun deleteUser(username: String): AuthResponse{
        return authService.deleteUser(username)
    }

    suspend fun getTokenStatus(username: String): AuthResponse{
        return authService.tokenStatus(username)
    }
}