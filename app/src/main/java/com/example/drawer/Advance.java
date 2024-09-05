package com.example.drawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Advance extends Fragment {

    ArrayList<contactModel> arrayListAdvance = new ArrayList<contactModel>();

    public Advance() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advance, container, false);

        String AndroidTrojanGit = "https://github.com/shivamsuyal/Android-Trojan-2.0.git";

        ArrayList<Integer> arrayListScreenshotsTrojan = new ArrayList<Integer>();
        arrayListScreenshotsTrojan.add(R.drawable.portfolio1);
        arrayListScreenshotsTrojan.add(R.drawable.portfolio2);
        arrayListScreenshotsTrojan.add(R.drawable.portfolio3);

        RecyclerView recyclerviewAdvance = view.findViewById(R.id.recyclerAdvance);
        recyclerviewAdvance.setLayoutManager(new LinearLayoutManager(getContext()));


        if(arrayListAdvance.isEmpty()){
            arrayListAdvance.add(new contactModel(R.drawable.android_trojan_logo , "Android Trojan" , "Create your notes secretely" , "You can't see me, but I can....", arrayListScreenshotsTrojan,AndroidTrojanGit));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayListAdvance);
        recyclerviewAdvance.setAdapter(recyclerViewAdapter);

        return view;
    }
}