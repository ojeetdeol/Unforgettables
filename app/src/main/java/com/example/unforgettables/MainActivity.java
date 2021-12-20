package com.example.unforgettables;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*

    REVISE COMMENTS FOR RESIZING THE SCREEN LATER

    final int screen_width = getScreenWidth();
    final int screen_height = getScreenHeight();

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void viewItems(View view){
        Intent intent = new Intent(this,View_Items.class);
        startActivity(intent);
    }

    public void viewLocations(View view){
        Intent intent = new Intent(this,View_Locations.class);
        startActivity(intent);
    }

}