package com.kalai.zenodora


import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4

import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/*TODO: Replace deprecated runner*/
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
  private lateinit var scenario: FragmentScenario<HomeFragment>

  @Before
  @Throws(Exception::class)
  fun setUp() {
    scenario = launchFragmentInContainer()
  }


  /*TODO: use regex*/
  @Test
  fun `Shows time`() {
    scenario.onFragment {
      onView(withId(R.id.time_left_text_view))
        .check(matches(withPattern("30:00")))
      }
    }

  private fun showButton(id: Int) {
    onView(withId((id)))
      .check(matches(allOf(isClickable(), isDisplayed()))
      )
  }

  @Test
  fun `Shows settings button`() {
    showButton(R.id.settings_image_view)
  }


  @Test
  fun `Shows sound toggle button`() {
    showButton(R.id.sound_toggle_button)
  }
}
