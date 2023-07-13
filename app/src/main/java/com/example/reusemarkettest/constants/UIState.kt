package com.example.reusemarkettest.constants


import java.lang.Exception

sealed class UIState<out R> {

    //loading, success, failure
    object Loading: UIState<Nothing>()
    data class Success<out R>(val result: R) : UIState<R>()
    data class Failure(val exception: Exception): UIState<Nothing>()

}