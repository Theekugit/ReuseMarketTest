package com.example.reusemarkettest.common

import android.view.LayoutInflater
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.reusemarkettest.MyApplication

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

inline fun <T : ViewBinding> Fragment.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }


fun String.doSomething() : String{
    return this.plus(" world")
}

fun View.show() {
    visibility = View.VISIBLE
}
fun View.gone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}