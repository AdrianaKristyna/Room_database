package com.example.room_database;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add_User_Fragment extends Fragment {

    private EditText UserId,UserName,UserEmail;
    private Button btnSave;


    public Add_User_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_add__user_, container, false);

        UserId=view.findViewById(R.id.idUser);
        UserName=view.findViewById(R.id.nameUser);
        UserEmail=view.findViewById(R.id.emailUser);
        btnSave=view.findViewById(R.id.saveId);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid=Integer.parseInt(UserId.getText().toString());
                String username=UserName.getText().toString();
                String useremail=UserEmail.getText().toString();

                User user=new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"add user",Toast.LENGTH_SHORT).show();

                UserId.setText("");
                UserName.setText("");
                UserEmail.setText("");
            }
        });

        return view;
    }



}
