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
        String nukkadEats = "https://github.com/Ayushh2609/Nukkad-Eats";
        String nukkadEatsAdmin = "https://github.com/Ayushh2609/Nukkad-Eats_Admin";

        ArrayList<Integer> arrayListScreenshotsTrojan = new ArrayList<Integer>();
        arrayListScreenshotsTrojan.add(R.drawable.portfolio1);
        arrayListScreenshotsTrojan.add(R.drawable.portfolio2);
        arrayListScreenshotsTrojan.add(R.drawable.portfolio3);

        ArrayList<Integer> arrayListNukkadEats = new ArrayList<>();
        arrayListNukkadEats.add(R.drawable.nukkad1);
        arrayListNukkadEats.add(R.drawable.nukkad2);
        arrayListNukkadEats.add(R.drawable.nukkad3);
        arrayListNukkadEats.add(R.drawable.nukkad4);
        arrayListNukkadEats.add(R.drawable.nukkad5);
        arrayListNukkadEats.add(R.drawable.nukkad6);

        ArrayList<Integer> arrayListNukkadEatsAdmin = new ArrayList<>();
        arrayListNukkadEatsAdmin.add(R.drawable.nukkad_admin1);
        arrayListNukkadEatsAdmin.add(R.drawable.nukkad_admin2);
        arrayListNukkadEatsAdmin.add(R.drawable.nukkad_admin3);
        arrayListNukkadEatsAdmin.add(R.drawable.nukkad_admin4);
        arrayListNukkadEatsAdmin.add(R.drawable.nukkad_admin5);
        arrayListNukkadEatsAdmin.add(R.drawable.nukkad_admin6);


        RecyclerView recyclerviewAdvance = view.findViewById(R.id.recyclerAdvance);
        recyclerviewAdvance.setLayoutManager(new LinearLayoutManager(getContext()));


        if(arrayListAdvance.isEmpty()){
            arrayListAdvance.add(new contactModel(R.drawable.android_trojan_logo , "Android Trojan" , "Create your notes with a user friendly interface." , "You can't see me, but I can....", arrayListScreenshotsTrojan,AndroidTrojanGit));
            arrayListAdvance.add(new contactModel(R.drawable.logo_new , "Nukkad Eats" , "Tasty foods at your fingertips." , "A user-friendly app to explore menus, place orders, and enjoy delicious meals from nearby restaurants.", arrayListNukkadEats,nukkadEats));
            arrayListAdvance.add(new contactModel(R.drawable.logo_admin_new , "Nukkad Eats Admin" , "Manage orders, menu, and restaurant data easily." , "A powerful backend tool for restaurant owners to track orders, update dishes, and control their food business efficiently.", arrayListNukkadEatsAdmin,nukkadEatsAdmin));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayListAdvance);
        recyclerviewAdvance.setAdapter(recyclerViewAdapter);

        return view;
    }
}