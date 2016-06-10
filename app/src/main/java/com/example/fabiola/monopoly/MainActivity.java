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
                    if(PlayNowActivity.active || ManageListActivity.active || ShowPropertyActivity.active || BuyingActivity.active){
                        break;
                    }
                    else {
                        i = new Intent(getApplicationContext(), PlayNowActivity.class);
                        startActivity(i);
                        break;
                    }
                case "1":
                    PlayingActivity.setImage("1");
                    break;
                case "3":
                    PlayingActivity.setImage("3");
                    break;
                case "5":
                    PlayingActivity.setImage("5");
                    break;
                case "6":
                    PlayingActivity.setImage("6");
                    break;
                case "8":
                    PlayingActivity.setImage("8");
                    break;
                case "9":
                    PlayingActivity.setImage("9");
                    break;
                case "11":
                    PlayingActivity.setImage("11");
                    break;
                case "12":
                    PlayingActivity.setImage("12");
                    break;
                case "13":
                    PlayingActivity.setImage("13");
                    break;
                case "14":
                    PlayingActivity.setImage("14");
                    break;
                case "15":
                    PlayingActivity.setImage("15");
                    break;
                case "16":
                    PlayingActivity.setImage("16");
                    break;
                case "18":
                    PlayingActivity.setImage("18");
                    break;
                case "19":
                    PlayingActivity.setImage("19");
                    break;
                case "21":
                    PlayingActivity.setImage("21");
                    break;
                case "23":
                    PlayingActivity.setImage("23");
                    break;
                case "24":
                    PlayingActivity.setImage("24");
                    break;
                case "25":
                    PlayingActivity.setImage("25");
                    break;
                case "26":
                    PlayingActivity.setImage("26");
                    break;
                case "27":
                    PlayingActivity.setImage("27");
                    break;
                case "28":
                    PlayingActivity.setImage("28");
                    break;
                case "29":
                    PlayingActivity.setImage("29");
                    break;
                case "31":
                    PlayingActivity.setImage("31");
                    break;
                case "32":
                    PlayingActivity.setImage("32");
                    break;
                case "34":
                    PlayingActivity.setImage("34");
                    break;
                case "35":
                    PlayingActivity.setImage("35");
                    break;
                case "37":
                    PlayingActivity.setImage("37");
                    break;
                case "39":
                    PlayingActivity.setImage("39");
                    break;
                case "Do you want to buy this property?":
                    if(PlayNowActivity.active || ManageListActivity.active || ShowPropertyActivity.active || BuyingActivity.active || WaitActivity.active){
                        break;
                    }
                    else {
                        i = new Intent(getApplicationContext(), BuyingActivity.class);
                        startActivity(i);
                        break;
                    }
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
