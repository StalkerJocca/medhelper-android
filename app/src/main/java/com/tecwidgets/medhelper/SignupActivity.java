package com.tecwidgets.medhelper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


/**
 * Created by João Costa on 13/02/2017.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;

    EditText ET_NOME, ET_NOME_USER, ET_NOME_PASS;
    String nome, nome_user, nome_pass;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //initializing views

        ET_NOME = (EditText)findViewById(R.id.editTextName);
        ET_NOME_USER = (EditText)findViewById(R.id.editTextMail);
        ET_NOME_PASS = (EditText)findViewById(R.id.editTextPassword);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);




        //attaching listener to button
        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    private void userReg (View view){
        nome = ET_NOME.getText().toString();
        nome_user = ET_NOME_USER.getText().toString();
        nome_pass = ET_NOME_PASS.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,nome,nome_user,nome_pass);

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        finish();
    }


    @Override
    public void onClick(View view) {

        if (view == textViewSignin){
            //will open login activity here
            startActivity(new Intent(this, LoginActivity.class));
        }
    }


}