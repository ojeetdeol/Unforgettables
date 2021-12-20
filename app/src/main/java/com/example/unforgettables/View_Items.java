package com.example.unforgettables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class View_Items extends AppCompatActivity {
    ArrayList<String> item_list;
    ArrayAdapter<String> item_list_adapter;
    ListView listView ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__items);

        listView = findViewById(R.id.items_list);
        item_list = new ArrayList<>();
        item_list_adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,item_list);
        listView.setAdapter(item_list_adapter);
    }

    public void add_item(View v){
        EditText item = (EditText) findViewById(R.id.item_text);
        String item_to_add = item.getText().toString();
        item_list.add(item_to_add);
        listView.setAdapter(item_list_adapter);
    }
}