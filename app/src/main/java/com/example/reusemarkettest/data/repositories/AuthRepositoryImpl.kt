package com.example.reusemarkettest.data.repositories

import com.example.reusemarkettest.data.IDataSource
import com.example.reusemarkettest.data.sources.local.LocalDataSource
import com.example.reusemarkettest.data.sources.remote.RemoteDataSource
import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IDataSource {
    override suspend fun signUp(email: String, password: String)
    = remoteDataSource.signUp(email, password)

    override suspend fun signUpWithGoogle(account: SignInCredential)
    = remoteDataSource.signUpWithGoogle(account)


    override suspend fun login(email: String, password: String) =
        remoteDataSource.login(email, password)

    override fun updateUserInfo(user: FirebaseUser) {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser()
     = remoteDataSource.getCurrentUser()


    override fun logout() {

    }

    override fun signOut() {
        remoteDataSource.signOut()
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