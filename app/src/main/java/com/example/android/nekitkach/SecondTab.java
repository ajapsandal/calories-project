package com.example.android.nekitkach;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class SecondTab extends Fragment implements  View.OnClickListener {
    private Button breakfastButton;
    private Button afterBreakfastButton;
    private Button dinnerButton;
    private Button afterDinnerButton;
    private Button supperButton;
    private Button afterSupperButton;
    private FrameLayout layout;
    private ListView foodList;

    private ArrayList<String> nameFoodBreakfast;
    private ArrayList<String> nameFoodAfterBreakfast;
    private ArrayList<String> nameFoodDinner;
    private int IDButton;

    private boolean bol = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second_tab2, container, false);

        breakfastButton = (Button) v.findViewById(R.id.addBreakfastButton);
        breakfastButton.setOnClickListener(this);
        breakfastButton.setTag(1);

        afterBreakfastButton = (Button) v.findViewById(R.id.addAfterBreakfastButton);
        afterBreakfastButton.setOnClickListener(this);
        afterBreakfastButton.setTag(1);

        dinnerButton = (Button) v.findViewById(R.id.addDinnerButton);
        dinnerButton.setOnClickListener(this);
        dinnerButton.setTag(1);

        afterDinnerButton = (Button) v.findViewById(R.id.addAfterDinnerButton);
        afterDinnerButton.setOnClickListener(this);
        afterDinnerButton.setTag(1);

        supperButton = (Button) v.findViewById(R.id.addSupperButton);
        supperButton.setOnClickListener(this);
        supperButton.setTag(1);

        afterSupperButton = (Button) v.findViewById(R.id.addAfterSupperButton);
        afterSupperButton.setOnClickListener(this);
        afterSupperButton.setTag(1);

        layout = v.findViewById(R.id.secondFragment);

        return v;
    }

    @Override
    public void onClick(View v) {
        final int status = (int) v.getTag();
        IDButton = v.getId();
        switch (v.getId()) {
            case R.id.addBreakfastButton:
                if (status == 1) {
                    FoodList foodList = new FoodList();
                    Bundle bundle = new Bundle();
                    bundle.putInt("eat", R.id.addBreakfastButton);
                    foodList.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.secondFragment, foodList, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                } else {
                    ChangeEat changeEat = new ChangeEat();
                    Bundle bundle = new Bundle();
                    String[] array = new String[nameFoodBreakfast.size()];
                    bundle.putStringArray("arrayFoodName", nameFoodBreakfast.toArray(array));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.secondFragment, changeEat, "changeFragment").
                            addToBackStack(null).commit();
                }
                break;
            case R.id.addAfterBreakfastButton:
                FoodList foodList1 = new FoodList();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("eat", R.id.addAfterBreakfastButton);
                foodList1.setArguments(bundle1);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondFragment, foodList1, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.addDinnerButton:
                FoodList foodList2 = new FoodList();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("eat", R.id.addDinnerButton);
                foodList2.setArguments(bundle2);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondFragment, foodList2, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.addAfterDinnerButton:
                FoodList foodList3 = new FoodList();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("eat", R.id.addAfterDinnerButton);
                foodList3.setArguments(bundle3);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondFragment, foodList3, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.addSupperButton:
                FoodList foodList4 = new FoodList();
                Bundle bundle4 = new Bundle();
                bundle4.putInt("eat", R.id.addSupperButton);
                foodList4.setArguments(bundle4);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondFragment, foodList4, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.addAfterSupperButton:
                FoodList foodList5 = new FoodList();
                Bundle bundle5 = new Bundle();
                bundle5.putInt("eat", R.id.addAfterSupperButton);
                foodList5.setArguments(bundle5);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondFragment, foodList5, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
