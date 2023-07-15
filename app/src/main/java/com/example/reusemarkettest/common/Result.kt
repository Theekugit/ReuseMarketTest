package com.example.reusemarkettest.common


sealed class Result {

    //loading, success, failure
    object Loading : Result()
    data class Success<out R>(val result: R) : Result()
    data class Failure(val error: String) : Result()

}