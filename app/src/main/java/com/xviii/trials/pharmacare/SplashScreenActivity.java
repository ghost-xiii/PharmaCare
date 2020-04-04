package com.xviii.trials.pharmacare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    // Set delay time to 2000ms
    private static int SPLASH_SCREEN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 // Intent to switch to the next Activity
                startActivity(new Intent(SplashScreenActivity.this, SignUpActivity.class));
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
