package com.example.ac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mathRadioGroup;
    private RadioGroup gameRadioGroup;
    private RadioGroup historyRadioGroup;
    private int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathRadioGroup = findViewById(R.id.mathRadioGroup);
        gameRadioGroup = findViewById(R.id.gameRadioGroup);
        historyRadioGroup = findViewById(R.id.historyRadioGroup);

        Button sendButton = findViewById(R.id.sendButton);
        Button resetButton = findViewById(R.id.resetButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswers = 0;

                int selectedMathId = mathRadioGroup.getCheckedRadioButtonId();
                int selectedGameId = gameRadioGroup.getCheckedRadioButtonId();
                int selectedHistoryId = historyRadioGroup.getCheckedRadioButtonId();

                if (selectedMathId == -1 || selectedGameId == -1 || selectedHistoryId == -1) {
                    Toast.makeText(MainActivity.this, "Selecione uma resposta para todas as perguntas!", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedMathButton = findViewById(selectedMathId);
                if (selectedMathButton.getText().toString().equals("50")) {
                    correctAnswers++;
                }

                RadioButton selectedGameButton = findViewById(selectedGameId);
                if (selectedGameButton.getText().toString().equals("Baldur's Gate 3")) {
                    correctAnswers++;
                }

                RadioButton selectedHistoryButton = findViewById(selectedHistoryId);
                if (selectedHistoryButton.getText().toString().equals("1945")) {
                    correctAnswers++;
                }

                String message = "Você acertou " + correctAnswers + " de 3 perguntas!";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathRadioGroup.clearCheck();
                gameRadioGroup.clearCheck();
                historyRadioGroup.clearCheck();
                correctAnswers = 0;
            }
        });
    }
}