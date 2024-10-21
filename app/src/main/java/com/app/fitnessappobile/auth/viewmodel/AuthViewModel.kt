package com.app.fitnessappobile.auth.viewmodel

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.lifecycle.*
import com.app.fitnessappobile.auth.model.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    application: Application,
    private val authRepo: AuthRepository
) : AndroidViewModel(application) {

    //livedata
    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    private val _registerStatus = MutableLiveData<String>()
    val registerStatus: LiveData<String> = _registerStatus

    //application context
    private val applicationContext = getApplication<Application>().applicationContext

    //preferences reference
    val sharedPrefs = applicationContext?.getSharedPreferences("Token_Store", MODE_PRIVATE)

    //sign up
    fun registerUser(
        name: String, email: String, age: String, gender: String, userName: String, password: String
    ){
        try{
            viewModelScope.launch(Dispatchers.IO){
                val registerResponse = authRepo.registerUser(
                    name,
                    email,
                    age,
                    gender,
                    userName,
                    password
                )

                if(registerResponse.message != null){
                    //format token
                    var formattedToken = registerResponse.message.removeSurrounding("\"")

                    //save token in shared pref
                    val prefEditor = sharedPrefs?.edit()
                    prefEditor?.putString("token", formattedToken)
                    prefEditor?.commit()

                    _registerStatus.postValue("Success")

                    Log.e("Register", "${registerResponse.toString()}")
                }else{
                    _registerStatus.postValue("Failure")
                }
            }
        }catch (e : Exception){
            Log.e("Error", "Registration failed : ${e.message}")
            _registerStatus.postValue("Failure")
        }
    }


    //login
    fun loginUser(
        userName: String, password: String
    ){
        try{
            val tokenString = sharedPrefs?.getString("token", "")

            //Log.e("token","$tokenString")

            viewModelScope.launch(Dispatchers.IO){
                try{
                    val loginResponse = authRepo.loginUser(
                        tokenString,
                        userName,
                        password
                    )

                    if(loginResponse.message == "Logged in successfully"){
                        _loginStatus.postValue("Logged")
                        Log.e("Login", "${loginResponse.toString()}")
                    }else{
                        _loginStatus.postValue("Failed")
                    }
                }catch (e : Exception){
                    Log.e("Error", "Login Failed: ${e.message}")
                    _loginStatus.postValue("Failed")
                }
            }

        }catch(e : Exception){
            Log.e("Error", "Login Failed: ${e.message}")
            _loginStatus.postValue("Failed")
        }
    }
}