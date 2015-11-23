package com.benjaminshockley.laughalot;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.benjaminshockley.jokeactivitylibrary.MainLibraryActivity;
import com.example.benjaminshockley.myapplication.backend.jokeApi.JokeApi;
import com.example.benjaminshockley.myapplication.backend.jokeApi.model.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by benjaminshockley on 11/19/15.
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, Joke> {

    private EndpointsAsyncTaskListener mListener = null;
    private Exception mError = null;

    private ProgressDialog progressDialog;

    private static JokeApi myJokeApiService = null;

    private Context context;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    public interface EndpointsAsyncTaskListener {
        void onComplete(Joke mJoke, Exception e);
    }

    public EndpointsAsyncTask setListener(EndpointsAsyncTaskListener listener) {
        this.mListener = listener;
        return this;
    }

    protected void onPreExecute(){
        super.onPreExecute();
        if (context !=null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Retrieving a joke...");
            progressDialog.show();
        }
    }

    @Override
    protected Joke doInBackground(Void... params) {
        if(myJokeApiService == null) {
            JokeApi.Builder jokeBuilder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://laughs-a-lot.appspot.com/_ah/api/");
            myJokeApiService = jokeBuilder.build();
        }

        try {
            return myJokeApiService.getJoke().execute();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Joke mJoke) {
        if (context != null) {
            progressDialog.dismiss();
        }
        if (this.mListener != null) {
            this.mListener.onComplete(mJoke, mError);
        }
        if (mJoke != null && context != null) {
            Intent myIntent = new Intent(context, MainLibraryActivity.class);
            myIntent.putExtra("JokeTitle", mJoke.getTitle());
            myIntent.putExtra("JokeContent", mJoke.getContent());
            context.startActivity(myIntent);
        }
    }

}