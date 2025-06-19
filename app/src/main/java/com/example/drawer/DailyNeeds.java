package com.example.drawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class DailyNeeds extends Fragment {

    ArrayList<contactModel> arrayDaily = new ArrayList<contactModel>();

    public DailyNeeds() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily_needs, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerDaily);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        ArrayList<Integer> arrayListScreenShots_whatsChat = new ArrayList<>();
        arrayListScreenShots_whatsChat.add(R.drawable.whatchhat_1);
        arrayListScreenShots_whatsChat.add(R.drawable.whatchhat_2);
        arrayListScreenShots_whatsChat.add(R.drawable.whatchhat_3);

        ArrayList<Integer> arrayWeather = new ArrayList<>();
        arrayWeather.add(R.drawable.weather1);
        arrayWeather.add(R.drawable.weather2);
        arrayWeather.add(R.drawable.weather3);

        String whatschatGIT = "https://github.com/Ayushh2609/TicTacToe.git";
        String weatherReport = "https://github.com/Ayushh2609/Weather-Report";




        if(arrayDaily.isEmpty()) {
            arrayDaily.add(new contactModel(R.drawable.whatschat, "WhatsChat", "Load unknown number chat easily" , "Tried to solve a daily life problem where you need to save the number first to chat with someone." ,arrayListScreenShots_whatsChat , whatschatGIT));
            arrayDaily.add(new contactModel(R.drawable.icon_log , "Weather Report" , "Get real-time weather updates anytime, anywhere.", "A clean and accurate app that provides real-time temperature, forecasts, and location-based weather conditions for your daily planning.", arrayWeather , weatherReport));

        }
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayDaily);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}