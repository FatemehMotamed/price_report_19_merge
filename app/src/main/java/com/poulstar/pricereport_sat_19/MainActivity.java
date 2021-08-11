package com.poulstar.pricereport_sat_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment f1 = new MainFragment();
        FragmentManager f1_maneger = getSupportFragmentManager();
        FragmentTransaction f1_transaction = f1_maneger.beginTransaction();
        f1_transaction.replace(R.id.fragment_layot, f1);
        f1_transaction.commit();


    }


}