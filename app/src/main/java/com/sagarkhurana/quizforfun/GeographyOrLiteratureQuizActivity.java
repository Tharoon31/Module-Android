package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sagarkhurana.quizforfun.other.Constants;
import com.sagarkhurana.quizforfun.other.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeographyOrLiteratureQuizActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private TextView tvQuestion, tvQuestionNumber;
    private Button btnNext;
    private List<Button> buttons;
    private List<String> questions;
    private int correctQuestion = 0;
    private Map<String, Map<String, Boolean>> questionsAnswerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geography_or_literature_quiz);

        Intent intent = getIntent();
        String subject = intent.getStringExtra(Constants.SUBJECT);

        TextView tvTitle = findViewById(R.id.textView26);

        if (subject.equals(getString(R.string.Level1))) {
            questionsAnswerMap = Utils.getRandomLiteratureAndGeographyQuestions(this, getString(R.string.literature), Constants.QUESTION_SHOWING);
            tvTitle.setText(getString(R.string.Level1));
        } else if (subject.equals(getString(R.string.Level2))) {
            questionsAnswerMap = Utils.getRandomLiteratureAndGeographyQuestions(this, getString(R.string.geography), Constants.QUESTION_SHOWING);
            tvTitle.setText(getString(R.string.Level2));
        } else if (subject.equals(getString(R.string.Level3))) {
            questionsAnswerMap = Utils.getRandomLiteratureAndGeographyQuestions(this, getString(R.string.geography), Constants.QUESTION_SHOWING);
            tvTitle.setText(getString(R.string.Level3));
        } else if (subject.equals(getString(R.string.Level4))) {
            questionsAnswerMap = Utils.getRandomLiteratureAndGeographyQuestions(this, getString(R.string.geography), Constants.QUESTION_SHOWING);
            tvTitle.setText(getString(R.string.Level4));
        }
        questions = new ArrayList<>(questionsAnswerMap.keySet());

        tvQuestion = findViewById(R.id.textView78);
        tvQuestionNumber = findViewById(R.id.textView18);
        btnNext = findViewById(R.id.btnNextQuestionLiteratureAndGeography);
        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.button1));
        buttons.add(findViewById(R.id.button2));
        buttons.add(findViewById(R.id.button3));
        buttons.add(findViewById(R.id.button4));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button selectedButton = getSelectedButton();
                if (selectedButton != null) {
                    boolean answer = questionsAnswerMap.get(questions.get(currentQuestionIndex)).get(selectedButton.getText());

                    if (answer) {
                        correctQuestion++;
                    }
                }

                currentQuestionIndex++;

                if (currentQuestionIndex < Constants.QUESTION_SHOWING) {
                    displayNextQuestions();
                } else {
                    Intent intentResult = new Intent(GeographyOrLiteratureQuizActivity.this, FinalResultActivity.class);
                    intentResult.putExtra(Constants.SUBJECT, subject);
                    intentResult.putExtra(Constants.CORRECT, correctQuestion);
                    intentResult.putExtra(Constants.INCORRECT, Constants.QUESTION_SHOWING - correctQuestion);
                    intentResult.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentResult);
                    finish();
                }
            }
        });

        findViewById(R.id.imageViewStartQuizGeographyOrLiterature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        displayData();
    }

    private void displayNextQuestions() {
        tvQuestion.setText(questions.get(currentQuestionIndex));
        tvQuestionNumber.setText("Current Question: " + (currentQuestionIndex + 1));
        setAnswersToButtons();
    }

    private void displayData() {
        tvQuestion.setText(questions.get(currentQuestionIndex));
        tvQuestionNumber.setText("Current Question: " + (currentQuestionIndex + 1));
        setAnswersToButtons();
    }

    private void setAnswersToButtons() {
        ArrayList<String> questionKey = new ArrayList<>(questionsAnswerMap.get(questions.get(currentQuestionIndex)).keySet());

        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            button.setText(questionKey.get(i));
            button.setBackgroundResource(android.R.drawable.btn_default); // Reset background color
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Reset background color of all buttons
                    for (Button btn : buttons) {
                        btn.setBackgroundResource(android.R.drawable.btn_default);
                    }
                    // Highlight selected button
                    button.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                }
            });
        }
    }

    private Button getSelectedButton() {
        for (Button button : buttons) {
            if (button.getBackground().getConstantState() == getResources().getDrawable(android.R.color.holo_blue_light).getConstantState()) {
                return button;
            }
        }
        return null;
    }
}
