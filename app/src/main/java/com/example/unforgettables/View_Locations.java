package com.example.unforgettables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class View_Locations extends AppCompatActivity {


    ArrayList<String> location_list;
    ArrayAdapter<String> location_list_adapter;
    ListView listView;


    FusedLocationProviderClient mFusedLocationClient;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__locations);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //Setting listView up with adapter
        listView = findViewById(R.id.locations_list);
        location_list = new ArrayList<>();

        location_list_adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,location_list);

        listView.setAdapter(location_list_adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String location_name = location_list.get(position);

                Context context = getApplicationContext();
                CharSequence text = "DELETED: " + location_name;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                location_list.remove(position);
                listView.setAdapter(location_list_adapter);
                return false;
            }
        });
    }

    //FIX
    public void add_location(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            Context context = getApplicationContext();
            CharSequence text = "PLEASE TURN ON LOCATION PERMISSIONS";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            //System.out.println("here "+ location.getLatitude());
                            location_list.add(location.getLatitude() + " , " +
                                    location.getLongitude());
                            listView.setAdapter(location_list_adapter);
                            
                        }
                        else{
                            System.out.println("no location found");
                        }
                    }
                });
    }

}