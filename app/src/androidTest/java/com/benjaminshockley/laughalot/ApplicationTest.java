package com.benjaminshockley.laughalot;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import com.example.benjaminshockley.myapplication.backend.jokeApi.model.Joke;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    String mJokeTitle = null;
    String mJokeContent = null;
    Exception mError = null;
    CountDownLatch signal = null;

    Context mContext = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeGetTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask(mContext);
        task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(Joke mJoke, Exception e) {
                mJokeTitle = mJoke.getTitle();
                mJokeContent = mJoke.getContent();
                mError = e;
                signal.countDown();
            }
        }).execute();
        signal.await();

        assertNull(mError);
        assertFalse(mJokeTitle.isEmpty());
        assertFalse(mJokeContent.isEmpty());

    }
}