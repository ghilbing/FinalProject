package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.MyAsyncTask;
import com.udacity.gradle.builditbigger.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import lilee.hd.jokedisplay.DisplayActivity;


public class MainActivityFragment extends Fragment {
    @BindView(R.id.progressbar)
    ProgressBar progressBar = null;
    @BindView(R.id.joke_button)
    Button joke_button;
    public String loadedJoke = null;

    public boolean testFlag = false;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,root);

        joke_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getNewJoke();
            }
        });

        progressBar.setVisibility(View.GONE);

        return root;
    }

    public void getNewJoke(){
        new MyAsyncTask().execute();
    }

    public void launchDisplayActivity(){
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra(context.getString(R.string.envelope), loadedJoke);
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }

    }
}
