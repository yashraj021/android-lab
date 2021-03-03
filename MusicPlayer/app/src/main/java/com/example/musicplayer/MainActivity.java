package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    SeekBar scrubBar;

    public void play(View view) {
        mediaPlayer.start();
    }

    public void pause(View view) {
        mediaPlayer.pause();
    }

    boolean touch = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        scrubBar = findViewById(R.id.seekBar);

        scrubBar.setMax(mediaPlayer.getDuration());

        scrubBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               if(touch) mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                touch = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                touch=false;
            }
        });

       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               scrubBar.setProgress(mediaPlayer.getCurrentPosition());
           }
       }, 0, 300);
    }
}