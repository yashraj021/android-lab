package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity Started: STARTED STATE", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed: INTERACTIVE STATE", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity Paused: PAUSED STATE", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity Stopped: STOPPED STATE", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Activity Restarted: RESTARTED STATE", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "THIS wont be displayed: DESTROYED STATE", Toast.LENGTH_LONG).show();
    }

}