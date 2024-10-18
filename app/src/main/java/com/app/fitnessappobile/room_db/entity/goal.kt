package com.app.fitnessappobile.room_db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goals")
data class Goal(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "goal_desc") val goalDescription: String,
    @ColumnInfo(name = "date_set") val dateSet: String,
    @ColumnInfo(name = "finish_date") val finishDate: String,
    @ColumnInfo(name = "username") val userName: String,
    @ColumnInfo(name = "workout_nickname") val workoutNickname: String,
)