package com.example.fabiola.monopoly;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class WaitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait2);
    }

    public void onResume() {
        super.onResume();

        Toast.makeText(this, "Please wait for other players register", Toast.LENGTH_LONG).show();

        while (true) {
                SystemClock.sleep(7000);
                MainActivity.tcpClient.sendMessage(Integer.toString(MainActivity.id) + ";It is my turn?");
            }



    }
}
