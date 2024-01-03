package com.example.notepad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Animal> {
    SpinnerAdapter(Context context, ArrayList arrayList){
        super(context,R.layout.animal_layout,arrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Animal animal = getItem(position);

        TextView textView =convertView.findViewById(R.id.animal);
        textView.setText(animal.id);
        return convertView;
    }
}

