package com.example.reusemarkettest.repository


import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.auth.Token
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import javax.inject.Inject


interface AuthRepository {
    /*val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): UIState<FirebaseUser>
    suspend fun signUp(name: String, email: String, password: String): UIState<FirebaseUser>
    fun logout()*/

    /**
     * New
     */

    suspend fun signUp(email: String, password: String)

    suspend fun signUpWithGoogle(account: GoogleSignInAccount)
    suspend fun login(user: User)

    fun updateUserInfo(user: User)


    fun logout()

}