package com.example.starbuzz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
        Toolbar toolbar = findViewById(R.id.mtoolbar) ;
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Food.foods);

        ListView listDrinks = (ListView)
                findViewById(R.id.list_foods);
        listDrinks.setAdapter(listAdapter);
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?>
                                                    listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {
//Pass the drink the user clicks on to DrinkActivity
                        Intent intent = new
                                Intent(FoodCategoryActivity.this,FoodActivity.class);
                        intent.putExtra(FoodActivity.EXTRA_FOODID, (int)
                                id);
                        startActivity(intent);
                    }
                };
//Assign the listener to the list view
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}