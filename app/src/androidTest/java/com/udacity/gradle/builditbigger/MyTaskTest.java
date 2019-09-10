package com.udacity.gradle.builditbigger;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class MyTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testAsyncTask() throws InterruptedException, ExecutionException {

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(activityTestRule.getActivity());

        String joke = myAsyncTask.get();

        assertNotNull(joke);
    }



}
