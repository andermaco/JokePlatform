package com.udacity.gradle.jokeplatformapp;

import android.test.AndroidTestCase;

import com.udacity.gradle.jokeplatformapp.EndpointsAsyncTask.OnEndpointsAsyncTaskListener;

public class ApplicationTest extends AndroidTestCase {

    public void testEndPointAsyncTask () {
        new EndpointsAsyncTask(new OnEndpointsAsyncTaskListener() {
            @Override
            public void onEndPointAction(String result) {
                assertTrue(result != null && result.length() > 0);
            }
        }).execute();
    }
}