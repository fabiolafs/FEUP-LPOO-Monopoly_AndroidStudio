package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class OptionsActivity extends Activity implements OnClickListener {
    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String messsage;

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

    public void teste(View v){
        //i = new Intent(this, PlayNowActivity.class);
        //startActivity(i);

        textField = (EditText) findViewById(R.id.name_editText);

        messsage =textField.getText().toString(); // get the text message on the text field
        textField.setText(""); // Reset the text field to blank

        try {

            System.out.println("entrei");
            client = new Socket("192.168.56.1", 4444); // connect to server
            printwriter = new PrintWriter(client.getOutputStream(),
                    true);
            printwriter.write(messsage); // write the message to output stream
            printwriter.flush();
            printwriter.close();
            client.close(); // closing the connection

        } catch (UnknownHostException e) {
            System.out.println("ecsadvcszlcnhsbcvdscuyv");
            e.printStackTrace();
        } catch (IOException e) {

            System.out.println("ecsadvcszlcnhsbcvdscuyv");
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backOptions_button) {
            finish();
        }
        else if (v.getId() == R.id.saveOptions_button) {
           teste(v);
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
