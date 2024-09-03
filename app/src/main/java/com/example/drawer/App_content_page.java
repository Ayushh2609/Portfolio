package com.example.drawer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class App_content_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_content_page);

        Toolbar toolbarActivity = findViewById(R.id.toolbarActivity);
        setSupportActionBar(toolbarActivity);

        AppCompatButton gitRepoButton = findViewById(R.id.gitRepoButton);
        AppCompatButton gitCopy = findViewById(R.id.gitCopy);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true); // Optional, but ensures back button behavior
        }



        ImageView imgAppLogo = findViewById(R.id.imgAppLogo);
        TextView txtAppName = findViewById(R.id.txtAppName);
        TextView txtDescription = findViewById(R.id.txtDescription);

//        AppCompatButton GithubBtn = findViewById(R.id.GithubBtn);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewScreenshots);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        // Create and populate the ArrayList with image resource IDs
//        ArrayList<Integer> imageResIds = Basic_Projects.getTicTacToe_ss();




        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        int logo = intent.getIntExtra("logo" , 0);

        String gitRepo = intent.getStringExtra("gitRepo");

        ArrayList<Integer> arrayScreenShot = new ArrayList<Integer>();
        arrayScreenShot = intent.getIntegerArrayListExtra("screenShots");

        // Set up the RecyclerView with an adapter
        ScreenshotsAdapter adapter = new ScreenshotsAdapter(arrayScreenShot);
        recyclerView.setAdapter(adapter);

        txtAppName.setText(name);
        txtDescription.setText(description);

        imgAppLogo.setImageResource(logo);

        gitRepoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(gitRepo));
                startActivity(intent);

                Toast.makeText(App_content_page.this, "Make Sure to login in to your GitHub Acoount.", Toast.LENGTH_LONG).show();
            }
        });

        gitCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clip = ClipData.newPlainText("Copied Text" , gitRepo);
                clipboardManager.setPrimaryClip(clip);

                Toast.makeText(App_content_page.this, "Git Repo copied", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_app_content_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Navigate back to the previous activity
            finish();  // This will close the current activity and return to the previous one
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

