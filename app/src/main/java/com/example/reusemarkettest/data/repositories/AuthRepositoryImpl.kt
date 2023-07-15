package com.example.reusemarkettest.data.repositories

import com.example.reusemarkettest.data.IDataSource
import com.example.reusemarkettest.data.sources.local.LocalDataSource
import com.example.reusemarkettest.data.sources.remote.RemoteDataSource
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IDataSource {
    override suspend fun signUp(email: String, password: String)
    = remoteDataSource.signUp(email, password)

    override suspend fun signUpWithGoogle(account: GoogleSignInAccount)
    = remoteDataSource.signUpWithGoogle(account)


    override suspend fun login(email: String, password: String) =
        remoteDataSource.login(email, password)

    override fun updateUserInfo(user: User)
    = localDataSource.updateUserInfo(user)


    override fun logout() {

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