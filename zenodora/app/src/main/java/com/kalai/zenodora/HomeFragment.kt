package com.kalai.zenodora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.kalai.zenodora.adapter.ScheduleAdapter
import com.kalai.zenodora.databinding.FragmentHomeBinding
import com.kalai.zenodora.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

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


        val adapter = ScheduleAdapter( fun(number:Int){Timber.d(" Schedule touched index: $number")
            val extras = FragmentNavigatorExtras(
                binding.scheduleRecyclerView to "schedule_recycler_view_detail"
            )

            this.view?.findNavController()?.navigate(R.id.action_homeFragment_to_sessionDetailFragment,
                null,
                null,
                extras)
        })
        binding.scheduleRecyclerView.adapter = adapter

        viewModel.allSession.observe(viewLifecycleOwner, {
                it.let{
                    adapter.data = it
                    Timber.d("Changed %s", it)
                }
        })
        Timber.d("Test")
        viewModel.insert()


        return  binding.root
    }

}