package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();


        if(findViewById(R.id.fragment_containr)!=null){

            if(savedInstanceState!=null){

                return;

            }
        fragmentManager.beginTransaction().add(R.id.fragment_containr,new HomeFragment()).commit();
        }
    }
}
