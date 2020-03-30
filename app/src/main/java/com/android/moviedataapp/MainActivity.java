package com.android.moviedataapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseUI();
        setupUIListeners();
    }


    private void initialiseUI() {
        button_start = findViewById(R.id.button_start);
    }

    private void setupUIListeners() {
        button_start.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_start) {
            AppNavigator.navigateFromTo(this, MovieListHomePage.class);
        }
    }
}

















