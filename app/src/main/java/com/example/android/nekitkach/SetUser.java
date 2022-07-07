package com.example.android.nekitkach;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatViewInflater;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SetUser extends AppCompatActivity{
    private EditText ageInput;
    private EditText weightInput;
    private EditText heightInput;
    private CheckBox man;
    private CheckBox woman;
    private int age;
    private double weight;
    private double height;
    private User theUser;
    private Spinner goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Инициализация view элементов
        ageInput = (EditText) findViewById(R.id.age);
        weightInput = (EditText) findViewById(R.id.weight);
        heightInput = (EditText) findViewById(R.id.height);
        man = (CheckBox) findViewById(R.id.checkMan);
        woman = (CheckBox) findViewById(R.id.checkWoman);
        goal = (Spinner) findViewById(R.id.goal);
    }

    public void checkChoiceMan(View view) {
        if(woman.isChecked()) woman.toggle();
    }
    public void checkChoiceWoman(View view) {
        if(man.isChecked()) man.toggle();
    }

    private void setUser(){
        age = Integer.parseInt(ageInput.getText().toString());
        weight = Double.parseDouble(weightInput.getText().toString());
        height = Double.parseDouble(heightInput.getText().toString());
        theUser = new User(age, weight, height, man.isChecked(), goal.getSelectedItemPosition());

    }


    public void nextPage(View view) {

        try{
            setUser();
            if(!man.isChecked() && !woman.isChecked()){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(theUser.getCaloriesPerDay() <= 600){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Вы ввели некорректные значения!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(theUser.getHeight() <= 100){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Вы ввели некорректные значения!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(theUser.getHeight() >= 250){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Вы ввели некорректные значения!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(theUser.getWeight() <= 20){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Вы ввели некорректные значения!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(theUser.getWeight() >= 300){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Вы ввели некорректные значения!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(theUser.getAge() >= 100){
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(this, "Вы ввели некорректные значения!", Toast.LENGTH_SHORT).show();
                return;
            }
            //Переход в главное меню
            Intent intent = new Intent(this, MainMenu.class);
            intent.putExtra("user", theUser);
            startActivity(intent);
        } catch (Exception e){
            Toast toast = new Toast(getApplicationContext());
            toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
        }

    }

}