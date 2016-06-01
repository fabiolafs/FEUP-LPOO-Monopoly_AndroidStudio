package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
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

    public void teste(){
        //i = new Intent(this, PlayNowActivity.class);
        //startActivity(i);

        textField = (EditText) findViewById(R.id.name_editText);

        messsage =textField.getText().toString(); // get the text message on the text field
        textField.setText(""); // Reset the text field to blank

        try {


            client = new Socket("172.30.14.230", 4444); // connect to server
            printwriter = new PrintWriter(client.getOutputStream(),
                    true);
            printwriter.write(messsage); // write the message to output stream
            printwriter.flush();
            printwriter.close();
            client.close(); // closing the connection
            System.out.println("entrei");
        } catch (UnknownHostException e) {
            System.out.println("exception 1---------------------");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("exception 2---------------------");
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (!connected) {
            if (!serverIpAddress.equals("")) {
                Thread cThread = new Thread(new ClientThread());
                cThread.start();
            }
        }

        if (v.getId() == R.id.backOptions_button) {
            finish();
        }
        else if (v.getId() == R.id.saveOptions_button) {
           teste();
        }
        else if (v.getId() == R.id.choosePiece_button) {
            Intent i = new Intent(this, GridViewPiecesActivity.class);
            startActivity(i);
        }

    }

    private OnClickListener connectListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (!connected) {
                if (!serverIpAddress.equals("")) {
                    Thread cThread = new Thread(new ClientThread());
                    cThread.start();
                }
            }
        }
    };

    public class ClientThread implements Runnable {

        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
                Log.d("ClientActivity", "C: Connecting...");
                Socket socket = new Socket("10.0.2.2", 4444);
                connected = true;
                while (connected) {
                    try {
                        Log.d("ClientActivity", "C: Sending command.");
                        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                                .getOutputStream())), true);
                        // WHERE YOU ISSUE THE COMMANDS
                        out.println("Hey Server!");
                        Log.d("ClientActivity", "C: Sent.");
                    } catch (Exception e) {
                        Log.e("ClientActivity", "S: Error", e);
                    }
                }
                socket.close();
                Log.d("ClientActivity", "C: Closed.");
            } catch (Exception e) {
                Log.e("ClientActivity", "C: Error", e);
                connected = false;
            }
        }
    }
    public void pieceChossed(){
        //do something
    }
}
