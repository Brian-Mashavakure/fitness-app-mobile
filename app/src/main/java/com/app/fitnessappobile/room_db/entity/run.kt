package com.app.fitnessappobile.room_db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "runs")
data class Run(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "set_distance") val setDistance: String,
    @ColumnInfo(name = "start_time") val startTime: String,
    @ColumnInfo(name = "end_time") val endTime: String,
    @ColumnInfo(name = "covered_distance") val coveredDistance: String,
    @ColumnInfo(name = "time_taken") val timeTaken: String,
    @ColumnInfo(name = "run_date") val runDate: String,
    @ColumnInfo(name = "username") val userName: String,
)