package com.app.fitnessappobile.runs.model

import com.app.fitnessappobile.runs.model.responses.RunMessage
import com.app.fitnessappobile.runs.model.responses.Runsresponse
import javax.inject.Inject

class RunsRepository @Inject constructor(
    private val runsService: RunsService
){
    suspend fun  createRun(
        token: String?,
        setDistance: String,
        startTime: String,
        endTime: String,
        coveredDistance: String,
        timeTaken: String,
        runDate: String,
        userName: String,
    ): RunMessage{
        return runsService.createRun(
            token,
            setDistance,
            startTime,
            endTime,
            coveredDistance,
            timeTaken,
            runDate,
            userName,
        )
    }


    suspend fun getRuns(
        token: String?,
        userName: String
    ): Runsresponse{
        return runsService.getRuns(
            token,
            userName
        )
    }

    suspend fun getLeaderboard(
        token: String?,
        userName: String,
        runDate: String
    ): Runsresponse{
        return runsService.getLeaderboard(
            token,
            userName,
            runDate
        )
    }

    suspend fun deleteRun(
        token: String?,
        userName: String,
        ID: String
    ):RunMessage{
        return runsService.deleteRun(
            token,
            userName,
            ID
        )
    }
}