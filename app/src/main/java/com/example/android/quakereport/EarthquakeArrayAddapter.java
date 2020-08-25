package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class EarthquakeArrayAdapter extends ArrayAdapter<EarthquakeData> {
    /***
     * @param context
     * @param earthquakeDataList
     * ***/
    public EarthquakeArrayAdapter(@NonNull Context context, List<EarthquakeData> earthquakeDataList) {
        super(context, 0, earthquakeDataList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_array_adapter,parent,false);
        }

        EarthquakeData currentEarthquake= getItem(position);

        //Pass the data into the layout file
        TextView countryNameID = listItemView.findViewById(R.id.country_name_txt);
        countryNameID.setText(currentEarthquake.getCountryName());
        TextView dateID = listItemView.findViewById(R.id.date_txt);
        dateID.setText(currentEarthquake.getDate());
        TextView magnitudeID = listItemView.findViewById(R.id.magnitude_txt);
        magnitudeID.setText(currentEarthquake.getMagnitude());


        return listItemView;
    }
}
