package com.example.reusemarkettest.repository

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    //val database: FirebaseFirestore

) : AuthRepository {

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


    override suspend fun login(user: User) {
        TODO("Not yet implemented")
    }

    override fun updateUserInfo(user: User) {
        TODO("Not yet implemented")
    }


    override fun logout() {
        TODO("Not yet implemented")
    }

    /**
     * old
     */
    /* override val currentUser: FirebaseUser?
         get() = firebaseAuth.currentUser

     override suspend fun login(email: String, password: String): UIState<FirebaseUser> {
        return try {
             val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
             UIState.Success(result.user!!)
         }catch (e: Exception){
             e.printStackTrace()
             UIState.Failure(e)
         }

     }

     override suspend fun signUp(name: String, email: String, password: String): UIState<FirebaseUser> {
         return try {
             val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
             result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())
             UIState.Success(result.user!!)
         }catch (e: Exception){
             e.printStackTrace()
             UIState.Failure(e)
         }
     }

     override fun logout() {
         firebaseAuth.signOut()
     }*/
}