package com.example.alex.practise_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.practise_app.R;
import com.example.alex.practise_app.db.HeroDbHelper;

public class FragmentMainActivity extends Fragment {
    HeroDbHelper mHeroDbHelper;
  private onPowerChosen mListener;


    public interface onPowerChosen {
        void onPowerSelected(String onPowerLocationInList );
    }
   public static FragmentMainActivity newInstance() {
        return new FragmentMainActivity();
    }

    public FragmentMainActivity() {
        // Required empty public constructor
    }

   @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onPowerChosen) {
            mListener = (onPowerChosen) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main_activity, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_main_activity);
        mHeroDbHelper = new HeroDbHelper(getActivity());
        mHeroDbHelper.initDb();
        String[] powers = {"strength","fly","speed"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, powers);

        ListView list=(ListView)getActivity().findViewById(R.id.PowerAdapterLv);
        list.setAdapter(adapter);

        ListView listView = (ListView) getActivity().findViewById(R.id.PowerAdapterLv);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch(position) {
                    case 0:
                        mListener.onPowerSelected("strength");

                        break;
                    case 1:
                        mListener.onPowerSelected("fly");

                        break;
                    case 2:
                        mListener.onPowerSelected("speed");

                        break;
                }




            }
        });

    }


}

