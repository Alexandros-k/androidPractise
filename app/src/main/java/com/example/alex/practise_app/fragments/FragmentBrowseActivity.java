package com.example.alex.practise_app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alex.practise_app.R;
import com.example.alex.practise_app.adapter.HeroAdapter;
import com.example.alex.practise_app.adapter.HeroDataProvider;
import com.example.alex.practise_app.db.HeroDbHelper;
import com.example.alex.practise_app.model.Hero;

import java.util.List;

public class FragmentBrowseActivity extends Fragment {
int i;
    public static final String ARG_POWER_POSITION_IN_LIST = "power_position_in_list";
    HeroDbHelper myDb;
    public FragmentBrowseActivity(){

}
    private String powerPositionInList;
    public static FragmentBrowseActivity newInstance(String powerPositionInList) {
        FragmentBrowseActivity fragment = new FragmentBrowseActivity();
        Bundle args = new Bundle();
        args.putString(ARG_POWER_POSITION_IN_LIST, powerPositionInList);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            powerPositionInList = getArguments().getString(ARG_POWER_POSITION_IN_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse_activity, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // getActivity().setContentView(R.layout.fragment_browse_activity);


      myDb = new HeroDbHelper(getActivity());
        //myDb.initDb();



          final List<Hero> hero = myDb.getHeroes();
      /*  List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("superman","Clark_Kent","fly"));
        heroes.add(new Hero("spiderman","Peter_Parker","strength"));
        heroes.add(new Hero("flash","Barry_Allen","speed"));
        heroes.add(new Hero("Storm","Aurora","fly"));
        heroes.add(new Hero("colosous","peter","strength"));
        heroes.add(new Hero("quicksilver","blabla","speed"));*/

        final String heroIntent =getActivity(). getIntent().getStringExtra(ARG_POWER_POSITION_IN_LIST);




        ListView listview = (ListView)getActivity(). findViewById(R.id.browse_activity_lv);
        HeroAdapter heroAdaptrer = new HeroAdapter(getActivity(), R.layout.browse_activity_row);
        listview.setAdapter(heroAdaptrer);

        System.out.println( "blabla" + "TO INTENT EINAI  " +heroIntent);
        System.out.println( heroIntent);
        System.out.println(hero.get(0).getSuperPower());
        for (i = 0; i < hero.size(); i++)

        {

            System.out.println(hero.get(i).getRealName()+"   "+heroIntent);

            if (hero.get(i).getSuperPower().equals(heroIntent)) {

                HeroDataProvider heroDataProvider = new HeroDataProvider(hero.get(i).getCodeName(),   hero.get(i).getSuperPower());
                heroAdaptrer.add(heroDataProvider);

            }
        }
    }
    }

