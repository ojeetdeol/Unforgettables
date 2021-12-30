package com.example.unforgettables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item_name = item_list.get(position);
                Context context = getApplicationContext();
                CharSequence text = "DELETED: " + item_name;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                item_list.remove(position);
                listView.setAdapter(item_list_adapter);
                return false;
            }
        });

    }

    public void add_item(View v){
        EditText item =  findViewById(R.id.item_text);
        String item_to_add = item.getText().toString();
        item_list.add(item_to_add);
        listView.setAdapter(item_list_adapter);
    }
}