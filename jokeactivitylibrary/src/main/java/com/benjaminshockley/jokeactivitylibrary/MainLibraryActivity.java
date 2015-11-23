package com.benjaminshockley.jokeactivitylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);

        // Get the message from the intent
        Intent intent = getIntent();
        String mJokeTitle = intent.getStringExtra("JokeTitle");
        String mJokeContent = intent.getStringExtra("JokeContent");

        TextView jokeTitle = (TextView) findViewById(R.id.joke_header);
        jokeTitle.setText(mJokeTitle);

        TextView jokeContent = (TextView) findViewById(R.id.joke_content);
        jokeContent.setText(mJokeContent);
    }

}
