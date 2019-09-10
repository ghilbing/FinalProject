package com.udacity.gradle.builditbigger.paid;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.udacity.gradle.builditbigger.MyAsyncTask;
import com.udacity.gradle.builditbigger.R;
import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivityFragment extends Fragment {
    @BindView(R.id.progressbar)
    ProgressBar progressBar = null;
    @BindView(R.id.joke_button)
    Button joke_button;

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
        new MyAsyncTask().execute(getContext());
    }


}
