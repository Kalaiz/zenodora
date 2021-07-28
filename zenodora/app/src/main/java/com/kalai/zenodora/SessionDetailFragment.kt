package com.kalai.zenodora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.transition.TransitionInflater
import com.kalai.zenodora.adapter.ScheduleAdapter
import com.kalai.zenodora.databinding.FragmentSessionDetailBinding
import com.kalai.zenodora.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SessionDetailFragment : Fragment(R.layout.fragment_session_detail) {
    private val viewModel: HomeViewModel by viewModels()
private lateinit var binding:FragmentSessionDetailBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = ScheduleAdapter( fun(number:Int){
            Timber.d(" Schedule touched index: $number")})
        binding = FragmentSessionDetailBinding.inflate(inflater,container,false)
        binding.scheduleRecyclerView.adapter = adapter

        viewModel.allSession.observe(viewLifecycleOwner, {
            it.let{
                adapter.data = it
                Timber.d("Changed %s", it)
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.no_transition)


    }
}