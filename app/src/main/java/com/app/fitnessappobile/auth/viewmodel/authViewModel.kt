package com.app.fitnessappobile.auth.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitnessappobile.auth.model.AuthRepository
import com.app.fitnessappobile.auth.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepo: AuthRepository
) : ViewModel() {

    //sign up
    fun registerUser(){
        try{
            viewModelScope.launch{
                val registerResponse = authRepo.registerUser(
                    "Tafadzwa Mashavakure",
                    "tafadzwa.xxiiis@gmail.com",
                    "23",
                    "Male",
                    "brian",
                    "zinixiwe"
                )
                Log.e("Register", "${registerResponse.toString()}")
            }
        }catch (e : Exception){
            Log.e("Error", "Registration failed : ${e.message}")
        }
    }


    //login
    fun loginUser(){
        try{
            viewModelScope.launch {
                val loginResponse = authRepo.loginUser(
                    "vongai",
                    "zinixiwe"
                )
                Log.e("Login", "${loginResponse.toString()}")
            }
        }catch(e :Exception){
            Log.e("Error", "Login Failed: ${e.message}")
        }
    }
}