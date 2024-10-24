package com.app.fitnessappobile.goals.model

import com.app.fitnessappobile.goals.model.responses.GoalMessage
import com.app.fitnessappobile.goals.model.responses.GoalResponse
import javax.inject.Inject

class GoalRepository @Inject constructor(
    private val goalService: GoalService
) {
    suspend fun addGoal(
       token: String?,
       title: String,
       goalDesc: String,
       dateSet: String,
       finishDate: String,
       userName: String,
       workoutNickname: String
    ): GoalMessage{
        return goalService.addGoal(
            token,
            title,
            goalDesc,
            dateSet,
            finishDate,
            userName,
            workoutNickname
        )
    }


    suspend fun getGoals(
        token: String?,
        userName: String
    ): GoalResponse{
        return goalService.getGoals(token,userName)
    }

    suspend fun deleteGoal(
        token: String?,
        userName: String,
        title: String
    ): GoalMessage{
        return goalService.deleteGoal(
            token, userName, title
        )
    }
}