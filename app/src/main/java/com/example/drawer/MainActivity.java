package com.example.drawer;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Drawer And Navigation
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);


        //TabLayout and ViewPager
        TabLayout tablayout = findViewById(R.id.tabLayoutApps);
        ViewPager viewpager = findViewById(R.id.viewPagerApps);

        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(vpa);
        tablayout.setupWithViewPager(viewpager);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout ,toolbar , R.string.opendrawer , R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Log.d(TAG, "onCreate: Toggle created");


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                //Github Account
                if (item.getItemId() == R.id.github) {

                    Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://github.com/Ayushh2609"));
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Opening Github", Toast.LENGTH_SHORT).show();

                    drawerLayout.closeDrawer(GravityCompat.START);



                //LinkedIn Account
                } else if (item.getItemId() == R.id.linkedIn) {

                    Intent linkedIn = new Intent(Intent.ACTION_VIEW);
                    linkedIn.setData(Uri.parse("https://www.linkedin.com/in/ayush-paliwal-358862227?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"));
                    startActivity(linkedIn);

                    Toast.makeText(MainActivity.this, "Opening LinkedIn", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);


                //Email
                } else if (item.getItemId() == R.id.Email) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("message/rfc822");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"paliwalaayush717@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Offer Letter");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Love, \n\nKya tum mre Bacho Ki maa Banna Pasand krogee.\n\nYour Deepak Kalal");
                    emailIntent.setPackage("com.google.android.gm");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send email using..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
                    }

                    drawerLayout.closeDrawer(GravityCompat.START);


                //Contact
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    final String[] options = {"Whatsapp" , "SMS" , "Call"};


                    builder.setTitle("What do you prefer?");
                    builder.setIcon(R.drawable.contactus);
                    builder.setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){

                                case 0:
                                    //Whatsappp
                                    String phn = "8272070774";
                                    String url = "https://wa.me/" + phn;
                                    Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
                                    whatsappIntent.setData(Uri.parse(url));

                                    try {
                                        startActivity(whatsappIntent);
                                    } catch (android.content.ActivityNotFoundException ex) {
                                        Toast.makeText(MainActivity.this, "WhatsApp is not installed on your device.", Toast.LENGTH_SHORT).show();
                                    }

                                    drawerLayout.closeDrawer(GravityCompat.START);
                                    break;


                                case 1:
                                    //Message(SMS)
                                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                                    smsIntent.setData(Uri.parse("smsto:" + "8272070774"));
                                    smsIntent.putExtra("sms_body" , "Hello Ayush,\n\n");
                                    startActivity(smsIntent);

                                    drawerLayout.closeDrawer(GravityCompat.START);
                                    break;

                                case 2:
                                    //Call
                                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                                    callIntent.setData(Uri.parse("tel:" + "8272070774"));
                                    startActivity(callIntent);

                                    drawerLayout.closeDrawer(GravityCompat.START);
                                    break;
                            }
                        }
                    });builder.show();
                }
                return true;
            }
        });

    }


//    private void openFrag(Fragment fragment){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        ft.add(R.id.container , fragment);
//        ft.commit();
//    }


}