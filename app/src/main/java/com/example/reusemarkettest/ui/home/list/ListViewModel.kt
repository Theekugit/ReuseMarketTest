package com.example.reusemarkettest.ui.home.list

import androidx.lifecycle.ViewModel
import com.example.reusemarkettest.data.repositories.AuthRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {
    fun signOut() {
        repository.signOut()
    }
}