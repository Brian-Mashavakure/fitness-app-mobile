package com.app.fitnessappobile.auth.viewmodel

import android.app.Application
import android.content.*
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitnessappobile.auth.model.AuthRepository
import com.app.fitnessappobile.auth.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    application: Application,
    private val authRepo: AuthRepository
) : AndroidViewModel(application) {

    //application context
    private val applicatonContext = getApplication<Application>().applicationContext

    //preferences reference
    val sharedPrefs = applicatonContext?.getSharedPreferences("Token_Store", MODE_PRIVATE)

    //sign up
    fun registerUser(){
        try{
            viewModelScope.launch(Dispatchers.IO){
                val registerResponse = authRepo.registerUser(
                    "Alison Masakadza",
                    "ali.xxiii@gmail.com",
                    "24",
                    "Female",
                    "Ali",
                    "zinixiwe"
                )

                //save token in shared pref
                val prefEditor = sharedPrefs?.edit()
                prefEditor?.putString("token", registerResponse.message)
                prefEditor?.commit()

                Log.e("Register", "${registerResponse.toString()}")
            }
        }catch (e : Exception){
            Log.e("Error", "Registration failed : ${e.message}")
        }
    }


    //login
    fun loginUser(){
        try{
            viewModelScope.launch(Dispatchers.IO){
                val loginResponse = authRepo.loginUser(
                    "Ali",
                    "zinixiwe"
                )
                Log.e("Login", "${loginResponse.toString()}")
            }

            //print token
//            val tokenString = sharedPrefs?.getString("token", "")
//            Log.e("Token", "${tokenString}")
        }catch(e :Exception){
            Log.e("Error", "Login Failed: ${e.message}")
        }
    }
}