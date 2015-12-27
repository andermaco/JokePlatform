package com.udacity.gradle.jokeplatformapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import gradle.udacity.com.jokeplatformviewlib.JokeActivity;


public class MainActivity extends ActionBarActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        new EndpointsAsyncTask(new EndPointHandler()).execute();
        spinner.setVisibility(View.VISIBLE);
    }

    private class EndPointHandler implements EndpointsAsyncTask.OnEndpointsAsyncTaskListener {

        @Override
        public void onEndPointAction(String result) {
            Intent intent = new Intent (MainActivity.this, InterstitialActivity.class);
            intent.putExtra(JokeActivity.JOKE_STRING, result);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner.setVisibility(View.GONE);
    }
}
