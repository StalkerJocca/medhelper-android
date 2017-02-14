package com.tecwidgets.medhelper;

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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    BottomBar mBottomBar;
    DatabaseMedHelper myDb;

    private FirebaseAuth firebaseAuth;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseMedHelper(this);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();



        buttonLogout = (Button) findViewById(R.id.buttonLogout);

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

    @Override
    public void onClick(View view) {
        if (view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
