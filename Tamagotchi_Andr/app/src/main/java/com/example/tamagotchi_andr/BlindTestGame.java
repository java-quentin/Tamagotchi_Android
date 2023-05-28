package com.example.tamagotchi_andr;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class BlindTestGame extends AppCompatActivity {
    private boolean isStart = false;
    private boolean firstStart = false;
    private MediaPlayer mediaPlayer;
    private int currentMusicIndex = -1; // Index of the currently playing music

    private final String[] musicFiles = {
            "abba", "britney_spears", "imagine_dragons",
            "jean_jaques_goldman", "johnny_hallyday",
            "queen", "renaud", "stromae"
    };
    private Button buttonPlay;
    private Button buttonValidate;
    private EditText artistInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind_test);

        buttonPlay = findViewById(R.id.button_play);
        buttonValidate = findViewById(R.id.button_validate);
        artistInput = findViewById(R.id.item_input);

        Random random = new Random();
        currentMusicIndex = random.nextInt(musicFiles.length);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRandomMusic();
            }
        });

        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!firstStart) {
                    Toast.makeText(BlindTestGame.this, "Listen to the music first", Toast.LENGTH_SHORT).show();
                    return;
                }
                firstStart = false;
                mediaPlayer.stop();
                validateCurrentMusicFolderName();
            }
        });

        Button btnBack = findViewById(R.id.button_back_blind_test);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart) {
                    mediaPlayer.stop();
                }
                finish();
            }
        });
    }

    private void playRandomMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        int musicResource = getResources().getIdentifier(musicFiles[currentMusicIndex], "raw", getPackageName());
        try {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), musicResource);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    isStart = false;
                    buttonPlay.setText("Play");
                }
            });

            if (!isStart) {
                mediaPlayer.start();
                firstStart = true;
                isStart = true;
                buttonPlay.setText("Stop");
            } else {
                mediaPlayer.pause();
                isStart = false;
                buttonPlay.setText("Play");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateCurrentMusicFolderName() {
        String userInput = artistInput.getText().toString().trim();
        String currentMusicFolderName = musicFiles[currentMusicIndex].replace("_", " ");

        if (currentMusicIndex != -1 && userInput.equalsIgnoreCase(currentMusicFolderName)) {
            MainActivity.money += 20;
            // User input matches the current music folder name
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            MainActivity.hapiness -= 10;
            // User input does not match the current music folder name
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        MainActivity.saturation -= 2;

        finish();
    }
}
