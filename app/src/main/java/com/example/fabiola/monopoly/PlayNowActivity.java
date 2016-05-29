package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class PlayNowActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_now);

        // Set up click listeners for all the buttons
        View rollDice = findViewById(R.id.rollDice_button);
        rollDice.setOnClickListener(this);

        View manage = findViewById(R.id.manage_button);
        manage.setOnClickListener(this);

        View trade = findViewById(R.id.trade_button);
        trade.setOnClickListener(this);

        View menu = findViewById(R.id.menu_button);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()){
            case R.id.rollDice_button:
                // do something
                break;
            case R.id.manage_button:
                i = new Intent(this, ManageListActivity.class);
                startActivity(i);
                break;
            case R.id.trade_button:
                // do something
                break;
            case R.id.menu_button:
                finish();
                break;
        }
    }
}
