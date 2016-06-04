package com.example.fabiola.monopoly;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends Activity implements OnClickListener {

    public static TcpClient tcpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ConnectTask().execute("");


        // Set up click listeners for all the buttons
        View playNowButton = findViewById(R.id.playNow_button);
        playNowButton.setOnClickListener(this);

        View optionsButton = findViewById(R.id.options_button);
        optionsButton.setOnClickListener(this);

        View helpButton = findViewById(R.id.help_button);
        helpButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        //---------------------------------------------
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.playNow_button:
                i = new Intent(this, PlayNowActivity.class);
                startActivity(i);
                break;
            case R.id.options_button:
                i = new Intent(this, OptionsActivity.class);
                tcpClient.sendMessage("options");
                startActivity(i);
                break;
            case R.id.help_button:
                i = new Intent(this, HelpActivity.class);
                tcpClient.sendMessage("help");
                startActivity(i);
                break;
            case R.id.exit_button:
                finish();
                break;
        }
    }

    public class ConnectTask extends AsyncTask<String,String,TcpClient> {

        @Override
        protected TcpClient doInBackground(String... message) {

            //we create a TCPClient object and
            tcpClient = new TcpClient(new TcpClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {

                    //this method calls the onProgressUpdate
                    publishProgress(message);

                }
            });
            tcpClient.run();

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        /*View view = adapter.getChildView(0, 0, false, null, null);
        TextView text = (TextView) view.findViewById(R.id.betChildOdd);
        child2.get(0).get(0).put("OLD", text.getText().toString());
        child2.get(0).get(0).put(CONVERTED_ODDS, values[0].toString());
        child2.get(0).get(0).put("CHANGE", "TRUE");
        adapter.notifyDataSetChanged();*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
