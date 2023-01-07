package com.bbinformatique.menace.ui.score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bbinformatique.menace.R;

public class ScoreActivity extends AppCompatActivity {

    private final String TAG = "DEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Log.v("TAG", "Ouverture de l'activité Score");
    }
}