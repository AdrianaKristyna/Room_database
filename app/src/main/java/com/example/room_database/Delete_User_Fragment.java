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
public class Delete_User_Fragment extends Fragment {
    private EditText txtUserId;
    private Button bnUserDelete;


    public Delete_User_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete__user_, container, false);
        txtUserId=view.findViewById(R.id.idtDeleteUser);
        bnUserDelete=view.findViewById(R.id.btnDeleteUser);
        bnUserDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=Integer.parseInt(txtUserId.getText().toString());
                User user=new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(),"user deleted",Toast.LENGTH_SHORT).show();;
                txtUserId.setText("");

            }
        });


        return view;
    }

}
