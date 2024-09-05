package com.example.drawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Basic_Projects extends Fragment {

    ArrayList<contactModel> arrayBasic = new ArrayList<contactModel>();

    public Basic_Projects() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =  inflater.inflate(R.layout.fragment_basic__projects, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewBasic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        String tictactoeGIT = "https://github.com/Ayushh2609/TicTacToe.git";
        String whatschatGIT = "https://github.com/Ayushh2609/WhatsChat.git";

        if(arrayBasic.isEmpty()) {
            arrayBasic.add(new contactModel(R.drawable.tictactoe, "Tic-Tac-Toe", "Tic-Tac-Toe: The Classic Game Reimagined" , "My first android application" , getTicTacToe_ss() , tictactoeGIT));
            arrayBasic.add(new contactModel(R.drawable.whatschat, "WhatsChat", "Load unknown number chat easily" , "Tried to solve a daily life problem where you need to save the number first to chat with someone." , getWhatschat_ss() , whatschatGIT));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() , arrayBasic);
        recyclerView.setAdapter(recyclerViewAdapter);



        return view;
    }


    static ArrayList<Integer> getTicTacToe_ss(){
        ArrayList<Integer> arrayListScreenShots_tictactoe = new ArrayList<>();
        arrayListScreenShots_tictactoe.add(R.drawable.tictactoe_ss_1);
        arrayListScreenShots_tictactoe.add(R.drawable.tictactoe_ss_2);
        arrayListScreenShots_tictactoe.add(R.drawable.tictactoe_ss_3);

        return arrayListScreenShots_tictactoe;
    };

    static ArrayList<Integer> getWhatschat_ss(){
        ArrayList<Integer> arrayListScreenShots_tictactoe = new ArrayList<>();
        arrayListScreenShots_tictactoe.add(R.drawable.whatchhat_1);
        arrayListScreenShots_tictactoe.add(R.drawable.whatchhat_2);
        arrayListScreenShots_tictactoe.add(R.drawable.whatchhat_3);

        return arrayListScreenShots_tictactoe;
    };
}