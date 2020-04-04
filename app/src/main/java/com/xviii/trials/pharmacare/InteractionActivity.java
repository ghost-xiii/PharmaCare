package com.xviii.trials.pharmacare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InteractionActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        // Loading default fragment
        loadFragment(new CalculateFragment());

        // Getting the bottom navigation and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    // Method to create an intent to start InteractionActivity
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, InteractionActivity.class);
        return i;
    }

    // A method to switch fragments
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {

            case R.id.calculate:
                fragment = new CalculateFragment();
                break;

            case R.id.add_new:
                fragment = new AddNewFragment();
                break;

            case R.id.statistics:
                fragment = new StatisticsFragment();
                break;

            case R.id.settings:
                fragment = new SettingsFragment();
                break;
        }

        return loadFragment(fragment);
    }


}
