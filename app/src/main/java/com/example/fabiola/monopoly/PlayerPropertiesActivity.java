package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.PrintWriter;
import java.net.Socket;

public class PlayerPropertiesActivity extends Activity implements OnClickListener{

    private PrintWriter printwriter;
    private EditText textField;
    private String message;
    private String pieceSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        textField = (EditText) findViewById(R.id.name_editText);

        // Set up click listeners for all the buttons
        View saveButton = findViewById(R.id.saveOptions_button);
        //saveButton.setOnClickListener(this);

        View backOptionsButton = findViewById(R.id.backOptions_button);
        backOptionsButton.setOnClickListener(this);

        View choosePieceButton = findViewById(R.id.choosePiece_button);
        choosePieceButton.setOnClickListener(this);

        saveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                message = textField.getText().toString(); // get the text message on the text field

                TextView playerName = (TextView) findViewById(R.id.playerName_textView);
                playerName.setText(message);

                message+=";";
                message+=pieceSelected;

                ImageView playerPiece = (ImageView) findViewById(R.id.playNowPiece_imageView);
                switch(pieceSelected){
                    case "0":
                        playerPiece.setImageResource(R.drawable.dog);
                    case "1":
                        playerPiece.setImageResource(R.drawable.car);
                    case "2":
                        playerPiece.setImageResource(R.drawable.ship);
                    case "3":
                        playerPiece.setImageResource(R.drawable.boot);
                    case "4":
                        playerPiece.setImageResource(R.drawable.hat);
                    case "5":
                        playerPiece.setImageResource(R.drawable.iron);
                    case "6":
                        playerPiece.setImageResource(R.drawable.thimble);
                    case "7":
                        playerPiece.setImageResource(R.drawable.wheelbarrow);
                }

                MainActivity.tcpClient.sendMessage(message);
            }
        });
    }

    //@Override
    public void onClick(View v) {
        if (v.getId() == R.id.backOptions_button) {
            finish();
        } else if (v.getId() == R.id.saveOptions_button) {

        } else if (v.getId() == R.id.choosePiece_button) {
            Intent i = new Intent(this, GridViewPiecesActivity.class);
            startActivityForResult(i,1);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                pieceSelected=data.getStringExtra("edittextvalue");
            }
        }
    }

}