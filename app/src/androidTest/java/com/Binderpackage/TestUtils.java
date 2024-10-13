package com.Binderpackage;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

public class TestUtils {

    // Method to wait for screen to load
    public static void waitForScreenToLoad(int viewId, String screenName) {
        Espresso.onView(ViewMatchers.withId(viewId))
                .check(matches(ViewMatchers.isDisplayed()));
        System.out.println("Transitioned to " + screenName);
    }
}
 
