package com.example.reusemarkettest.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reusemarkettest.data.IDataSource
import com.example.reusemarkettest.data.repositories.AuthRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {


    /**
     * New
     */
    private val _signUp = MutableLiveData<String>(null)
    val signUp: LiveData<String>
        get() = _signUp

   /* private val _signUpWithGoogle = MutableLiveData<String>(null)
    val signUpwithGoogle: LiveData<String>
        get() = _signUp*/



    fun signUpInfo(email: String, password: String){
        viewModelScope.launch {
            val result = repository.signUp(email,password)
            //_signUp.value = result.toString()

        }

    }

    /*fun signUpWithGoogle(account: GoogleSignInAccount){
        viewModelScope.launch {
            val signUpWithGoogle = repository.signUpWithGoogle(account)
            _signUpWithGoogle.value = signUpWithGoogle.toString()
        }
    }
*/






/*

    private val _loginInfo = MutableStateFlow<UIState<FirebaseUser>?>(null)
    val loginInfo: StateFlow<UIState<FirebaseUser>?> = _loginInfo

    private val _signInfo = MutableStateFlow<UIState<FirebaseUser>?>(null)
    val signInfo: StateFlow<UIState<FirebaseUser>?> = _signInfo


    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _loginInfo.value = UIState.Success(repository.currentUser!!)
        }
    }
    

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginInfo.value = UIState.Loading
        val result = repository.login(email, password)
        _loginInfo.value = result

    }

    fun signUp(name: String, emial: String, password: String) = viewModelScope.launch {
        _signInfo.value = UIState.Loading
        val result = repository.signUp(name, emial, password)
        _signInfo.value = result

    }

    fun logout() {
        repository.logout()
        _loginInfo.value = null
        _signInfo.value = null
    }
*/


}