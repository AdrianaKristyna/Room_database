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
public class Update_User_Fragment extends Fragment {

    private EditText UserEditId,UserEditName,UserEditEmail;
    private Button btnEditSave;


    public Update_User_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update__user_, container, false);

        UserEditId=view.findViewById(R.id.idEditUser);
        UserEditName=view.findViewById(R.id.nameEditUser);
        UserEditEmail=view.findViewById(R.id.emaiEditUser);

        btnEditSave=view.findViewById(R.id.btnEditId);
        btnEditSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(UserEditId.getText().toString());
                String name=UserEditName.getText().toString();
                String email=UserEditEmail.getText().toString();

                User user=new User();
                user.setId(id);
                user.setEmail(email);
                user.setName(name);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(),"upraveno",Toast.LENGTH_SHORT).show();;

                UserEditId.setText("");
                UserEditEmail.setText("");
                UserEditName.setText("");



            }
        });

        return view;
    }

}
