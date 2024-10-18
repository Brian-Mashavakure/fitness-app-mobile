package com.app.fitnessappobile.room_db.dao

import androidx.room.*
import com.app.fitnessappobile.room_db.entity.Goal

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(goal: Goal)

    @Query("SELECT * FROM goals")
    suspend fun getAllGoals(): List<Goal>


    @Query("SELECT * FROM goals WHERE title = :title")
    suspend fun getSingleWorkoutByDate(title: String): Goal

    @Delete
    suspend fun deleteGoal(goal: Goal)
}