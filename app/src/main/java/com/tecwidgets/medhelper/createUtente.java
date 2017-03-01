package com.tecwidgets.medhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by João Costa on 20/02/2017.
 */

public class createUtente extends AppCompatActivity {


    Button btnAdd, btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_utente);

        editText = (EditText) findViewById(R.id.editTextCreate);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnView = (Button) findViewById(R.id.btn_viewUtentes);





        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() !=0){

                    editText.setText("");
                }else{
                    Toast.makeText(createUtente.this,"Precisa de preencher os campos!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
