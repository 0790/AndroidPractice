package com.example.starbuzz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {
    public static final String EXTRA_FOODID = "foodID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = findViewById(R.id.mtoolbar) ;
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        int foodId =
                (Integer)getIntent().getExtras().get(EXTRA_FOODID);
        Food food= Food.foods[foodId];
//Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(food.getName());
//Populate the drink description
        TextView description =
                (TextView)findViewById(R.id.description);
        description.setText(food.getDescription());
//Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(food.getImageResourceId());
        photo.setContentDescription(food.getName());
    }
}