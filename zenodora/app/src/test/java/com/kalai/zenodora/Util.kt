package com.kalai.zenodora

import android.view.View
import android.widget.TextView
import org.hamcrest.Description
import org.hamcrest.Matcher
import java.util.regex.Pattern
import androidx.test.espresso.matcher.BoundedMatcher

/*Reference: https://stackoverflow.com/a/56329669/11200630*/
class RegexMatcher(private val regex: String) : BoundedMatcher<View, TextView>(TextView::class.java) {
    private val pattern = Pattern.compile(regex)

    override fun describeTo(description: Description?) {
        description?.appendText("Checking the matcher on received view: with pattern=$regex")
    }

    override fun matchesSafely(item: TextView?) =
        item?.text?.let {
            pattern.matcher(it).matches()
        } ?: false
}



 fun withPattern(regex: String): Matcher<in View> = RegexMatcher(regex)
