package com.app.fitnessappobile.di.database

import android.content.Context
import androidx.room.Room
import com.app.fitnessappobile.room_db.FitXDatabase
import com.app.fitnessappobile.room_db.dao.GoalDao
import com.app.fitnessappobile.room_db.dao.RunDao
import com.app.fitnessappobile.room_db.dao.WorkoutDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): FitXDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            FitXDatabase::class.java,
            "fitness-database"
        ).build()
    }


    @Provides
    @Singleton
    fun providesWorkoutDao(db: FitXDatabase): WorkoutDao {
        return db.workoutDao()
    }

    @Provides
    @Singleton
    fun providesRunDao(db: FitXDatabase): RunDao {
        return db.runDao()
    }

    @Provides
    @Singleton
    fun providesGoalDao(db: FitXDatabase): GoalDao{
        return db.goalDao()
    }
}