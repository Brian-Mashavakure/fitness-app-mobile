package com.app.fitnessappobile.workouts.viewmodel

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.fitnessappobile.workouts.model.WorkoutRepository
import com.app.fitnessappobile.workouts.model.responses.WorkoutResponse
import com.app.fitnessappobile.workouts.model.responses.WorkoutResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    application: Application,
    private val workoutRepo: WorkoutRepository
) : AndroidViewModel(application){

    //application context
    private val applicationContext = getApplication<Application>().applicationContext

    //preferences reference
    val sharedPrefs = applicationContext?.getSharedPreferences("Token_Store", MODE_PRIVATE)

    //token
    val tokenString = sharedPrefs?.getString("token", "")

    private val _creationStatus = MutableLiveData<String>()
    val creationStatus : LiveData<String> = _creationStatus

    //create workout
    fun workoutCreate(
        workoutNickname: String,
        warmupActivity: String,
        warmupTime: String,
        cardioActivity: String,
        cardioTime: String,
        strengthActivity: String,
        strengthTime: String,
        coreActivity: String,
        coreTime: String,
        flexActivity: String,
        flexTime: String,
        cooldownActivity: String,
        cooldownTime: String,
        userName: String,
    ){
        try{
            //val tokenString = sharedPrefs?.getString("token", "")

            viewModelScope.launch (Dispatchers.IO){
                val response = workoutRepo.createWorkout(
                    tokenString,
                    workoutNickname,
                    warmupActivity,
                    warmupTime,
                    cardioActivity,
                    cardioTime,
                    strengthActivity,
                    strengthTime,
                    coreActivity,
                    coreTime,
                    flexActivity,
                    flexTime,
                    cooldownActivity,
                    cooldownTime,
                    userName,
                )

                if(response.message == "Workout Created Successfully"){
                    _creationStatus.postValue("Success")
                    Log.e("Creation", "${response.message}")
                }else{
                    Log.e("Error", "Creation failed: ${response.message}")
                    _creationStatus.postValue("Failure")
                }
            }
        }catch (e: Exception){
            Log.e("Error", "Creation failed: ${e.message}")
            _creationStatus.postValue("Failure")
        }
    }

    //retrieve workouts
    private val _getStatus = MutableLiveData<String>()
    val getStatus: LiveData<String> = _getStatus

    private val _workoutsList = MutableLiveData<List<WorkoutResponseItem?>>()
    val workoutsList: LiveData<List<WorkoutResponseItem?>> = _workoutsList


    //TODO: Find way to autopick username
    fun retrieveWorkouts(
        userName: String
    ){
        try{
            //val tokenString = sharedPrefs?.getString("token", "")
            viewModelScope.launch(Dispatchers.IO) {
                val response = workoutRepo.getWorkouts(
                    tokenString,
                    userName
                )

                if(response.isNotEmpty()){
                    _getStatus.postValue("Success")
                    _workoutsList.postValue(response)
                    //TODO: Handle workouts
                    Log.e("Workouts", "${response.size}")
                }else{
                    Log.e("Error","Workouts found: ${response.size}")
                    _getStatus.postValue("Failure")
                }
            }
        }catch (e: Exception){
            Log.e("Error","Error trying to retrieve workouts: ${e.message}")
            _getStatus.postValue("Failure")
        }
    }


    //update streak
    private val _streakStatus = MutableLiveData<String>()
    val streakStatus: LiveData<String> = _streakStatus

    fun streakUpdate(
        userName: String,
        workoutNickname: String
    ){
        try{
            viewModelScope.launch(Dispatchers.IO) {
                val response = workoutRepo.updateStreak(
                    tokenString,
                    userName,
                    workoutNickname
                )

                if(response.message == "Successfully updated streak"){
                    //TODO: Update streak UI +1
                    Log.e("Streak", "Streak successfully updated")
                    _streakStatus.postValue("Success")
                }else{
                    Log.e("Error","Failed to update streak: ${response.message}")
                    _streakStatus.postValue("Failure")
                }
            }
        }catch(e : Exception){
            Log.e("Error","Error trying to update streak: ${e.message}")
            _streakStatus.postValue("Failure")
        }
    }

    //delete workout
    private val _deletionStatus = MutableLiveData<String>()
    val deletionStatus: LiveData<String> = _deletionStatus

    fun workoutDeletion(
       userName: String,
       workoutNickname: String
    ){
        try{
            viewModelScope.launch(Dispatchers.IO) {
                val response = workoutRepo.deleteWorkout(
                    tokenString,
                    userName,
                    workoutNickname
                )

                if(response.message == "Successfully updated streak"){
                    //TODO: Update streak UI to remove workout
                    Log.e("Streak", "Workout successfully deleted")
                    _deletionStatus.postValue("Success")
                }else{
                    Log.e("Error","Failed to delete workout: ${response.message}")
                    _deletionStatus.postValue("Failure")
                }

            }

        }catch (e: Exception){
            Log.e("Error","Error trying to delete workout: ${e.message}")
            _deletionStatus.postValue("Failure")
        }
    }


}