package com.example.notepad;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    ListAdapter(Context context, ArrayList arrayList){
        super(context,R.layout.linear_layout,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.linear_layout,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.circleImageView);
        TextView nameText = convertView.findViewById(R.id.name);
        TextView subNameText = convertView.findViewById(R.id.subName);

        imageView.setImageResource(user.imageId);
        nameText.setText(user.name);
        subNameText.setText(user.subName);

        return convertView;
    }
}
