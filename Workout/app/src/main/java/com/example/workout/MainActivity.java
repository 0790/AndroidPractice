package com.example.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkoutListFragment frag = (WorkoutListFragment) getSupportFragmentManager().findFragmentById(R.id.list_frag);
    }

    public void onClickDetails(View view) {
       Intent intent = new Intent(this, DetailActivity.class) ;
       startActivity(intent);

    }

    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, DetailActivity.class) ;
        intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (long)id);
        startActivity(intent);
    }
}