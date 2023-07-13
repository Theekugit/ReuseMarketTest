package com.example.reusemarkettest.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.reusemarkettest.R
import com.example.reusemarkettest.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn


import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


const val REQUEST_CODE_SIGN_IN = 0

class LoginFragment : Fragment() {

    lateinit var auth: FirebaseAuth

    lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: AuthViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]

        binding.vm = viewModel
        binding.lifecycleOwner = this

       /* val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()



        val signInClient = GoogleSignIn.getClient(requireContext(),options)
        signInClient.signInIntent.also {
            startActivityForResult(it, REQUEST_CODE_SIGN_IN)


        }*/

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {

            var strEmail = binding.etEmail.text.toString()
            var strPassword = binding.etPassword.text.toString()

            viewModel.signUpInfo(strEmail, strPassword)
            //viewModel.login(strEmail,strPassword)
            navigateToRepositoryFragment()


            Toast.makeText(context, "added", Toast.LENGTH_LONG).show()

        }

        binding.btnSignupGoogle.setOnClickListener {

            //viewModel.signUpwithGoogle
        }



    }



    fun navigateToRepositoryFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_listFragment)
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(data).result
            account?.let {
                viewModel.signUpWithGoogle(it)

            }
        }
    }
*/
   /* private fun googleAuthForFirebase(account: GoogleSignInAccount) {

        val credentials = GoogleAuthProvider.getCredential(account.idToken, null)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                auth.signInWithCredential(credentials).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireActivity(), "Logged In", Toast.LENGTH_LONG).show()
                }


            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireActivity(), e.message, Toast.LENGTH_LONG).show()
                }
            }

        }
    }
*/



}