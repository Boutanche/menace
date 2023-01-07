package com.bbinformatique.menace.ui.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

import com.bbinformatique.menace.R;

import java.util.Timer;

public class GameActivity extends AppCompatActivity {

    private Integer counter = 5;
    private Chronometer myChronometer;
    private TextView timeElapsed;

    /**
     * Called when GameActivity is first created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myChronometer = (Chronometer) findViewById(R.id.chronometer);
        timeElapsed = (TextView) findViewById(R.id.tv_timeElapsed);

        myChronometer.setText(counter + "");
        myChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                onChronometerTickHandler();
            }
        });
        myChronometer.start();
    }
    private void onChronometerTickHandler(){
        if (this.counter <= 0){
            myChronometer.stop();
            timeElapsed.setText("Time Elapsed");

            //TODO : Détecter la positions du téléphone :
                //TODO : Si debout et position verticale       = InfoActivity
                //TODO : Si debout et position horizontale     = ShootActivity
                //TODO : Si debout et position inversé         = ReloadActivity
                //TODO : Si couché et position verticale       = ScanActivity
                //TODO : Si couché et positions horizontale    = MapActivity
        }
        myChronometer.setText(counter +"");
        counter--;
    }
}
