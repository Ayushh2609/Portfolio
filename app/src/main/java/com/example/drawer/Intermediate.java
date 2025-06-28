package com.example.drawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class Intermediate extends Fragment {

    ArrayList<contactModel> arrayIntermediate = new ArrayList<contactModel>();

    public Intermediate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_intermediate, container, false);

        String portfolioGit = "https://github.com/Ayushh2609/Portfolio.git";
        String weatherReport = "https://github.com/Ayushh2609/Weather-Report";

        ArrayList<Integer> arrayListScreenShotsPortfolio = new ArrayList<Integer>();
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio1);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio2);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio3);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio4);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio5);

        ArrayList<Integer> arrayWeather = new ArrayList<Integer>();
        arrayWeather.add(R.drawable.weather1);
        arrayWeather.add(R.drawable.weather2);
        arrayWeather.add(R.drawable.weather3);

        RecyclerView recyclerview = view.findViewById(R.id.recyclerIntermediate);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        if(arrayIntermediate.isEmpty()){
            arrayIntermediate.add(new contactModel(R.drawable.portfoliologo , "Portfolio" , "Contains every application I have developed", "An Example of recursion also. \"You are watching Portfolio application in the portfolio application\"", arrayListScreenShotsPortfolio , portfolioGit));
            arrayIntermediate.add(new contactModel(R.drawable.icon_log , "Weather Report" , "Get real-time weather updates anytime, anywhere.", "A clean and accurate app that provides real-time temperature, forecasts, and location-based weather conditions for your daily planning.", arrayWeather , weatherReport));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayIntermediate);
        recyclerview.setAdapter(recyclerViewAdapter);

        return view;
    }
}