package com.tecwidgets.medhelper;

import android.app.Fragment;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    DatabaseMedHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseMedHelper(this);



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
}
