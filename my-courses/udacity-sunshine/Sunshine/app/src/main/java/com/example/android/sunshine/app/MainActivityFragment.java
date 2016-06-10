package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Create an arrayList for weather forecast data
        ArrayList weekForeCast = new ArrayList();
        weekForeCast.add("Today - Sunny 45C");
        weekForeCast.add("27 April, 2015 - Mild Sunny");
        weekForeCast.add("28 April, 2015 - Extremely Humid 48C");
        weekForeCast.add("29 April, 2015 - Cloudy");
        weekForeCast.add("30 April,2015 - Rainy");
        weekForeCast.add("1st May, 2015 - Mild Sunny");

        ArrayAdapter<String> weatherDataAdapter =
            new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForeCast);

        ListView weatherForecastListView = (ListView) rootView.findViewById(R.id.listview_forecast);
        weatherForecastListView.setAdapter(weatherDataAdapter);

        return rootView;
    }
}
