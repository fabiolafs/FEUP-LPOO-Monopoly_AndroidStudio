package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

    public static TcpClient tcpClient;

    public static Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ConnectTask(this.getApplicationContext()).execute("");

        /*if (savedInstanceState!=null && savedInstanceState.getBoolean(KEY_FIRSTRUN,true)) {
            new ConnectTask(this.getApplicationContext()).execute("");
        }*/

        // Set up click listeners for all the buttons
        View playNowButton = findViewById(R.id.playNow_button);
        playNowButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                tcpClient.sendMessage("Could play?");
            }
        });

        View helpButton = findViewById(R.id.help_button);
        helpButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        //---------------------------------------------

    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            /*case R.id.playNow_button:
                tcpClient.sendMessage("Could I set game properties?");
                break;*/
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /*outState.putBoolean(KEY_FIRSTRUN, false);
        super.onSaveInstanceState(outState);*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter(MY_LOCAL_BROADCAST));*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            /*String responseData = intent.getStringExtra(KEY_RESPONSE);
            Toast.makeText(MainActivity.this, responseData, Toast.LENGTH_LONG).show();*/
        }
    };

    public class ConnectTask extends AsyncTask<String, String, TcpClient> {

        private Context context;

        public ConnectTask(Context context) {
            this.context = context;
        }

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

            switch (values[0]){
                case "Yes, you could set game properties":
                    Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(i);
                    break;
                case "Another player defining the game properties. Please wait.":
                    Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_LONG).show();
                    break;
                case "Game properties set correctly!":
                    i = new Intent(getApplicationContext(), PlayerPropertiesActivity.class);
                    startActivity(i);
                    //Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_LONG).show();
                    break;
                case "Yes, you could set player properties":
                    i = new Intent(getApplicationContext(), PlayerPropertiesActivity.class);
                    startActivity(i);
                    //Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_LONG).show();
                    break;
                case "That piece symbol already been choose! Please choose another piece.":
                    Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_LONG).show();
                    break;
                case "Your ID is 1":
                    id = 1;
                    i = new Intent(getApplicationContext(), WaitActivity.class);
                    startActivity(i);
                    break;
                case "Your ID is 2":
                    id = 2;
                    i = new Intent(getApplicationContext(), WaitActivity.class);
                    startActivity(i);
                    break;
                case "Your ID is 3":
                    id = 3;
                    i = new Intent(getApplicationContext(), WaitActivity.class);
                    startActivity(i);
                    break;
                case "Your ID is 4":
                    id = 4;
                    i = new Intent(getApplicationContext(), WaitActivity.class);
                    startActivity(i);
                    break;
                case "It is your turn":
                    if(PlayNowActivity.active || PlayingActivity.active || ManageListActivity.active || ShowPropertyActivity.active){
                        break;
                    }
                    else {
                        i = new Intent(getApplicationContext(), PlayNowActivity.class);
                        startActivity(i);
                        break;
                    }
                case "It is not your turn":
                    break;
                case "atlantic_avenue":
                    PlayingActivity.setImage("atlantic_avenue");
                    break;
                case "baltic_avenue":
                    PlayingActivity.setImage("baltic_avenue");
                    break;
                case "bo_railroad":
                    PlayingActivity.setImage("bo_railroad");
                    break;
                case "board_walk":
                    PlayingActivity.setImage("board_walk");
                    break;
                case "connecticut_avenue":
                    PlayingActivity.setImage("connecticut_avenue");
                    break;
                case "electric_company":
                    PlayingActivity.setImage("electric_company");
                    break;
                case "illinois_avenue":
                    PlayingActivity.setImage("illinois_avenue");
                    break;
                case "indiana_avenue":
                    PlayingActivity.setImage("indiana_avenue");
                    break;
                case "kentucky_avenue":
                    PlayingActivity.setImage("kentucky_avenue");
                    break;
                case "marvin_gardens":
                    PlayingActivity.setImage("marvin_gardens");
                    break;
                case "mediterranean_avenue":
                    PlayingActivity.setImage("mediterranean_avenue");
                    break;
                case "new_york_avenue":
                    PlayingActivity.setImage("new_york_avenue");
                    break;
                case "north_carolina_avenue":
                    PlayingActivity.setImage("north_carolina_avenue");
                    break;
                case "oriental_avenue":
                    PlayingActivity.setImage("oriental_avenue");
                    break;
                case "pacific_avenue":
                    PlayingActivity.setImage("pacific_avenue");
                    break;
                case "park_place":
                    PlayingActivity.setImage("park_place");
                    break;
                case "pennsylvania_avenue":
                    PlayingActivity.setImage("pennsylvania_avenue");
                    break;
                case "pennsylvania_railroad":
                    PlayingActivity.currImage="pennsylvania_railroad";
                    break;
                case "reading_railroad":
                    PlayingActivity.setImage("reading_railroad");
                    break;
                case "short_line_railroad":
                    PlayingActivity.setImage("short_line_railroad");
                    break;
                case "st_charles_place":
                    PlayingActivity.setImage("st_charles_place");
                    break;
                case "st_james_place":
                    PlayingActivity.setImage("st_james_place");
                    break;
                case "states_avenue":
                    PlayingActivity.setImage("states_avenue");
                    break;
                case "tennesse_avenue":
                    PlayingActivity.setImage("tennesse_avenue");
                    break;
                case "ventnor_avenue":
                    PlayingActivity.setImage("ventnor_avenue");
                    break;
                case "vermont_avenue":
                    PlayingActivity.setImage("vermont_avenue");
                    break;
                case "virginia_avenue":
                    PlayingActivity.setImage("virginia_avenue");
                    break;
                case "water_works":
                    PlayingActivity.setImage("water_works");
                    break;
                case "Do you want to buy this property?":
                    i = new Intent(getApplicationContext(), BuyingActivity.class);
                    startActivity(i);
                    break;
            }

            /*Intent intent = new Intent(MainActivity.MY_LOCAL_BROADCAST);
            intent.putExtra(MainActivity.KEY_RESPONSE, values);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);*/
            /*response = values[0];
            if (!response.equalsIgnoreCase(null)) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
            }*/
        }

        protected void onPostExecute(String result) {
            /*Intent intent = new Intent(MainActivity.MY_LOCAL_BROADCAST);
            intent.putExtra(MainActivity.KEY_RESPONSE, result);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);*/
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
