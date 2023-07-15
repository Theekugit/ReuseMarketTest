package com.example.reusemarkettest.data.sources.local

import android.content.SharedPreferences
import com.example.reusemarkettest.data.IDataSource
import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val sharedPreferences: SharedPreferences)
    : IDataSource{
    override suspend fun signUp(email: String, password: String): Task<AuthResult> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpWithGoogle(account: SignInCredential): Task<AuthResult> {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): Task<AuthResult> {
        TODO("Not yet implemented")
    }

    override fun updateUserInfo(user: FirebaseUser) {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): FirebaseUser? {
        TODO("Not yet implemented")
    }


    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        TODO("Not yet implemented")
    }
}