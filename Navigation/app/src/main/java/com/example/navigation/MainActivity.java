package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name;
    Button navigate ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.editTextTextPersonName);
        navigate = (Button) findViewById(R.id.button);
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Here", Toast.LENGTH_SHORT).show();
                String myName = name.getText().toString();
                Intent it = new Intent(MainActivity.this,SecondActivity.class);
                it.putExtra("key",myName);
                startActivity(it);
            }
        });
    }

}