package com.app.fitnessappobile.room_db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout")
data class Workout(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "workout_nickname") val workoutNickname: String,
    @ColumnInfo(name = "warmup_activity") val warmupActivity: String,
    @ColumnInfo(name = "warmup_time") val warmupTime: String,
    @ColumnInfo(name = "cardio_activity") val cardioActivity: String,
    @ColumnInfo(name = "cardio_time") val cardioTime: String,
    @ColumnInfo(name = "strength_activity") val strengthActivity: String,
    @ColumnInfo(name = "strength_time") val strengthTime: String,
    @ColumnInfo(name = "core_activity") val coreActivity: String,
    @ColumnInfo(name = "core_time") val coreTime: String,
    @ColumnInfo(name = "flex_activity") val flexActivity: String,
    @ColumnInfo(name = "flex_time") val flexTime: String,
    @ColumnInfo(name = "cooldown_activity") val cooldownActivity: String,
    @ColumnInfo(name = "cooldown_time") val cooldownTime: String,
    @ColumnInfo(name = "streak") val streak: String,
    @ColumnInfo(name = "workout_date") val workoutDate: String,
    @ColumnInfo(name = "username") val userName: String,
)