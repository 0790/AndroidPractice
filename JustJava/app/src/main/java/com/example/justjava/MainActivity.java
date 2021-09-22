package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity);
        displayMessage(createOrderSummary(price));
    }
    private String createOrderSummary(int price){
        String priceMessage = "Name: Deepti Kumar" ;
        priceMessage += "\nQuantity: " + quantity ;
        priceMessage+= "\nTotal: $" + price + "\nThank you!";
        displayMessage(priceMessage);
        return priceMessage;
    }

    private int calculatePrice(int quantity){
        return quantity*5;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method is called when the plus-button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the minus-button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



}