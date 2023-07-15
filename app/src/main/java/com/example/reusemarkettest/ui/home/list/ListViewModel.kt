package com.example.reusemarkettest.ui.home.list

import androidx.lifecycle.ViewModel
import com.example.reusemarkettest.data.repositories.AuthRepositoryImpl
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {
}