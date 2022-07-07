package com.example.android.nekitkach;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FirstTab extends Fragment {
    private TextView caloriesText;
    private TextView remainsCalories;
    private TextView water;
    private Button addWater;
    private Button deleteWater;
    private double countWater;

    private int calories = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_first_tab2, container, false);
        caloriesText = (TextView) v.findViewById(R.id.calories);
        remainsCalories = (TextView) v.findViewById(R.id.remainsCalories);
        addWater = (Button) v.findViewById(R.id.addWaterButton);
        water = (TextView) v.findViewById(R.id.water);
        deleteWater = (Button) v.findViewById(R.id.deleteWaterButton);

        calories = getArguments().getInt("calories");
        caloriesText.setText("" + calories);
        remainsCalories.setText("" + calories);

        if(savedInstanceState != null) {
            countWater = savedInstanceState.getDouble("water");
            water.setText("" + countWater + "л");
        }

        addWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countWater += 0.25;
                water.setText("" + countWater + "л");
            }
        });

        deleteWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countWater != 0) {
                    countWater -= 0.25;
                    water.setText("" + countWater + "л");
                }
            }
        });

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putDouble("water", countWater);
    }

    public void changeCalories(){
        int caloriesFromFragment = getArguments().getInt("totalCalories");
        caloriesText.setText("" + caloriesFromFragment);
    }
    
}