package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.media.tv.TvContract;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import lilee.hd.jokedisplay.DisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

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
        new MyAsyncTask().execute(this);
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
