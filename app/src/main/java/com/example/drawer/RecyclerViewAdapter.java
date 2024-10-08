package com.example.drawer;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
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

        holder.linearBasicApp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(context, "Long Press Triggered", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Options");

                final String[] options = {"Update" , "Delete"};

                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:


                                Dialog dialog_Update = new Dialog(context);
                                dialog_Update.setContentView(R.layout.add_update);

                                AppCompatButton btnSave = dialog_Update.findViewById(R.id.btnSave);
                                EditText edtName = dialog_Update.findViewById(R.id.edtName);
                                EditText edtDescription = dialog_Update.findViewById(R.id.description);
                                EditText edtMoreDetails = dialog_Update.findViewById(R.id.moreDetails);
                                EditText edtGithubInput = dialog_Update.findViewById(R.id.githubInput);

                                TextView addContact = dialog_Update.findViewById(R.id.addContact);


                                addContact.setText("Update Contact");
                                btnSave.setText("Update");

                                edtName.setText(arrayList.get(position).name);
                                edtDescription.setText(arrayList.get(position).description);

                                btnSave.setOnClickListener(new View.OnClickListener() {       //Update Conditions
                                    @Override
                                    public void onClick(View v) {

                                        String name = "" , description = "" , moreDetails = "";
                                        String githubRepo = "https://github.com/shivamsuyal/Android-Trojan-2.0.git";

                                        ArrayList<Integer> ss = new ArrayList<>();
                                        ss.add(R.drawable.portfolio3);


                                        if(!edtName.getText().toString().equals("")){
                                            name = edtName.getText().toString();
                                        }else{
                                            Toast.makeText(context , "Please Enter The Name!" , Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        if(!edtDescription.getText().toString().equals("")){
                                            description = edtDescription.getText().toString();
                                        }else{
                                            Toast.makeText(context , "Please provide the description of the the application." , Toast.LENGTH_SHORT).show();
                                            return;
                                        }

                                        if(!edtMoreDetails.getText().toString().equals("")){
                                            moreDetails = edtMoreDetails.getText().toString();
                                        }else{
                                            Toast.makeText(context , "Please enter more details about the applcations." , Toast.LENGTH_SHORT).show();
                                            return;
                                        }

                                        if(!edtGithubInput.getText().toString().equals("")){
                                            githubRepo = edtGithubInput.getText().toString();
                                        }else{
                                            Toast.makeText(context , "Please provide the github repository url." , Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        arrayList.set(position,new contactModel(R.drawable.android_trojan_logo , name , description , moreDetails , ss , githubRepo));
                                        notifyItemChanged(position);

                                        dialog_Update.dismiss();


                                    }
                                });

                                dialog_Update.show();

                                break;
                            case 1:

                                delete_item();

                        }
                    }
                    public void delete_item() {

                        arrayList.remove(position);
                        notifyItemRemoved(position);
                    }
                });
                builder.show();

                return true;
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
