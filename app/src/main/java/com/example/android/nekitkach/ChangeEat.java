package com.example.android.nekitkach;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class ChangeEat extends ListFragment {

    private String[] foodName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        foodName = getArguments().getStringArray("arrayFoodName");

        ListAdapter adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, foodName);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_change_eat, container, false);
    }
}