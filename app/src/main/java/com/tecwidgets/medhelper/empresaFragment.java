package com.tecwidgets.medhelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by João Costa on 13/02/2017.
 */

public class empresaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.empresa,container,false);
        final SharedPreferences sp = getContext().getSharedPreferences("empresa", Context.MODE_PRIVATE);


        final EditText empresaET = (EditText) v.findViewById(R.id.editTextName);
        final EditText localET = (EditText) v.findViewById(R.id.editTextLocalizacao);
        final TextView empresaTV = (TextView) v.findViewById(R.id.TextViewName);
        TextView localTV = (TextView) v.findViewById(R.id.TextViewLocal);


        if(sp.getString("empresa",null) != null){
            empresaET.setVisibility(View.GONE);
            empresaTV.setText(sp.getString("empresa",""));
            empresaTV.setVisibility(View.VISIBLE);
        }

        if(sp.getString("local",null) != null){
            localET.setVisibility(View.GONE);
            localTV.setText(sp.getString("local",""));
            localTV.setVisibility(View.VISIBLE);
        }


        Button btn_save = (Button) v.findViewById(R.id.buttonAddPeople);

        btn_save.setOnClickListener(new View.OnClickListener() {

            SharedPreferences.Editor editor = sp.edit();
            @Override
            public void onClick(View v) {
                if(empresaET.getText().toString() != "" && localET.getText().toString() != ""){
                    editor.putString("empresa",empresaET.getText().toString());
                    editor.putString("local", localET.getText().toString()).apply();
                }
            }
        });

        btn_save.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sp.edit().clear().apply();
                return true;
            }
        });


        return v;
    }
}
