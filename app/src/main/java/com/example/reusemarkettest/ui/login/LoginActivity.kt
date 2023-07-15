package com.example.reusemarkettest.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentSender.SendIntentException
import android.os.Bundle
import android.util.Log
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.reusemarkettest.R
import com.example.reusemarkettest.common.Result
import com.example.reusemarkettest.common.Result.Loading
import com.example.reusemarkettest.common.gone
import com.example.reusemarkettest.common.show
import com.example.reusemarkettest.common.viewBinding
import com.example.reusemarkettest.databinding.ActivityLoginBinding
import com.example.reusemarkettest.ui.home.HomeActivity
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }

        const val TAG = "LoginActivity"
    }

    private val authViewModel: AuthViewModel by viewModels()
    private val binding by viewBinding(ActivityLoginBinding::inflate)
    private var oneTapClient: SignInClient? = null
    private var signInRequest: BeginSignInRequest? = null


    private val myActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                try {
                    val credential = oneTapClient!!.getSignInCredentialFromIntent(result.data)
                    authViewModel.signInWithGoogle(credential)
                } catch (e: ApiException) {
                    // ...
                }
            } else {
                // Result was not successful, handle the failure
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initGoogleSignIn()
        checkAlreadyLoginUser()

        initUI()
        initObservers()
    }

    private fun initGoogleSignIn() {
        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(getString(R.string.default_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            // Automatically sign in when exactly one credential is retrieved.
            .setAutoSelectEnabled(true)
            .build()

    }

    private fun checkAlreadyLoginUser() {
        if (authViewModel.isAlreadyLoggedIn()) {
            HomeActivity.startActivity(this@LoginActivity)
        }
    }

    private fun initObservers() = with(binding) {
        authViewModel.signInResponse.observe(this@LoginActivity) {
            when (it) {
                is Loading -> {
                    progressBar.show()
                }

                is Result.Success<*> -> {
                    progressBar.gone()
                    HomeActivity.startActivity(this@LoginActivity)
                }

                is Result.Failure -> {
                    progressBar.gone()
                    Snackbar.make(binding.root, it.error, Snackbar.LENGTH_LONG).show()
                }

                else -> {
                    progressBar.gone()
                }
            }
        }
    }

    private fun initUI() = with(binding) {
        btnLogin.setOnClickListener {
            val email = etEmail.text
            val password = etPassword.text

            if (email.isNullOrEmpty()) {
                etEmail.error = "Please enter email"
                return@setOnClickListener
            }

            if (password.isNullOrEmpty()) {
                etPassword.error = "Enter password"
                return@setOnClickListener
            }

            authViewModel.login(email.toString(), password.toString())
        }

        btnSignupGoogle.setOnClickListener {
            oneTapClient!!.beginSignIn(signInRequest!!)
                .addOnSuccessListener(
                    this@LoginActivity
                ) { result ->
                    try {
                        val intent = IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                        myActivityResultLauncher.launch(intent)
                    } catch (e: SendIntentException) {
                        Log.e(TAG, "Couldn't start One Tap UI: " + e.localizedMessage)
                    }
                }
                .addOnFailureListener(this@LoginActivity) { e -> // No saved credentials found. Launch the One Tap sign-up flow, or
                    // do nothing and continue presenting the signed-out UI.
                    Log.d(TAG, e.localizedMessage)
                }
        }
    }
}