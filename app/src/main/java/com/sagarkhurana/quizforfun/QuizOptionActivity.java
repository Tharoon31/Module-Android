package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sagarkhurana.quizforfun.other.Constants;

public class QuizOptionActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);

//        CardView cvMath = findViewById(R.id.cvMath);
//        CardView cvGeography = findViewById(R.id.cvGeography);
//        CardView cvLiterature = findViewById(R.id.cvLiterature);

        RelativeLayout level1 = findViewById(R.id.level1);
        RelativeLayout level2 = findViewById(R.id.level2);
        RelativeLayout level3 = findViewById(R.id.level3);
        RelativeLayout level4 = findViewById(R.id.level4);
        TextView title = findViewById(R.id.textViewLevel);

        Intent intent = getIntent();
        String level = intent.getStringExtra("levelTitle");

        assert level != null;
        if (level.equals("beginner")) {
            title.setText("Beginner");
        } else if (level.equals("intermediate")) {
            title.setText("Intermediate");
        } else if (level.equals("expert")) {
            title.setText("Expert");
        }
        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.Level1));
                startActivity(intent);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.Level2));
                startActivity(intent);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.Level3));
                startActivity(intent);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.Level4));
                startActivity(intent);
            }
        });

//        cvMath.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(QuizOptionActivity.this, MathQuizActivity.class);
//                intent.putExtra(Constants.SUBJECT,getString(R.string.math));
//                startActivity(intent);
//            }
//        });
//
//        cvGeography.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
//                intent.putExtra(Constants.SUBJECT,getString(R.string.geography));
//                startActivity(intent);
//            }
//        });
//
//        cvLiterature.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(QuizOptionActivity.this, GeographyOrLiteratureQuizActivity.class);
//                intent.putExtra(Constants.SUBJECT,getString(R.string.literature));
//                startActivity(intent);
//            }
//        });

    }
}