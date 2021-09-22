package com.example.starbuzz;

public class Food {
    private String name;
    private String description;
    private int imageResourceId;
    //drinks is an array of Drinks
    public static final Food[] foods = {
            new Food("Nachos and Salsa", "Spicy and Tangy", R.drawable.nas),
            new Food("Cheese Garlic Bread", "Chrispy and Cheesy", R.drawable.gb),
            new Food("French Fries", "With tomata sauce and mayo", R.drawable.ff)
    };
    //Each Drink has a name, description, and an image resource
    private Food(String name, String description, int
            imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String toString() {
        return this.name;
    }
}
