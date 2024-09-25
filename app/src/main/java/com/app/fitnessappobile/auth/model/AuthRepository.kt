package com.app.fitnessappobile.auth.model

import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService
){
    suspend fun registerUser(user: User): String{
        return authService.register(user)
    }

    suspend fun loginUser(username : String, password : String): String{
        return authService.login(username, password)
    }

    suspend fun deleteUser(username: String): String{
        return authService.deleteUser(username)
    }

    suspend fun getTokenStatus(username: String): String{
        return authService.tokenStatus(username)
    }
}