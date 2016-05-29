package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Fabiola on 29/05/2016.
 */
public class ShowPropertyActivity extends Activity {

    private String propertyName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_card);


        Intent i = getIntent();
        propertyName = i.getStringExtra("property_name");

        TextView propertyName_textView = (TextView) findViewById(R.id.propertyName_textView);
        propertyName_textView.setText(propertyName);
    }
}
