package com.example.android.nekitkach;

public class Food {
    private int calories;
    private String name;
    private int image;
    private boolean checkFood;

    public Food(String name, int calories, int image, boolean checkFood){
        this.name = name;
        this.calories = calories;
        this.image = image;
        this.checkFood = checkFood;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
