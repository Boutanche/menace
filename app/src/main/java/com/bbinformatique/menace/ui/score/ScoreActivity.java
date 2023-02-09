package com.bbinformatique.menace.ui.score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bbinformatique.menace.R;

/**
 * ScoreActivity : Affiche le score du joueur
 */
public class ScoreActivity extends AppCompatActivity {

     // Déclaration des variables
    private final String TAG = "DEBUG";

    /**
     * Called when ScoreActivity is first created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Log.v("TAG", "Ouverture de l'activité Score");
    }

    /**
     * Called when ScoreActivity is destroyed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("TAG", "Fermeture de l'activité Score");
    }
}