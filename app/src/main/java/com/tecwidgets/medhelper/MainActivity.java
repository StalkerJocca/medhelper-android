package com.tecwidgets.medhelper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, utentesFragment.OnHeadlineSelectedListener{

    BottomBar mBottomBar;

    EditText ET_NOME,ET_NOME_USER,ET_NOME_PASS;
    String nome,nome_user,nome_pass;
    private ImageButton buttonLogout;


    @Override
    public void onArticleSelected(int position) {
        startActivity(new Intent(MainActivity.this,createUtente.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_NOME = (EditText)findViewById(R.id.editTextMail);
        ET_NOME_PASS = (EditText)findViewById(R.id.editTextPassword);


        buttonLogout = (ImageButton) findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(this);



        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {

                    case R.id.tab_utentes:
                        utentesFragment utentesFragment = new utentesFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,utentesFragment,"oa").commit();
                        break;

                    case R.id.tab_horarios:
                        horariosFragment horariosFragment = new horariosFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,horariosFragment,"oa").commit();
                        break;

                    case R.id.tab_empresa:
                        empresaFragment empresaFragment = new empresaFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,empresaFragment,"oa").commit();

                        break;


                    case R.id.tab_instalacoes:
                        instalacoesFragment instalacoesFragment = new instalacoesFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,instalacoesFragment, "oa").commit();

                        break;

                    case R.id.tab_medicamentos:
                        medicamentosFragment medicamentosFragment = new medicamentosFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,medicamentosFragment, "oa").commit();

                        break;
                }
            }
        });



    BottomBarTab nearby = mBottomBar.getTabWithId(R.id.tab_utentes);
    nearby.setBadgeCount(20);

// Remove the badge when you're done with it.
    //nearby.removeBadge();
    }

    public void userReg(View view) {
        startActivity(new Intent(this,SignupActivity.class));
    }

    public void userLogin(View view){
        nome_user = ET_NOME.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, nome_user, nome_pass);
    }





    @Override
    public void onClick(View view) {
        if (view == buttonLogout){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
  }


}
