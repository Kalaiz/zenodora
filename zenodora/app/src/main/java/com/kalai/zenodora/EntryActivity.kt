package com.kalai.zenodora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat.*
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.kalai.zenodora.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        // Hide the status bar.

        hideSystemUI(rootView)
    }


    /*https://stackoverflow.com/a/64828067/11200630*/
    private fun hideSystemUI(container:View) {

        WindowInsetsControllerCompat(window, container).let { controller ->
            controller.hide( WindowInsetsCompat.Type.navigationBars() or WindowInsetsCompat.Type.statusBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    setDecorFitsSystemWindows(window, false)
    }
}