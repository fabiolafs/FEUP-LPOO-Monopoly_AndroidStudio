package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Fabiola on 29/05/2016.
 */
public class ShowPropertyActivity extends Activity {

    private String propertyName;

    public static boolean active = false;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_card);

        View mortgagebutton = findViewById(R.id.button8);
        mortgagebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.tcpClient.sendMessage("Mortgage");

            }

        });

        View unmortgagebutton = findViewById(R.id.button7);
        unmortgagebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.tcpClient.sendMessage("Unmortgage");

            }

        });

        View buildhouses = findViewById(R.id.button9);
        buildhouses.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.tcpClient.sendMessage("Unmortgage");

            }

        });

        View buildhotel = findViewById(R.id.button10);
        buildhotel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.tcpClient.sendMessage("Unmortgage");

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

        final ImageView imageView = (ImageView) findViewById(R.id.imageView4);
        imageView.setImageResource(R.drawable.atlantic_avenue);

    }
}
