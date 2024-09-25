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

    var user = User(
        "Tafadzwa Mashavakure",
        "tafadzwa.xxiii@gmail.com",
        "23",
        "Male",
        "tafadzwaaaaaaa",
        "zinixiwe"
    )

    fun registerUser() = viewModelScope.launch{
        val registerResponse = authRepo.registerUser(user)
        Log.e("Register Response Baby", "${registerResponse.toString()}")
    }

}