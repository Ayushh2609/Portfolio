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

        ArrayList<Integer> arrayListScreenShotsWhatschat = new ArrayList<Integer>();
        arrayListScreenShotsWhatschat.add(R.drawable.tictactoe_ss_1);
        arrayListScreenShotsWhatschat.add(R.drawable.tictactoe_ss_2);
        arrayListScreenShotsWhatschat.add(R.drawable.tictactoe_ss_3);

        String whatschatGIT = "https://github.com/Ayushh2609/TicTacToe.git";



        if(arrayDaily.isEmpty()) {
            arrayDaily.add(new contactModel(R.drawable.whatschat, "WhatsChat", "Load unknown number chat easily" , "Tried to solve a daily life problem where you need to save the number first to chat with someone." ,arrayListScreenShotsWhatschat , whatschatGIT));
        }
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayDaily);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}