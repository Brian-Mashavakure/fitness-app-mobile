package com.app.fitnessappobile.room_db.dao

import androidx.room.*
import com.app.fitnessappobile.room_db.entity.Run
import com.app.fitnessappobile.room_db.entity.Workout


@Dao
interface RunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Query("SELECT * FROM runs")
    suspend fun getAllRuns(): List<Run>

    @Query("SELECT * FROM runs WHERE run_date = :runDate")
    suspend fun getRunsByDate(runDate: String): List<Run>


    @Query("SELECT * FROM runs WHERE run_date = :runDate")
    suspend fun getSingleRunByDate(runDate: String): Run

    @Delete
    suspend fun deleteRun(run: Run)
}