package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import lilee.hd.jokedisplay.DisplayActivity;
import lilee.hd.jokesprovider.JokesProvider;


public class MainActivity extends AppCompatActivity implements AsyncResponseHandler {

    private InterstitialAd mInterstitialAd;

    private static final String TAG = "HAMMER DOWN";
  //  MyAsyncTask myAsyncTask = new MyAsyncTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3597020112887836~4885523265");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically responseHandle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        JokesProvider jokesProvider = new JokesProvider();
//        Toast.makeText(this, jokesProvider.getJoke(), Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(this, DisplayActivity.class);
//        intent.putExtra(getString(R.string.envelope), jokesProvider.getJoke());
//        startActivity(intent);
//        myAsyncTask.responseHandler = this;
//        myAsyncTask.execute();

          //  myAsyncTask.execute(this);
      //  new MyAsyncTask().execute(this);

    }

    @Override
    public void responseHandle(String output) {
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(DisplayActivity.JOKE_EXTRA, output);
        this.startActivity(intent);
    }

}
