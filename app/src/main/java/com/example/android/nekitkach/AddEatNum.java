package com.example.android.nekitkach;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddEatNum extends Fragment {
    private Button addFood;
    private Button deleteFood;
    private Button acceptFood;
    private TextView caloriesInAddEatNum;
    private TextView numOfFoodText;
    private TextView infoCalories;
    private TextView textRemainsCalories;
    private TextView caloriesNow;
    private User theUser;
    private TextView nameFood;
    private ImageView imageFood;

    private int numOfFood = 0;
    private int caloriesOfFood = 0;
    private int totalCalories = 0;
    private int buttonID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_eat_num, container, false);

        addFood =  v.findViewById(R.id.addFood);
        deleteFood = v.findViewById(R.id.deleteFood);
        acceptFood = v.findViewById(R.id.acceptInAddEatNum);
        caloriesInAddEatNum = v.findViewById(R.id.caloriesInAddEatNum);
        nameFood = v.findViewById(R.id.nameFoodInAddEatNum);
        imageFood = v.findViewById((R.id.foodImageInAddEatNum));
        numOfFoodText = v.findViewById(R.id.numOfFood);
        infoCalories = v.findViewById(R.id.infoCalories);

        buttonID = getArguments().getInt("buttonID");
        caloriesOfFood = getArguments().getInt("caloriesFood");

        infoCalories.setText("В одной штуке - " + caloriesOfFood);
        nameFood.setText(getArguments().getString("nameFood"));
        imageFood.setImageResource(getArguments().getInt("imageFood"));


        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOfFood++;
                totalCalories = numOfFood * caloriesOfFood;
                numOfFoodText.setText("" + numOfFood);
                caloriesInAddEatNum.setText("" + totalCalories + " Калорий");

            }
        });

        deleteFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numOfFood > 0) {
                    numOfFood--;
                    totalCalories = numOfFood * caloriesOfFood;
                }
                numOfFoodText.setText("" + numOfFood);
                caloriesInAddEatNum.setText("" + totalCalories + " Калорий");
            }
        });

        acceptFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt((String) textRemainsCalories.getText());
                temp -= totalCalories;
                int temp1 = Integer.parseInt((String) caloriesNow.getText());
                temp1 += totalCalories;
                textRemainsCalories.setText("" + temp);
                caloriesNow.setText("" + temp1);

                Button button = getActivity().findViewById(buttonID);
                button.setText("Изменить");
                button.setTag(0);

                Toast toast = new Toast(getActivity().getApplicationContext());
                toast.makeText(getActivity(), "Калории изменены!", Toast.LENGTH_LONG).show();

            }
        });
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        getView().setBackgroundColor(getResources().getColor(R.color.background));
        textRemainsCalories =  getActivity().findViewById(R.id.remainsCalories);
        caloriesNow = getActivity().findViewById(R.id.caloriesNow);
    }
}