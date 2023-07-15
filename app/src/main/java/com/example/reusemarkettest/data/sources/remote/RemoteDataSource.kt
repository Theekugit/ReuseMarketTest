package com.example.reusemarkettest.data.sources.remote

import com.example.reusemarkettest.data.IDataSource
import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val fireStore: FirebaseFirestore
) :
    IDataSource {
    override suspend fun signUp(
        email: String,
        password: String,
    ): Task<AuthResult> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpWithGoogle(account: SignInCredential): Task<AuthResult> {
        val credential = GoogleAuthProvider.getCredential(account.googleIdToken, null)
        return firebaseAuth.signInWithCredential(credential)
    }

    override suspend fun login(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }


    override fun updateUserInfo(user: FirebaseUser) {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser() = firebaseAuth.currentUser

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        firebaseAuth.signOut()
//        Firebase.auth.signOut()
    }
}