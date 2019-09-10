package com.udacity.gradle.builditbigger;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class MyTaskTest {
    @Test
    public void testMyAsyncTask() throws Exception {

        com.udacity.gradle.builditbigger.MainActivityFragment fragment = new com.udacity.gradle.builditbigger.MainActivityFragment();

        fragment.testFlag = true;
        new MyAsyncTask().execute(fragment);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + fragment.loadedJoke, fragment.loadedJoke != null);
    }

}
