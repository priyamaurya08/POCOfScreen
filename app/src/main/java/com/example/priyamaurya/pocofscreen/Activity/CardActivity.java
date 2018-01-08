package com.example.priyamaurya.pocofscreen.Activity;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.priyamaurya.pocofscreen.Fragment.CardDialogFragment;
import com.example.priyamaurya.pocofscreen.R;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        FragmentManager fm=getSupportFragmentManager();
        final CardDialogFragment ed = new CardDialogFragment();
        ed.setCancelable(false);
        ed.show(fm, "Details");

    }
}
