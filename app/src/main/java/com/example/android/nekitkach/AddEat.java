package com.example.android.nekitkach;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddEat extends Fragment {
    private Button acceptFood;
    private TextView caloriesInAddEat;
    private User theUser;
    private TextView nameFood;
    private TextView textRemainsCalories;
    private TextView caloriesNow;
    private TextView infoCalories;
    private EditText inputGram;
    private ImageView imageFood;

    private int totalCalories = 0;
    private int caloriesOfFood;
    private int buttonID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_eat, container, false);

        acceptFood = v.findViewById(R.id.acceptInAddEat);
        caloriesInAddEat = v.findViewById(R.id.caloriesInAddEat);
        nameFood = v.findViewById(R.id.nameFoodInAddEat);
        imageFood = v.findViewById(R.id.foodImageInAddEat);
        infoCalories = v.findViewById(R.id.infoCaloriesInAddEat);

        inputGram = v.findViewById(R.id.inputGram);

        caloriesOfFood = getArguments().getInt("caloriesFood");
        nameFood.setText(getArguments().getString("nameFood"));
        infoCalories.setText("В ста граммах - " + caloriesOfFood);
        imageFood.setImageResource(getArguments().getInt("imageFood"));

        buttonID = getArguments().getInt("buttonID");

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

        inputGram.addTextChangedListener(new TextWatcher(){

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                try {
                    int input = Integer.parseInt(s.toString());
                    totalCalories = caloriesOfFood * input / 100;
                }catch (Exception e){
                    totalCalories = 0;
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {
                caloriesInAddEat.setText("" + totalCalories + " Калорий");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

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