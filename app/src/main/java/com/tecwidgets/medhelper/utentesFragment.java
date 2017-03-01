package com.tecwidgets.medhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static android.R.attr.value;
import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by João Costa on 09/02/2017.
 */

public class utentesFragment extends Fragment  {

    OnHeadlineSelectedListener mCallback;

    Button upButton;
    View view;

    public interface OnHeadlineSelectedListener{
        public void onArticleSelected(int position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof utentesFragment.OnHeadlineSelectedListener) {
            mCallback = (utentesFragment.OnHeadlineSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.utentes,container,false);

        upButton = (Button) v.findViewById(R.id.btn_createUtente);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onArticleSelected(23);
               //TODO COMUNICAR A ACTIVIDADE PARA ELA SALTAR DE ACTIVIDADE

            }
        });
        return v;

    }

}


