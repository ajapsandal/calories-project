package com.example.android.nekitkach;

import java.io.Serializable;

public class User implements Serializable {
    private int age;
    private double weight;
    private double height;
    private boolean man;
    private int caloriesPerDay;
    private int gender;

    public User(int age, double weight, double height, boolean man, int goal){
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.man = man;

        if(man) gender = 5;
        else gender = -165;
        calculatingCaloriesPerDay(goal);
    }

    public void calculatingCaloriesPerDay(int goal){
        double calories = Math.round(((9.99 * weight) + (6.25 * height) - (4.92 * age) + gender) * 1.1);
        caloriesPerDay = (int) calories;
        if(goal == 0) caloriesPerDay = (int) Math.round(caloriesPerDay + caloriesPerDay * 0.15);
        else if (goal == 1) caloriesPerDay = (int) Math.round(caloriesPerDay - caloriesPerDay * 0.15);

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}




