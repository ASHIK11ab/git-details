package com.example.git_details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        EditText username = (EditText) findViewById(R.id.username);
        TextView error = (TextView) findViewById(R.id.data);
        TextView user = (TextView) findViewById(R.id.user);
        TextView followers = (TextView) findViewById(R.id.follower_cnt);
        TextView following = (TextView) findViewById(R.id.following_cnt);
        TextView bio = (TextView) findViewById(R.id.bio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = "";
                System.out.println("Clicked");
                if(username.getText() != null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                URL url = new URL("https://api.github.com/users/" + username.getText().toString());
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("GET");
                                if(conn.getResponseCode() != 200)
                                    error.setText("Invalid username");
                                else {
                                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                    String line;
                                    while ((line = in.readLine()) != null)
                                        response += line;
                                    JSONObject obj = new JSONObject(response);
                                    user.setText(obj.getString("login"));
                                    followers.setText(obj.getString("followers"));
                                    following.setText(obj.getString("following"));
                                    bio.setText(obj.getString("bio"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    thread.start();

                }
            }
        });
    }
}