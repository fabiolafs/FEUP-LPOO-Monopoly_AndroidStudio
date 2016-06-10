package com.example.fabiola.monopoly;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;

/**
 * Created by andrecorreia on 01/06/16.
 */

public class Client extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";
    String message;

    Client(String addr, int port,String message) {
        dstAddress = addr;
        dstPort = port;
        this.message=message;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(dstAddress, dstPort);
            OutputStream outputStream;
            outputStream = socket.getOutputStream();
            //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            //byte[] buffer = message.getBytes();

            //int bytesMessage = message.length();
            //InputStream inputStream = socket.getInputStream();

            //byteArrayOutputStream.write(buffer, 0, bytesMessage);
            //response += byteArrayOutputStream.toString("UTF-8");*/


            PrintStream printStream = new PrintStream(outputStream);
            printStream.print(message);
            printStream.close();


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        //textResponse.setText(response);
        super.onPostExecute(result);
    }

}