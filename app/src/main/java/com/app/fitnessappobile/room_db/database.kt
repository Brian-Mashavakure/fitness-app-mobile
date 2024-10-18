package com.app.fitnessappobile.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.fitnessappobile.room_db.dao.GoalDao
import com.app.fitnessappobile.room_db.dao.RunDao
import com.app.fitnessappobile.room_db.dao.WorkoutDao
import com.app.fitnessappobile.room_db.entity.Goal
import com.app.fitnessappobile.room_db.entity.Run
import com.app.fitnessappobile.room_db.entity.Workout


@Database(entities = [Workout::class, Run::class, Goal::class], version = 1)
abstract class FitXDatabase: RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
    abstract fun runDao(): RunDao
    abstract fun goalDao(): GoalDao
}