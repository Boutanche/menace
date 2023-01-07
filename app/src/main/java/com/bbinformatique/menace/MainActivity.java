package com.bbinformatique.menace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bbinformatique.menace.ui.game.GameActivity;
import com.bbinformatique.menace.ui.login.LoginActivity;
import com.bbinformatique.menace.ui.score.ScoreActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "DEBUG BIBI";

    Button btn_login;
    Button btn_game;
    Button btn_score;
    Button btn_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference on component
        btn_login =(Button) findViewById(R.id.btn_login);
        btn_game = (Button) findViewById(R.id.btn_game);
        btn_score = (Button) findViewById(R.id.btn_score);
        btn_quit = (Button) findViewById(R.id.btn_quit);

        /**
         * btn_login
         */
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivityIntent);
            }
        });

        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "OnClick() de btnQuit called");
                finish();
                System.exit(0);
            }
        });

        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });

        btn_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Btn Score appuyé ");
                Intent scoreActivityIntent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(scoreActivityIntent);
            }
        });
    }
}