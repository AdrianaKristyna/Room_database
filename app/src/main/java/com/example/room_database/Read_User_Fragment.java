package com.example.room_database;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Read_User_Fragment extends Fragment {
    private TextView TxtInfo,TxtInfo2;


    public Read_User_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read__user_, container, false);
        TxtInfo=view.findViewById(R.id.txt_display_info);
        TxtInfo2=view.findViewById(R.id.txt_display_info2);

        List<User> users=MainActivity.myAppDatabase.myDao().getUsers();
        String info="",info2="";

        for(User usr: users)
        {
           int id = usr.getId();
           String name=usr.getName();
           String email=usr.getEmail();

           info=info+"\n\n"+"id:"+id+"\n Name:"+name+"\n";
                   //+"Email:"+email;

            info2=info2+"\n\n"+"Email:"+email+"\n";
        }

        TxtInfo.setText(info);
        TxtInfo2.setText(info2);

        return view;
    }

}
