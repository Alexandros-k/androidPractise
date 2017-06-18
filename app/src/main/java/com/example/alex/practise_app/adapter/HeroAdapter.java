package com.example.alex.practise_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alex.practise_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 6/12/2017.
 */

public class HeroAdapter extends ArrayAdapter {

    static class DataHandler{

        TextView heroNameTv;
        TextView heroPowerTv;

    }


    List list = new ArrayList();

    public HeroAdapter( Context context,  int resource) {
        super(context, resource);
    }


    @Override
    public void add( Object object) {
        super.add(object);
        list.add(object);
    }


    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }



   @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row= inflater.inflate(R.layout.browse_activity_row,parent,false);

        }else{
            handler=(DataHandler) row.getTag();
        }
       handler= new DataHandler();
       handler.heroNameTv=(TextView) row.findViewById(R.id.heroNameTv);
       handler.heroPowerTv=(TextView) row.findViewById(R.id.heroPowerTv);
        HeroDataProvider dataProvider;
        dataProvider=(HeroDataProvider)this.getItem(position);

        handler.heroNameTv.setText(dataProvider.getHero_name());

        handler.heroPowerTv.setText(dataProvider.getHero_power());

        return row;
    }

   /* @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.browse_activity_row, parent, false);
        }
        // Lookup view for data population
        TextView heroName = (TextView) convertView.findViewById(R.id.heroNameTv);
        TextView heroPower = (TextView) convertView.findViewById(R.id.heroPowerTv);
        // Populate the data into the template view using the data object
        HeroDataProvider dataProvider;
        dataProvider=(HeroDataProvider)this.getItem(position);
        heroName.setText(dataProvider.getHero_name());
        heroPower.setText(dataProvider.getHero_power());
        // Return the completed view to render on screen
        return convertView;
    }*/

}
