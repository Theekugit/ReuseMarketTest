package com.example.reusemarkettest.data


import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.firestore.auth.User


interface IDataSource {
    /*val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): UIState<FirebaseUser>
    suspend fun signUp(name: String, email: String, password: String): UIState<FirebaseUser>
    fun logout()*/

    /**
     * New
     */

    suspend fun signUp(email: String, password: String)

    suspend fun signUpWithGoogle(account: GoogleSignInAccount)
    suspend fun login(email: String, password: String)

    fun updateUserInfo(user: User)


    fun logout()

}