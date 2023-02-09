package com.bbinformatique.menace.ui.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

import com.bbinformatique.menace.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class GameActivity extends AppCompatActivity {

    private Integer counter = 5;
    private Chronometer myChronometer;
    private TextView timeElapsed;
    private Location currentLocation;
    private LocationManager locationManager = null;
    private String fournisseur;

    /**
     * Called when GameActivity is first created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //TODO : Tests sur Localisation :
        initialiserLocalisation();
        currentLocation = new Location("current");

        //Tests sur décompte du temps, puis affichage d'un texte
        myChronometer = (Chronometer) findViewById(R.id.chronometer);
        timeElapsed = (TextView) findViewById(R.id.tv_timeElapsed);
        myChronometer.setText(counter + "");


        /**
         * Listener on chronometer
         */
        myChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                onChronometerTickHandler();
            }
        });
        myChronometer.start();
    }

    /**
     * Events on chronometer
     */
    private void onChronometerTickHandler() {
        if (this.counter <= 0) {
            myChronometer.stop();
            timeElapsed.setText("Time Elapsed");

            //TODO : Détecter la positions du téléphone :
            //TODO : Si debout et position verticale       = InfoActivity
            //TODO : Si debout et position horizontale     = ShootActivity
            //TODO : Si debout et position inversé         = ReloadActivity
            //TODO : Si couché et position verticale       = ScanActivity
            //TODO : Si couché et positions horizontale    = MapActivity
        }
        myChronometer.setText(counter + "");
        counter--;
    }

    /**
     * Called when Localisation is first created
     */
    private void initialiserLocalisation() {
        if (locationManager == null) {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            // précision  : (ACCURACY_FINE pour une haute précision ou ACCURACY_COARSE pour une moins bonne précision)
            criteria.setAccuracy(Criteria.ACCURACY_FINE);

            // altitude
            criteria.setAltitudeRequired(true);

            // direction
            criteria.setBearingRequired(true);

            // vitesse
            criteria.setSpeedRequired(true);

            // consommation d'énergie demandée
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(Criteria.POWER_HIGH);

            fournisseur = locationManager.getBestProvider(criteria, true);
            Log.d("GPS", "fournisseur : " + fournisseur);
        }

        if (fournisseur != null) {
            // dernière position connue
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            Location localisation = locationManager.getLastKnownLocation(fournisseur);
            Log.d("GPS", "localisation : " + localisation.toString());
            String coordonnees = String.format("Latitude : %f - Longitude : %f\n", localisation.getLatitude(), localisation.getLongitude());
            Log.d("GPS", "coordonnees : " + coordonnees);
            String autres = String.format("Vitesse : %f - Altitude : %f - Cap : %f\n", localisation.getSpeed(), localisation.getAltitude(), localisation.getBearing());
            Log.d("GPS", autres);
            String timestamp = String.format("Timestamp : %d\n", localisation.getTime());
            Log.d("GPS", "timestamp : " + timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date(localisation.getTime());
            Log.d("GPS", sdf.format(date));
        }
        else {
            Log.d("GPS", "Problème avec la localisation : pas de fournisseur GPS");
        }
    }
    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("GPS", "onStart");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("GPS", "onResume");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("GPS", "onPause");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("GPS", "onStop");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("GPS", "onDestroy");
    }

    /**
     * Called when the activity is restarted.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("GPS", "onRestart");
    }

    /**
     * Called when the activity is going into the background.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("GPS", "onSaveInstanceState");
    }

    /**
     * Called after onStart() when the activity is being re-initialized from a previously saved state.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("GPS", "onRestoreInstanceState");
    }
}
