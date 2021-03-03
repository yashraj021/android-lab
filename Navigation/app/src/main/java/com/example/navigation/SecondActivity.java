package com.example.navigation;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView echoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        echoText = findViewById(R.id.textView);
        Bundle myBundle = getIntent().getExtras();

        String myText = myBundle.getString("key");
        echoText.setText(myText);
    }
}
