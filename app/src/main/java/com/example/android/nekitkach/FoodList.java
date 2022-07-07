package com.example.android.nekitkach;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodList extends ListFragment {
    private String[] foodName = {
            "Яйцо",
            "Хлеб",
            "Каша гречневая",
            "Каша манная",
            "Каша Овсянная",
            "Сыр",
            "Колбаса варёная",
            "Колбаса копчёная",
            "Макароны"
    };
    private int[] foodCalories = {
            157,
            75,
            300,
            333,
            342,
            85,
            83,
            94,
            370
    };
    private int[] foodImage = {
            R.drawable.egg,
            R.drawable.bred,
            R.drawable.grechevaya_kasha,
            R.drawable.mannaya_kasha,
            R.drawable.ovsanaya_kasha,
            R.drawable.cheese,
            R.drawable.kolbasa_varenaya,
            R.drawable.kolbasa_kapcenaya,
            R.drawable.macaroni
    };
    private boolean[] checkFood = {
            true,
            true,
            false,
            false,
            false,
            true,
            true,
            true,
            false
    };

    private boolean startFragment = true;

    private int buttonID;
    private ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    private ArrayList<Food> foodList = new ArrayList<>();

    private ArrayList<String> foodNameArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < foodName.length; i++){
            map = new HashMap<String, String>();
            map.put("Name", foodName[i]);
            map.put("Image", Integer.toString(foodImage[i]));
            map.put("Cal", Integer.toString(foodCalories[i]));
            data.add(map);
        }

        String[] from = {"Name", "Image", "Cal"};
        int[] to = {R.id.name, R.id.image, R.id.cal};


        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), data, R.layout.list_row, from, to);
        setListAdapter(adapter);

        for(int i = 0; i < foodName.length; i++){
            foodList.add(new Food(foodName[i], foodCalories[i], foodImage[i], checkFood[i]));
        }

        buttonID = getArguments().getInt("eat");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setBackgroundColor(getResources().getColor(R.color.background));


    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bundle = new Bundle();
        bundle.putString("nameFood", foodList.get(position).getName());
        bundle.putInt("imageFood", foodList.get(position).getImage());
        bundle.putInt("caloriesFood", foodList.get(position).getCalories());
        bundle.putInt("buttonID", buttonID);
        AddEat addEatTransfer = new AddEat();
        AddEatNum addEatNumTransfer = new AddEatNum();
        addEatTransfer.setArguments(bundle);
        addEatNumTransfer.setArguments(bundle);

        if(checkFood[position]) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.secondFragment, addEatNumTransfer, "fromFoodListToAddEatNum")
                    .addToBackStack(null).commit();
        } else {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.secondFragment, addEatTransfer, "fromFoodListToAddEat")
                    .addToBackStack(null).commit();
        }
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }
}