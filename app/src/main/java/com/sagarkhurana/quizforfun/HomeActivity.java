package com.sagarkhurana.quizforfun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.sagarkhurana.quizforfun.data.User;
import com.sagarkhurana.quizforfun.other.Constants;
import com.sagarkhurana.quizforfun.other.SharedPref;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ImageButton toggleButton;
    NavigationView navigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawerLayout);
        toggleButton = findViewById(R.id.toggleButton);
        navigationView = findViewById(R.id.menu_view);

//        CardView cvStartQuiz = findViewById(R.id.cvStartQuiz);
//        CardView cvRule = findViewById(R.id.cvRule);
//        CardView cvHistory = findViewById(R.id.cvHistory);
//        CardView cvEditPassword = findViewById(R.id.cvEditPassword);
//        Button cvLogout = findViewById(R.id.cvLogout);
        RelativeLayout beginner = findViewById(R.id.beginner);
        RelativeLayout intermediate = findViewById(R.id.intermediate);
        RelativeLayout expert = findViewById(R.id.expert);

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        if (toggleButton != null) {
            toggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else if (drawerLayout != null) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            });
        }

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, QuizOptionActivity.class);
                intent.putExtra("levelTitle", "beginner");
                startActivity(intent);
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, QuizOptionActivity.class);
                intent.putExtra("levelTitle", "intermediate");
                startActivity(intent);
            }
        });

        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, QuizOptionActivity.class);
                intent.putExtra("levelTitle", "expert");
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.home_menu:
                intent = new Intent(HomeActivity.this, HomeActivity.class);
                break;
            case R.id.profile_menu:
                intent = new Intent(HomeActivity.this, ProfileActivity.class);
                break;
            case R.id.acheivement_menu:
                intent = new Intent(HomeActivity.this, HistoryActivity.class);
                break;
            case R.id.change_password_menu:
                intent = new Intent(HomeActivity.this, EditPasswordActivity.class);
                break;
            case R.id.logout_menu:
                SharedPref sharedPref = SharedPref.getInstance();
                sharedPref.clearUser(HomeActivity.this);

                intent = new Intent(HomeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

                break;
        }

        if (intent != null) {
            startActivity(intent);
        }

        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}