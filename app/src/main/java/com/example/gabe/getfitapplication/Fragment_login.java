package com.example.gabe.getfitapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class Fragment_login extends Fragment {
    private TextView one;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        one = (TextView) view.findViewById(R.id.TFusername);
        TextView tv = (TextView) view.findViewById(R.id.Username1);
        tv.setText("Logged in: " + one);
        return view;
    }











}
