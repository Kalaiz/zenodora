package com.kalai.zenodora

import android.os.Bundle
import androidx.activity.addCallback
import androidx.navigation.findNavController
import androidx.preference.PreferenceFragmentCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            view?.findNavController()?.navigate(R.id.action_settingsFragment_to_homeFragment)
        }

    }


}