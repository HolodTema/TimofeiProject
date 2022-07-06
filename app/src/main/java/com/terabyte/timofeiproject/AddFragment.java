package com.terabyte.timofeiproject;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddFragment extends Fragment {
    EditText addAddress, addTarget, addType;
    Button submit;
    MainActivity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        activity = (MainActivity) getActivity();
        addAddress = view.findViewById(R.id.add_address_ET);
        addTarget = view.findViewById(R.id.add_target_ET);
        addType = view.findViewById(R.id.add_type_ET);
        submit = view.findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(DbHelper.COL_ADDRESS, addAddress.getText().toString());
                values.put(DbHelper.COL_OBJECT_OF_VANDALISM, addTarget.getText().toString());
                values.put(DbHelper.COL_TYPE, addType.getText().toString());
                activity.db.insert(DbHelper.TABLE_NAME,null,values);

            }
        });
        return view;
    }
}