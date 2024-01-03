package com.example.notepad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    int pos;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.Spinner);
        Button addButton = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        EditText nameText = findViewById(R.id.nameEditText);
        EditText infoText = findViewById(R.id.infoEditText);
        ArrayList imageList = new ArrayList();
        int imageId[] = {R.drawable.lion,R.drawable.bear,R.drawable.woolf,R.drawable.peagvin,R.drawable.rabbit,R.drawable.goat};
        String name[] = {"Lion","Bear","Woolf","Peagvin","Rabbit","Goat"};
        String subName[] = {"King Of the jungle","Brown Bear","Snow queen","Cute Sea creature","Hommie Rabbit","Goat"};
        ArrayList arrayList = new ArrayList();
         for(int i = 0;i<imageId.length;i++){
            User user  = new User(imageId[i],name[i],subName[i]);
            arrayList.add(user);
        }


         int imageArr[] = {R.drawable.lion,R.drawable.bear,R.drawable.woolf,R.drawable.peagvin,R.drawable.rabbit,R.drawable.goat,R.drawable.dog,R.drawable.donkey,R.drawable.eagle,R.drawable.elephant,R.drawable.gorrila,R.drawable.sqirrel};
         String arr[]={"Lion","Bear","Woolf","Peagvin","Rabbit","Goat","Dog","Donkey","Eagle","Elephant","Gorrila","Sqirrel"};
         for (int i = 0 ;i<arr.length;i++){
             imageList.add(arr[i]);
         }

        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,imageList);
        spinnerAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
                imageView.setImageResource(imageArr[pos]);
                nameText.setText(arr[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayAdapter arrayAdapter = new ListAdapter(MainActivity.this,arrayList);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();

                String info = infoText.getText().toString();
                int imageId = imageArr[pos];
                User u = new User(imageId,name,info);

                imageView.setImageResource(imageArr[pos]);
                arrayList.add(u);
                nameText.getText().clear();
                nameText.getText().clear();
                arrayAdapter.notifyDataSetChanged();

            }
        });




        ListView listView  = findViewById(R.id.list_item);
        listView.setAdapter(arrayAdapter);
        listView.setClickable(true);

    }

    public void positionImage(View view){

    }




}