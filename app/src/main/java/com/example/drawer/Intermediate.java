package com.example.drawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        String whatschatGIT = "https://github.com/Ayushh2609/TicTacToe.git";

        ArrayList<Integer> arrayListScreenShotsPortfolio = new ArrayList<Integer>();
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio1);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio2);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio3);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio4);
        arrayListScreenShotsPortfolio.add(R.drawable.portfolio5);

        RecyclerView recyclerview = view.findViewById(R.id.recyclerIntermediate);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        if(arrayIntermediate.isEmpty()){
            arrayIntermediate.add(new contactModel(R.drawable.portfoliologo , "Portfolio" , "Contains every application I have developed", "An Example of recursion also. \"You are watching Portfolio application in the portfolio application\"", arrayListScreenShotsPortfolio , whatschatGIT));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayIntermediate);
        recyclerview.setAdapter(recyclerViewAdapter);

        return view;
    }
}