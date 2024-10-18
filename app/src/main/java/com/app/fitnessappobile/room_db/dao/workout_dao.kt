package com.app.fitnessappobile.room_db.dao

import androidx.room.*
import com.app.fitnessappobile.room_db.entity.Workout

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: Workout)

    @Query("SELECT * FROM workout")
    suspend fun getAllWorkouts(): List<Workout>

    @Query("SELECT * FROM workout WHERE workout_date = :workoutDate")
    suspend fun getWorkoutsByDate(workoutDate: String): List<Workout>


    @Query("SELECT * FROM workout WHERE workout_date = :workoutDate")
    suspend fun getSingleWorkoutByDate(workoutDate: String): Workout

    @Delete
    suspend fun deleteWorkout(workout: Workout)
}