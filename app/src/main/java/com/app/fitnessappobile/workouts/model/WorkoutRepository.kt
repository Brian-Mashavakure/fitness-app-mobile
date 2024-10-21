package com.app.fitnessappobile.workouts.model

import com.app.fitnessappobile.workouts.model.responses.WorkoutMessage
import com.app.fitnessappobile.workouts.model.responses.WorkoutResponse
import javax.inject.Inject

class WorkoutRepository @Inject constructor(
    private val workoutService: WorkoutService
){
    suspend fun createWorkout(
        token: String?,
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
    ): WorkoutMessage{
        return  workoutService.createWorkout(
            token,
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
            userName
        )
    }

    suspend fun getWorkouts(
        token: String?,
        userName: String
    ) : WorkoutResponse{
        return  workoutService.getWorkouts(
            token,
            userName
        )
    }

    suspend fun updateStreak(
        token: String?,
        userName: String,
        workoutNickname: String
    ): WorkoutMessage{
        return workoutService.updateStreak(
            token,
            userName,
            workoutNickname
        )
    }

    suspend fun deleteWorkout(
        token: String?,
        userName: String,
        workoutNickname: String
    ): WorkoutMessage{
        return workoutService.deleteWorkout(
            token,
            userName,
            workoutNickname
        )
    }
}