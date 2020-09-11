package com.example.facemaker;

/* @author Maxwell McAtee*/


import java.util.Random;

public class Face {

    //Instance variables for different details of the face
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //Constructor for the Face object
    public Face()
    {

    }

    //Randomizer method
    //Sets the instance variables to random values
    public void randomize()
    {
        //Random object for creating random hex colors
        Random rand = new Random();

        //Producing the three random colors
        this.skinColor = rand.nextInt(0xffffff + 1);
        this.eyeColor = rand.nextInt(0xffffff + 1);
        this.hairColor = rand.nextInt(0xffffff + 1);

        //For now I have it getting a random number between 0 and 2 as I have 3 hairstyles
        this.hairStyle = (int)(Math.random()*3);
    }




}
