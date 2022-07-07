package com.example.android.nekitkach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    private Context mContext;
    private int mResource;
    private ArrayList<Food> values;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Food> values) {
        super(context, resource, values);
        this.mContext = context;
        this.mResource = resource;
        this.values = values;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(mResource, parent, false);

        ImageView image = rowView.findViewById(R.id.image);

        image.setImageResource(values.get(position).getImage());
        TextView textName = rowView.findViewById(R.id.name);
        TextView textCalories = rowView.findViewById(R.id.cal);
        textName.setText(values.get(position).getName());
        textCalories.setText(values.get(position).getCalories());
        return convertView;
    }
}
