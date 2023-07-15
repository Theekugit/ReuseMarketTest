package com.example.reusemarkettest.data.sources.remote

import com.example.reusemarkettest.data.IDataSource
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val fireStore: FirebaseFirestore ) :
    IDataSource {
    override suspend fun signUp(
        email: String,
        password: String,
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun signUpWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential).await()
    }

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }


    override fun updateUserInfo(user: User) {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}