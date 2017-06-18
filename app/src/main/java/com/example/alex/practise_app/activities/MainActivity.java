package com.example.alex.practise_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.alex.practise_app.R;
import com.example.alex.practise_app.db.HeroDbHelper;
import com.example.alex.practise_app.fragments.FragmentBrowseActivity;
import com.example.alex.practise_app.fragments.FragmentMainActivity;

public class MainActivity extends AppCompatActivity implements FragmentMainActivity.onPowerChosen {
    HeroDbHelper mHeroDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


  /*      FragmentMainActivity newFragment = new FragmentMainActivity();
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.placeholder, newFragment);
        //  transaction.addToBackStack(null);
        transaction.commit();*/

    }


    @Override
    public void onPowerSelected(String onPowerLocationInList) {

        View fragmentContainer = findViewById(R.id.fragment_container);
     //   View placeholder = findViewById(R.id.placeholder);

        boolean isDualPane = fragmentContainer != null  && fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, FragmentBrowseActivity.newInstance(onPowerLocationInList));

            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, BrowseActivity.class);
            intent.putExtra(BrowseActivity.EXTRA_POWER_POSITION_IN_LIST, onPowerLocationInList);

            startActivity(intent); //enalaktikos tropos xwris na xrisimopoiiseis tin methodo getstartIntent


          // startActivity(BrowseActivity.getStartIntent(this, onPowerLocationInList));
        }
    }
}
