package com.kalai.zenodora


import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.format.DateTimeFormatter


@RunWith(RobolectricTestRunner::class)
class MainActivityTest{
  private lateinit var scenario :ActivityScenario<MainActivity>

  @Before
  @Throws(Exception::class)
  fun setUp() {
    scenario = ActivityScenario.launch(MainActivity::class.java)
    scenario.moveToState(Lifecycle.State.RESUMED)
  }


  @Test
  fun `Shows time`(){
    scenario.onActivity {
      it?.let { activity->
        val textView = activity.findViewById<TextView>(R.id.time_left_text_view)
        val pattern = DateTimeFormatter.ofPattern("mm:ss")
        pattern?.parse(textView.text)
      }
    }
  }


  @Test
  fun `Shows sound toggle button`(){
    scenario.onActivity {
      it?.let { activity->
        val soundButton = activity.findViewById<ToggleButton>(R.id.sound_toggle_button)
        assert(soundButton.isClickable && soundButton.isVisible)
      }
    }
  }


  @Test
  fun `Shows settings button`(){
    scenario.onActivity {
      it?.let { activity->
        val settingsButton = activity.findViewById<ImageView>(R.id.settings_image_view)
        assert(settingsButton.isClickable && settingsButton.isVisible)
      }
    }
  }







}