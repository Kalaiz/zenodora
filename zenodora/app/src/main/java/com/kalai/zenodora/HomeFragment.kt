package com.kalai.zenodora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.kalai.zenodora.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home){
    private  lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


      binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.settingsImageView.setOnClickListener {
                view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        return  binding.root

    }


}