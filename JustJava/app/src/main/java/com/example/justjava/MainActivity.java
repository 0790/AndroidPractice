package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.whippedcream) ;
        boolean hasWhippedCream = whippedCreamCheck.isChecked();
        CheckBox chocolateCheck = (CheckBox) findViewById(R.id.chocolate) ;
        boolean hasChocolate =chocolateCheck.isChecked();

        int price = calculatePrice(quantity,hasWhippedCream,hasChocolate);

        EditText nameView = (EditText)findViewById(R.id.name) ;
        String name = nameView.getText().toString() ;
        displayMessage(createOrderSummary(price,hasWhippedCream,hasChocolate, name));
    }
    private String createOrderSummary(int price, boolean hasWhippedCream , boolean hasChocolate,String name){
        String priceMessage = "Name: " + name ;

        priceMessage+= "\nAdded whipped cream?: " + hasWhippedCream;
        priceMessage+= "\nAdded chocolate?: " + hasChocolate;
        priceMessage += ("\nQuantity: " + quantity);
        priceMessage+= "\nTotal: $" + price + "\nThank you!";
        displayMessage(priceMessage);
        return priceMessage;
    }

    private int calculatePrice(int quantity, boolean whippedCream, boolean chocolate){
        int basePrice = 5;

        if(whippedCream) basePrice += 1;
        else if(chocolate)  basePrice += 2 ;
        return basePrice*quantity;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {

       Intent intent = new Intent(Intent.ACTION_SEND  ) ;

       intent.setData(Uri.parse("mailto:")) ;
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your Coffee order from JustJava!");
       intent.putExtra(Intent.EXTRA_TEXT,message) ;
       Intent chooser= Intent.createChooser(intent,"Send mail") ;

       startActivity(chooser);


    }

    /**
     * This method is called when the plus-button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        if(quantity > 100)quantity = 100 ;
        display(quantity);

    }

    /**
     * This method is called when the minus-button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        if(quantity < 0)quantity = 0 ;
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