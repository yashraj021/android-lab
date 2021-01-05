package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView echoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        echoText = findViewById(R.id.echotext);
        Bundle myBundle = getIntent().getExtras();

        String myText = myBundle.getString("name");
        echoText.setText(myText);
    }

}