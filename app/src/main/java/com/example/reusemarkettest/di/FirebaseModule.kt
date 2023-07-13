package com.example.reusemarkettest.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

   /* @Provides
    @Singleton
    fun provideFirebaseInstances(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }*/

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
       return FirebaseAuth.getInstance()
    }




}