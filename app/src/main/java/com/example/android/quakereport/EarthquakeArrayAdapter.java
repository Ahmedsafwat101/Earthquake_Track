package com.example.android.quakereport;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeArrayAdapter extends ArrayAdapter<EarthquakeData> {
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
        if (listItemView == null) {
            listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_array_adapter, parent, false);
        }

        final EarthquakeData currentEarthquake = getItem(position);

        //Pass the data into the layout file
        String fullLocation = currentEarthquake.getCountryName();
        StringBuilder primaryLocation = new StringBuilder();
        StringBuilder secondaryLocation = new StringBuilder();

        if (fullLocation.contains("of")) {
            String[] countryPortions = new String[2];
            countryPortions = fullLocation.split("of", 2);
            primaryLocation.append(countryPortions[1] + "of");
            secondaryLocation.append(countryPortions[0]);
        } else {
            primaryLocation.append(fullLocation);
            secondaryLocation.append("Near the");
        }

        TextView magnitudeID = listItemView.findViewById(R.id.magnitude_txt);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEarthquake.getMagnitude());
        magnitudeID.setText(output);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeID.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        TextView countryNameID = listItemView.findViewById(R.id.country_name_txt);
        countryNameID.setText(primaryLocation.toString());

        TextView countryDistanceID = listItemView.findViewById(R.id.country_distance_txt);
        countryDistanceID.setText(secondaryLocation.toString());

        TextView dateID = listItemView.findViewById(R.id.date_txt);
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        dateID.setText(formattedDate);

        TextView timeID = listItemView.findViewById(R.id.time_txt);
        String formattedTime = formatTime(dateObject);
        timeID.setText(formattedTime);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


}
