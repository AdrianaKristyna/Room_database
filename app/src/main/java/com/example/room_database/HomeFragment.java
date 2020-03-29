package com.example.room_database;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button bnAddUser,bnViewUser,bnDeleteUser,btUpdateUser;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        bnAddUser=view.findViewById(R.id.addUser);
        bnAddUser.setOnClickListener(this);

        bnViewUser=view.findViewById(R.id.viewUser);
        bnViewUser.setOnClickListener(this);

        bnDeleteUser=view.findViewById(R.id.deleteUser);
        bnDeleteUser.setOnClickListener(this);

        btUpdateUser=view.findViewById(R.id.updateUser);
        btUpdateUser.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())  {
            case R.id.addUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_containr,new Add_User_Fragment()).addToBackStack(null).commit();
                break;

            case R.id.viewUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_containr,new Read_User_Fragment()).addToBackStack(null).commit();
                break;

            case R.id.deleteUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_containr,new Delete_User_Fragment()).addToBackStack(null).commit();
                break;

            case R.id.updateUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_containr,new Update_User_Fragment()).addToBackStack(null).commit();
                break;

        }



        }
}
