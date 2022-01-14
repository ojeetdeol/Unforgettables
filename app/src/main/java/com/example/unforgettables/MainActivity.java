package com.example.unforgettables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void practiceMode(View view){
        Intent intent = new Intent(this, practice_mode.class);
        startActivity(intent);
    }

    public void timedMode(View view){

    }

}