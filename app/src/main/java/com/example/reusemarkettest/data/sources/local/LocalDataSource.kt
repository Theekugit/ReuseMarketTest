package com.example.reusemarkettest.data.sources.local

import android.content.SharedPreferences
import com.example.reusemarkettest.data.IDataSource
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.firestore.auth.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val sharedPreferences: SharedPreferences)
    : IDataSource{
    override suspend fun signUp(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signUpWithGoogle(account: GoogleSignInAccount) {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun updateUserInfo(user: User) {

    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}