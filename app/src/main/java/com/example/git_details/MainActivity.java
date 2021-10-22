package com.example.git_details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        EditText username = (EditText) findViewById(R.id.username);
        TextView error = (TextView) findViewById(R.id.data);
        String response = "";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error.setText(username.getText());
            }
        });

    }



//    public void get_details(View view) {
//        error.setText(username.getText());
//        if(username.getText() != null) {
//            try {
//                URL url = new URL("https://api.github.com/users/" + username.getText().toString());
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("GET");
//                if(conn.getResponseCode() != 200) {
//                    error.setText("Cannot connect to Github server");
//                }
//                else {
//                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                    String line;
//                    while((line = in.readLine()) != null)
//                        response += line;
//                    error.setText(response);
//                    JSONObject obj = new JSONObject(response);
//                    String followers = obj.getString("followers");
//                    error.setText(followers);
//                }
//            }
//            catch (IOException e) {
//                System.out.println("Error");
//            }

//        }
}