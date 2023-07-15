package com.example.reusemarkettest.ui.home.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.reusemarkettest.common.viewBinding
import com.example.reusemarkettest.databinding.FragmentListBinding
import com.example.reusemarkettest.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment() {
    private val binding by viewBinding(FragmentListBinding::inflate)
    private val viewModel: ListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signOut.setOnClickListener {
            viewModel.signOut()
            LoginActivity.startActivity(requireContext())
            requireActivity().finish()
        }
    }

}