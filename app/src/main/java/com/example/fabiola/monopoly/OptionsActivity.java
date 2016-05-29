package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class OptionsActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        // Set up click listeners for all the buttons
        View saveButton = findViewById(R.id.saveOptions_button);
        saveButton.setOnClickListener(this);

        View backOptionsButton = findViewById(R.id.backOptions_button);
        backOptionsButton.setOnClickListener(this);

        View choosePieceButton = findViewById(R.id.choosePiece_button);
        choosePieceButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backOptions_button) {
            finish();
        }
        else if (v.getId() == R.id.saveOptions_button) {
            // mudar dados do jogador no seridor
        }
        else if (v.getId() == R.id.choosePiece_button) {
            Intent i = new Intent(this, GridViewPiecesActivity.class);
            startActivity(i);
        }

    }

    public void pieceChossed(){
        //do something
    }
}
