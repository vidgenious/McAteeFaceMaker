package com.example.facemaker;

/* @author Maxwell McAtee*/


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Face class extends surface view and contains the onDraw method
 * that will draw the face.
 */
public class Face extends SurfaceView {

    //Instance variables for different details of the face
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

//    //Boolean instance variable that determines whether randomize is called
//    //from constructor. Is true for initial run
//    private boolean willRandom = true;

    //Paint variables for the aspects that change color
    private Paint hairPaint = new Paint();
    private Paint skinPaint = new Paint();
    private Paint eyePaint = new Paint();

    //Paint variables for aspects that don't change color
    private Paint white = new Paint();
    private Paint black = new Paint();
    private Paint red = new Paint();


    //Constructor for the Face object
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);

        //If it is the first run or an invalidate from random button, the colors
        //the colors are randomized
        if(this.hairColor == 0){
            this.randomize();
        }

        //Setting colors to paints
        this.hairPaint.setColor(this.hairColor);
        this.skinPaint.setColor(this.skinColor);
        this.eyePaint.setColor(this.eyeColor);
        this.white.setColor(Color.WHITE);
        this.black.setColor(Color.BLACK);
        this.red.setColor(Color.RED);


        //Making it so the paints will fill
        this.hairPaint.setStyle(Paint.Style.FILL);
        this.skinPaint.setStyle(Paint.Style.FILL);
        this.eyePaint.setStyle(Paint.Style.FILL);
        this.white.setStyle(Paint.Style.FILL);
        this.black.setStyle(Paint.Style.FILL);



        this.getWidth();
        this.getHeight();

    }

    //Randomizer method
    //Sets the instance variables to random values
    public void randomize() {
        //Random object for creating random hex colors
        Random rand = new Random();

        //Producing the three random colors
        this.skinColor = 0xff000000 + rand.nextInt(0xffffff + 1);
        this.eyeColor = 0xff000000 + rand.nextInt(0xffffff + 1);
        this.hairColor = 0xff000000 + rand.nextInt(0xffffff + 1);

        //For now I have it getting a random number between 0 and 2 as I have 3 hairstyles
        this.hairStyle = (int)(Math.random()*3);
    }

    //Method that draws the face
    @SuppressLint("NewApi")
    @Override
    public void onDraw(Canvas canvas){
        canvas.drawOval(200.0f, 50.0f, 1000.0f, 1000.0f, this.skinPaint );
        canvas.drawOval(320.0f, 330.0f, 520.0f, 480.0f, this.white);
        canvas.drawOval(680.0f, 330.0f, 880.0f, 480.0f, this.white);
        canvas.drawCircle(420.0f, 405.0f, 70.0f, this.eyePaint);
        canvas.drawCircle(780.0f, 405.0f, 70.0f, this.eyePaint);
        canvas.drawCircle(420.0f, 405.0f, 50.0f, this.black);
        canvas.drawCircle(780.0f, 405.0f, 50.0f, this.black);
        canvas.drawArc(400.0f, 400.0f, 800.0f, 900.0f,
                30, 120, false, this.red);



    }

    public void setPaints(){
        this.hairPaint.setColor(this.hairColor);
        this.skinPaint.setColor(this.skinColor);
        this.eyePaint.setColor(this.eyeColor);
    }

    public void changeColor(int i, int color, int choice){
//        String temp = Integer.toHexString(this.eyeColor);
//        String temp2 = Integer.toHexString(i);
//        if(temp2.length() < 2)
//        {
//            temp2 = "0" + temp2;
//        }
//        String first  = temp.substring(0,2);
//        String second = temp.substring(4);
//        temp = first + temp2 + second;
//        this.eyeColor = (int)Long.parseLong(temp,16);
        if(color == 0){
            this.changeRed(i);
        }
        if(color == 1){
            this.changeGreen(i);
        }
        if(color == 2){
            this.changeBlue(i);
        }

    }

    public void changeRed(int i){
        String temp = Integer.toHexString(this.eyeColor);
        String temp2 = Integer.toHexString(i);
        if(temp2.length() < 2)
        {
            temp2 = "0" + temp2;
        }
        String first  = temp.substring(0,2);
        String second = temp.substring(4);
        temp = first + temp2 + second;
        this.eyeColor = (int)Long.parseLong(temp,16);
    }

    public void changeBlue(int i){
        String temp = Integer.toHexString(this.eyeColor);
        String temp2 = Integer.toHexString(i);
        if(temp2.length() < 2)
        {
            temp2 = "0" + temp2;
        }
        String first  = temp.substring(0,4);
        String second = temp.substring(6);
        temp = first + temp2 + second;
        this.eyeColor = (int)Long.parseLong(temp,16);
    }

    public void changeGreen(int i){
        String temp = Integer.toHexString(this.eyeColor);
        String temp2 = Integer.toHexString(i);
        if(temp2.length() < 2)
        {
            temp2 = "0" + temp2;
        }
        String first  = temp.substring(0,6);
        temp = first + temp2;
        this.eyeColor = (int)Long.parseLong(temp,16);
    }

    public int getColor(int choice){
        if(choice == 0){
            int h = this.hairColor;
            return h;
        }else if(choice == 1){
            int e = this.eyeColor;
            return e;
        }else{
            int s = this.skinColor;
            return s;
        }
    }



}
