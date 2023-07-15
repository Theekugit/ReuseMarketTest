package com.example.reusemarkettest.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.reusemarkettest.common.Result
import com.example.reusemarkettest.data.repositories.AuthRepositoryImpl
import com.google.android.gms.auth.api.identity.SignInCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl, private val application: Application
) : AndroidViewModel(application) {


    val signInResponse = MutableLiveData<Result>()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            signInResponse.postValue(Result.Loading)
            repository.login(email, password).addOnSuccessListener {
                signInResponse.postValue(Result.Success(it.user))
            }.addOnFailureListener {
                signInResponse.postValue(Result.Failure("Login failed"))
            }
        }

    }

    fun signInWithGoogle(account: SignInCredential) {
        viewModelScope.launch {
            repository.signUpWithGoogle(account).addOnSuccessListener {
                signInResponse.postValue(Result.Success(it.user))
            }.addOnFailureListener {
                signInResponse.postValue(Result.Failure("Login failed"))
            }
        }

    }

    fun isAlreadyLoggedIn(): Boolean {
        return repository.getCurrentUser() != null
    }
}