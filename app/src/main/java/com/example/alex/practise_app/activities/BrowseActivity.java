package com.example.alex.practise_app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.alex.practise_app.R;
import com.example.alex.practise_app.db.HeroDbHelper;
import com.example.alex.practise_app.fragments.FragmentBrowseActivity;

public class BrowseActivity extends AppCompatActivity {
    HeroDbHelper myDb;
    final static String EXTRA_POWER_POSITION_IN_LIST = "power_position_in_list";
    int i;

    public static Intent getStartIntent(Context context, String onPowerLocationInList) {
        Intent intent = new Intent(context, BrowseActivity.class);
        intent.putExtra(EXTRA_POWER_POSITION_IN_LIST, onPowerLocationInList);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_activity);
        String onPowerLocationInList=getIntent().getStringExtra(EXTRA_POWER_POSITION_IN_LIST);

        System.out.print(onPowerLocationInList);

        FragmentBrowseActivity secondFragment = FragmentBrowseActivity.newInstance(onPowerLocationInList);
        secondFragment.setArguments(getIntent().getExtras());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, secondFragment);
        fragmentTransaction.commit();

    }
}
