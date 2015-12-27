package gradle.udacity.com.jokeplatformviewlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by andermaco on 17/12/15.
 */
public class JokeActivityFragment extends Fragment {

    private ProgressBar spinner;
    public JokeActivityFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.JOKE_STRING);
        View rootView = inflater.inflate(R.layout.jokeactivityfragment, container, false);
        if (joke != null && joke.length() != 0) {
            TextView textView = (TextView) rootView.findViewById(R.id.joke_textview);
            textView.setText(joke);
        }
        return  rootView;
    }
}
