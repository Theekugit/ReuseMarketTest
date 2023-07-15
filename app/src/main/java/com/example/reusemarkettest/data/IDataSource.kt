package com.example.reusemarkettest.data


import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser


interface IDataSource {

    suspend fun signUp(email: String, password: String) : Task<AuthResult>

    suspend fun signUpWithGoogle(account: SignInCredential): Task<AuthResult>
    suspend fun login(email: String, password: String) : Task<AuthResult>

    fun updateUserInfo(user: FirebaseUser)

    fun getCurrentUser() : FirebaseUser?

    fun logout()
    fun signOut()

}