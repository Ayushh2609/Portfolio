package com.example.drawer;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<contactModel> arrayList;

    RecyclerViewAdapter(Context context , ArrayList<contactModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_interface , parent , false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.imgAppLogo.setImageResource(arrayList.get(position).img);
        holder.txtAppName.setText(arrayList.get(position).name);
        holder.txtAppDescription.setText(arrayList.get(position).description);

        holder.linearBasicApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , App_content_page.class);
                intent.putExtra("name" , arrayList.get(position).name);
                intent.putExtra("description" , arrayList.get(position).description);
                intent.putExtra("logo" , arrayList.get(position).img);
                intent.putExtra("moreDetails" , arrayList.get(position).moreDetails);

                intent.putIntegerArrayListExtra("screenShots" , arrayList.get(position).arrayScreenShots);

                intent.putExtra("gitRepo" , arrayList.get(position).githubRepo);


                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtAppName;
        TextView txtAppDescription;
        ImageView imgAppLogo;
        LinearLayout linearBasicApp;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAppLogo = itemView.findViewById(R.id.imgAppLogo);
            txtAppName = itemView.findViewById(R.id.txtAppName);
            txtAppDescription = itemView.findViewById(R.id.txtAppDescription);
            linearBasicApp =itemView.findViewById(R.id.llAppList);


        }
    }
}
