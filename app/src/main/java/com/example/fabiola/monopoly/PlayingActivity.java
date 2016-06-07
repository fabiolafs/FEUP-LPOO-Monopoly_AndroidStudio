package com.example.fabiola.monopoly;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class PlayingActivity extends Activity {

    public static boolean active = false;

    public static String currImage="electric_company";

    Timer timer;
    MyTimerTask myTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //setCurrentImage();
        //setImageRotateListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        active = false;
    }

    public void onResume() {
        super.onResume();



        if(timer != null){
            timer.cancel();
        }

        timer = new Timer();
        myTimerTask = new MyTimerTask();


        timer.schedule(myTimerTask, 0, 1000);
    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            //Toast.makeText(WaitActivity.this, "Please wait for other players register", Toast.LENGTH_LONG).show();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    setCurrentImage(currImage);
                    MainActivity.tcpClient.sendMessage("Which picture may I show?");
                }});
        }
    }
    /*private void setImageRotateListener() {
        final Button rotatebutton = (Button) findViewById(R.id.btnRotateImage);
        rotatebutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currImage++;
                if (currImage == 3) {
                    currImage = 0;
                }
                setCurrentImage();
            }
        });
    }*/

    private void setCurrentImage(String image) {

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        switch (image){
            case "atlantic_avenue":
                imageView.setImageResource(R.drawable.atlantic_avenue);
                break;
            case "baltic_avenue":
                imageView.setImageResource(R.drawable.baltic_avenue);
                break;
            case "bo_railroad":
                imageView.setImageResource(R.drawable.bo_railroad);
                break;
            case "board_walk":
                imageView.setImageResource(R.drawable.board_walk);
                break;
            case "connecticut_avenue":
                imageView.setImageResource(R.drawable.connecticut_avenue);
                break;
            case "electric_company":
                imageView.setImageResource(R.drawable.electric_company);
                break;
            case "illinois_avenue":
                imageView.setImageResource(R.drawable.illinois_avenue);
                break;
            case "indiana_avenue":
                imageView.setImageResource(R.drawable.indiana_avenue);
                break;
            case "kentucky_avenue":
                imageView.setImageResource(R.drawable.kentucky_avenue);
                break;
            case "marvin_gardens":
                imageView.setImageResource(R.drawable.marvin_gardens);
                break;
            case "mediterranean_avenue":
                imageView.setImageResource(R.drawable.mediterranean_avenue);
                break;
            case "new_york_avenue":
                imageView.setImageResource(R.drawable.new_york_avenue);
                break;
            case "north_carolina_avenue":
                imageView.setImageResource(R.drawable.north_carolina_avenue);
                break;
            case "oriental_avenue":
                imageView.setImageResource(R.drawable.oriental_avenue);
                break;
            case "pacific_avenue":
                imageView.setImageResource(R.drawable.pacific_avenue);
                break;
            case "park_place":
                imageView.setImageResource(R.drawable.park_place);
                break;
            case "pennsylvania_avenue":
                imageView.setImageResource(R.drawable.pennsylvania_avenue);
                break;
            case "pennsylvania_railroad":
                imageView.setImageResource(R.drawable.pennsylvania_railroad);
                break;
            case "reading_railroad":
                imageView.setImageResource(R.drawable.reading_railroad);
                break;
            case "short_line_railroad":
                imageView.setImageResource(R.drawable.short_line_railroad);
                break;
            case "st_charles_place":
                imageView.setImageResource(R.drawable.st_charles_place);
                break;
            case "st_james_place":
                imageView.setImageResource(R.drawable.st_james_place);
                break;
            case "states_avenue":
                imageView.setImageResource(R.drawable.states_avenue);
                break;
            case "tennesse_avenue":
                imageView.setImageResource(R.drawable.tennesse_avenue);
                break;
            case "ventnor_avenue":
                imageView.setImageResource(R.drawable.ventnor_avenue);
                break;
            case "vermont_avenue":
                imageView.setImageResource(R.drawable.vermont_avenue);
                break;
            case "virginia_avenue":
                imageView.setImageResource(R.drawable.virginia_avenue);
                break;
            case "water_works":
                imageView.setImageResource(R.drawable.water_works);
                break;
        }

    }

    public static void setImage(String image){
        currImage=image;
    }
}
