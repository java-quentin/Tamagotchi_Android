package com.example.tamagotchi_andr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RockPaperScissorsGame extends AppCompatActivity {
    private ImageView userChoiceImage;
    private ImageView vexChoiceImage;
    private TextView resultText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        // Initialize views
        userChoiceImage = findViewById(R.id.user_choice_image);
        vexChoiceImage = findViewById(R.id.vex_choice_image);
        resultText = findViewById(R.id.result_text);
        backButton = findViewById(R.id.button_back_rock_paper_scissors);

        // Set click listener for the "Back" button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set click listeners for user choices
        ImageView rockChoice = findViewById(R.id.rock);
        rockChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performGameLogic("rock");
            }
        });

        ImageView paperChoice = findViewById(R.id.paper);
        paperChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performGameLogic("paper");
            }
        });

        ImageView scissorsChoice = findViewById(R.id.scissors);
        scissorsChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performGameLogic("scissors");
            }
        });

    }

    private void performGameLogic(String userChoice) {
        String vexChoice = generateVexChoice();

        userChoiceImage.setImageResource(getDrawableResource(userChoice));
        vexChoiceImage.setImageResource(getDrawableResource(vexChoice));

        String result = determineGameResult(userChoice, vexChoice);
        resultText.setText(result);
    }

    private String generateVexChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private int getDrawableResource(String choice) {
        switch (choice) {
            case "rock":
                return R.drawable.rock;
            case "paper":
                return R.drawable.paper;
            case "scissors":
                return R.drawable.scissors;
            default:
                return 0;
        }
    }

    private String determineGameResult(String userChoice, String vexChoice) {
        MainActivity.saturation -= 2;
        if (userChoice.equals(vexChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("rock") && vexChoice.equals("scissors")) ||
                (userChoice.equals("paper") && vexChoice.equals("rock")) ||
                (userChoice.equals("scissors") && vexChoice.equals("paper"))) {
            MainActivity.money += 20;
            return "You win!";
        } else {
            MainActivity.hapiness -= 10;
            return "Vex wins!";
        }
    }
}
