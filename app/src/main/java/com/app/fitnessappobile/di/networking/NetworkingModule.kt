package com.app.fitnessappobile.di.networking

import android.content.Context
import android.content.SharedPreferences
import com.app.fitnessappobile.auth.model.AuthService
import com.app.fitnessappobile.goals.model.GoalService
import com.app.fitnessappobile.runs.model.RunsService
import com.app.fitnessappobile.workouts.model.WorkoutService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("Token_Store", Context.MODE_PRIVATE)
    }

    //TODO: Massive one look into timeout issue probably through deploying backend
    @Provides
    @Singleton
    fun providesOkHttpClient(sharedPrefs: SharedPreferences): OkHttpClient {

        val tokenString = sharedPrefs.getString("token", "")
        return OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(sharedPrefs: SharedPreferences): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.169:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(providesOkHttpClient(sharedPrefs))
            .build()
    }

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun providesWorkoutService(retrofit: Retrofit): WorkoutService{
        return retrofit.create(WorkoutService::class.java)
    }

    @Provides
    @Singleton
    fun providesGoalService(retrofit: Retrofit): GoalService {
        return retrofit.create(GoalService::class.java)
    }

    @Provides
    @Singleton
    fun providesRunService(retrofit: Retrofit): RunsService{
        return retrofit.create(RunsService::class.java)
    }
}