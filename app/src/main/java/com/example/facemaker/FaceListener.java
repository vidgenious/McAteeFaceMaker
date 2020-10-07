package com.example.facemaker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;

/**
 * Reference for spinner listener:
 *     https://stackoverflow.com/questions/1337424/android-spinner-get-the-selected-item-change-event
 */
public class FaceListener implements SeekBar.OnSeekBarChangeListener, View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    private Face face = null;
    private SeekBar red;
    private SeekBar green;
    private SeekBar blue;

    private CompoundButton hair;
    private CompoundButton skin;
    private CompoundButton eyes;

    private int choice = 0;

    public FaceListener(Face f, SeekBar r, SeekBar g, SeekBar b, CompoundButton h, CompoundButton s,
    CompoundButton e){
        this.face = f;
        this.red = r;
        this.green = g;
        this.blue = b;
        this.hair = h;
        this.skin = s;
        this.eyes = e;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar.equals(this.red)){
            this.face.changeColor(i, 0, this.choice);
        }
        if(seekBar.equals(this.green)){
            this.face.changeColor(i, 1, this.choice);
        }
        else if(seekBar.equals(this.blue)){
            this.face.changeColor(i, 2, this.choice);
        }
        this.face.setPaints();
        this.face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        this.face.randomize();
        this.face.setPaints();
        this.face.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.equals(this.hair)){
            this.choice = 0;
        }else if(compoundButton.equals(this.eyes)){
            this.choice = 1;
        }else if(compoundButton.equals(this.skin)){
            this.choice = 2;
        }
        int colFull = face.getColor(this.choice);
        String temp = Integer.toHexString(colFull);
        String redS = temp.substring(2,4);
        String greenS = temp.substring(4,6);
        String blueS = temp.substring(6);

        int r = Integer.parseInt(redS, 16);
        int g = Integer.parseInt(greenS, 16);
        int bl = Integer.parseInt(blueS, 16);

        Log.d("r", redS);

        this.red.setProgress(r);
        this.green.setProgress(g);
        this.blue.setProgress(bl);
    }
}
