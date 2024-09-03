package com.example.drawer;

import java.util.ArrayList;

public class contactModel {

    int img;
    String name , description , moreDetails , githubRepo;

    ArrayList<Integer> arrayScreenShots = new ArrayList<Integer>();

    public contactModel(int img , String name , String description , String moreDetails , ArrayList<Integer> arrayScreenShots , String githubRepo){
        this.img = img;
        this.name = name;
        this.description = description;

        this.moreDetails = moreDetails;

        this.arrayScreenShots = arrayScreenShots;

        this.githubRepo = githubRepo;
    }

    public int getImg() { return img; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getMoreDetails() { return moreDetails; }
    public ArrayList<Integer> getArrayScreenShots() { return arrayScreenShots; }

}
