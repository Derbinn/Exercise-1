 package com.Binderpackage;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class CommentFeatureTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Test for posting a valid comment
    @Test
    public void testPostComment() {
        String comment = "This is a test comment";

        // Locate the comment input field and enter a comment
        Espresso.onView(withId(R.id.comment_input_field))
                .perform(ViewActions.typeText(comment), ViewActions.closeSoftKeyboard());

        // Click the post comment button
        Espresso.onView(withId(R.id.post_comment_button))
                .perform(ViewActions.click());

        // Verify the comment is displayed in the comment list
        Espresso.onView(withText(comment))
                .check(matches(ViewMatchers.isDisplayed()));
    }

    // Test for deleting a valid comment
    @Test
    public void testDeleteComment() {
        // Assume we already have a comment posted to delete
        Espresso.onView(withId(R.id.comment_text))
                .check(matches(ViewMatchers.isDisplayed()));
        
        // Perform click on delete button
        Espresso.onView(withId(R.id.delete_button))
                .perform(ViewActions.click());

        // Verify the comment is deleted
        Espresso.onView(withId(R.id.comment_text))
                .check(matches(ViewMatchers.doesNotExist()));
    }

    // Test for reporting a valid comment
    @Test
    public void testReportComment() {
        // Locate comment and report it
        Espresso.onView(withId(R.id.comment_text))
                .check(matches(ViewMatchers.isDisplayed()));
        
        // Perform click on report button
        Espresso.onView(withId(R.id.report_button))
                .perform(ViewActions.click());

        // Verify report confirmation dialog appears
        Espresso.onView(withText("Report this comment?"))
                .check(matches(ViewMatchers.isDisplayed()));

        // Optionally confirm the report
        Espresso.onView(withText("Yes")).perform(ViewActions.click());
    }
}

