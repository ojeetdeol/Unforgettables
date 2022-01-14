package com.example.unforgettables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class practice_mode extends AppCompatActivity {

final String api_url = "https://namegame.willowtreeapps.com/api/v1.0/profiles";

final String json_data =  " [{\n" +
        "        \"firstName\": \"Joel\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"headshot joel garrett\",\n" +
        "            \"height\": 340,\n" +
        "            \"id\": \"4Mv2CONANym46UwuuCIgK\",\n" +
        "            \"mimeType\": \"image/jpeg\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/headshot_joel_garrett.jpg\",\n" +
        "            \"width\": 340\n" +
        "        },\n" +
        "        \"id\": \"4NCJTL13UkK0qEIAAcg4IQ\",\n" +
        "        \"jobTitle\": \"Senior Software Engineer\",\n" +
        "        \"lastName\": \"Garrett\",\n" +
        "        \"slug\": \"joel-garrett\",\n" +
        "        \"socialLinks\": [],\n" +
        "        \"type\": \"people\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"firstName\": \"Jeff\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"headshot jeff ward\",\n" +
        "            \"height\": 340,\n" +
        "            \"id\": \"3BdQSQcuMgcs00qYoOuYSY\",\n" +
        "            \"mimeType\": \"image/jpeg\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/headshot_jeff_ward.jpg\",\n" +
        "            \"width\": 340\n" +
        "        },\n" +
        "        \"id\": \"1X2lomt8iIYImCQysey6Eq\",\n" +
        "        \"jobTitle\": \"Principal Software Engineer\",\n" +
        "        \"lastName\": \"Ward\",\n" +
        "        \"slug\": \"jeffery-ward\",\n" +
        "        \"socialLinks\": [],\n" +
        "        \"type\": \"people\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"firstName\": \"Ashley\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"headshot ashley joost\",\n" +
        "            \"height\": 340,\n" +
        "            \"id\": \"ezBlWGiV9ucqAsiOo0Iy2\",\n" +
        "            \"mimeType\": \"image/jpeg\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/headshot_ashley_joost.jpg\",\n" +
        "            \"width\": 340\n" +
        "        },\n" +
        "        \"id\": \"56zuFgdeoMqAOuIKe0M4AU\",\n" +
        "        \"jobTitle\": \"Senior Software Engineer\",\n" +
        "        \"lastName\": \"Joost\",\n" +
        "        \"slug\": \"ashley-joost\",\n" +
        "        \"socialLinks\": [],\n" +
        "        \"type\": \"people\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"firstName\": \"Ben\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"ben frye 2020\",\n" +
        "            \"height\": 450,\n" +
        "            \"id\": \"6xFkqIGXS8WlbqAx8nQ5vX\",\n" +
        "            \"mimeType\": \"image/jpeg\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/ben_frye.jpeg\",\n" +
        "            \"width\": 450\n" +
        "        },\n" +
        "        \"id\": \"29XgxedqmAO86mGeImqwEK\",\n" +
        "        \"jobTitle\": \"Senior Software Engineer\",\n" +
        "        \"lastName\": \"Frye\",\n" +
        "        \"slug\": \"ben-frye\",\n" +
        "        \"socialLinks\": [],\n" +
        "        \"type\": \"people\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"firstName\": \"Christy\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"Christy Phillips, Chief Talent Officer at WillowTree, Inc.\",\n" +
        "            \"height\": 705,\n" +
        "            \"id\": \"64IBagkE0gga82G2W6cWsm\",\n" +
        "            \"mimeType\": \"image/png\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/Christy_HeadshotNew.png\",\n" +
        "            \"width\": 705\n" +
        "        },\n" +
        "        \"id\": \"2dMXmpIHPicQW6SW60qeKs\",\n" +
        "        \"jobTitle\": \"Chief Talent Officer\",\n" +
        "        \"lastName\": \"Phillips\",\n" +
        "        \"slug\": \"christy-phillips\",\n" +
        "        \"socialLinks\": [\n" +
        "            {\n" +
        "                \"callToAction\": \"Follow Christy Phillips on LinkedIn\",\n" +
        "                \"type\": \"linkedin\",\n" +
        "                \"url\": \"https://www.linkedin.com/in/christyphillips1/\"\n" +
        "            }\n" +
        "        ],\n" +
        "        \"type\": \"people\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"bio\": \"Senior Technical Recruiter\",\n" +
        "        \"firstName\": \"Heather\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"headshot heather raines2\",\n" +
        "            \"height\": 340,\n" +
        "            \"id\": \"4bvFPBvTU4iO84MqGs4mge\",\n" +
        "            \"mimeType\": \"image/jpeg\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/headshot_heather_raines2.jpg\",\n" +
        "            \"width\": 340\n" +
        "        },\n" +
        "        \"id\": \"4rugkOBzAcccWYKkKSqKQK\",\n" +
        "        \"jobTitle\": \"Senior Technical Recruiter\",\n" +
        "        \"lastName\": \"Raines\",\n" +
        "        \"slug\": \"heather-raines\",\n" +
        "        \"socialLinks\": [],\n" +
        "        \"type\": \"people\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"firstName\": \"Rich\",\n" +
        "        \"headshot\": {\n" +
        "            \"alt\": \"headshot rich friedel\",\n" +
        "            \"height\": 340,\n" +
        "            \"id\": \"2VVBxdMyas06mW6EWW4wgy\",\n" +
        "            \"mimeType\": \"image/jpeg\",\n" +
        "            \"type\": \"image\",\n" +
        "            \"url\": \"https://namegame.willowtreeapps.com/images/headshot_rich_friedel.jpg\",\n" +
        "            \"width\": 340\n" +
        "        },\n" +
        "        \"id\": \"5udIAbCug8Y8yYMSaM8w0u\",\n" +
        "        \"jobTitle\": \"Software Engineer\",\n" +
        "        \"lastName\": \"Friedel\",\n" +
        "        \"slug\": \"rich-friedel\",\n" +
        "        \"socialLinks\": [],\n" +
        "        \"type\": \"people\"\n" +
        "    } ]";
ArrayList<Willow_Employee> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__items);
        employees = new ArrayList<Willow_Employee>();

        //Assuming we have data

        //JSONArray fetched_data = json_endpoint

        try {
            JSONArray employee_data = new JSONArray(json_data);
            for(int i = 0; i<employee_data.length(); i++){

                String first_name = (String) employee_data.getJSONObject(i).get("firstName");
                String last_name = (String) employee_data.getJSONObject(i).get("lastName");

                JSONObject temp_object = (JSONObject) employee_data.getJSONObject(i).get("headshot");

                String img_url = (String) temp_object.get("url");

                Willow_Employee we = new Willow_Employee(first_name, last_name, img_url);

                employees.add(we);

            }

            ArrayList<Integer> generated = new ArrayList<Integer>();

            final int num_of_random_employees = 6;

            for(int i =0; i < num_of_random_employees; i++){
                int index = (int) Math.random() * employees.size() - 1;

                if(!generated.contains(index)){
                    generated.add(index);
                    String pic_id = "pic_" + (i+1);

                    Willow_Employee picked_employee= employees.get(index);
                    ImageView iv = findViewById(R.id.)

                }


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }








    }
    }

