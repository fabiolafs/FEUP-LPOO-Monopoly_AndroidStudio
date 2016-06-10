package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class BuyingActivity extends Activity {

    public static boolean active = false;

    public static String currImage;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying);

        currImage =PlayingActivity.currImage;

        View yesbutton = findViewById(R.id.button3);
        yesbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.tcpClient.sendMessage("Yes");
                Intent i = new Intent(getApplicationContext(), WaitActivity.class);
                startActivity(i);
            }

        });

        View nobutton = findViewById(R.id.button4);
        nobutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.tcpClient.sendMessage("No");
                Intent i = new Intent(getApplicationContext(), WaitActivity.class);
                startActivity(i);
            }

        });
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

        active = true;

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        setCurrentImage(currImage);

    }

    private void setCurrentImage(String image) {

        final ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        switch (image){
            case "1":
                imageView.setImageResource(R.drawable.mediterranean_avenue);
                break;
            case "3":
                imageView.setImageResource(R.drawable.baltic_avenue);
                break;
            case "5":
                imageView.setImageResource(R.drawable.reading_railroad);
                break;
            case "6":
                imageView.setImageResource(R.drawable.oriental_avenue);
                break;
            case "8":
                imageView.setImageResource(R.drawable.vermont_avenue);
                break;
            case "9":
                imageView.setImageResource(R.drawable.connecticut_avenue);
                break;
            case "11":
                imageView.setImageResource(R.drawable.st_charles_place);
                break;
            case "12":
                imageView.setImageResource(R.drawable.electric_company);
                break;
            case "13":
                imageView.setImageResource(R.drawable.states_avenue);
                break;
            case "14":
                imageView.setImageResource(R.drawable.virginia_avenue);
                break;
            case "15":
                imageView.setImageResource(R.drawable.pennsylvania_railroad);
                break;
            case "16":
                imageView.setImageResource(R.drawable.st_james_place);
                break;
            case "18":
                imageView.setImageResource(R.drawable.tennesse_avenue);
                break;
            case "19":
                imageView.setImageResource(R.drawable.new_york_avenue);
                break;
            case "21":
                imageView.setImageResource(R.drawable.kentucky_avenue);
                break;
            case "23":
                imageView.setImageResource(R.drawable.indiana_avenue);
                break;
            case "24":
                imageView.setImageResource(R.drawable.illinois_avenue);
                break;
            case "25":
                imageView.setImageResource(R.drawable.bo_railroad);
                break;
            case "26":
                imageView.setImageResource(R.drawable.atlantic_avenue);
                break;
            case "27":
                imageView.setImageResource(R.drawable.ventnor_avenue);
                break;
            case "28":
                imageView.setImageResource(R.drawable.water_works);
                break;
            case "29":
                imageView.setImageResource(R.drawable.marvin_gardens);
                break;
            case "31":
                imageView.setImageResource(R.drawable.pacific_avenue);
                break;
            case "32":
                imageView.setImageResource(R.drawable.north_carolina_avenue);
                break;
            case "34":
                imageView.setImageResource(R.drawable.pennsylvania_avenue);
                break;
            case "35":
                imageView.setImageResource(R.drawable.short_line_railroad);
                break;
            case "37":
                imageView.setImageResource(R.drawable.park_place);
                break;
            case "39":
                imageView.setImageResource(R.drawable.board_walk);
                break;
        }

    }
    public static void setImage(String image){
        currImage=image;
    }
}

