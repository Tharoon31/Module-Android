package com.sagarkhurana.quizforfun;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.sagarkhurana.quizforfun.data.Attempt;
import com.sagarkhurana.quizforfun.data.User;
import com.sagarkhurana.quizforfun.data.UserDatabase;
import com.sagarkhurana.quizforfun.data.UserDatabaseClient;
import com.sagarkhurana.quizforfun.other.SharedPref;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView username = findViewById(R.id.profile_username);
        TextView email = findViewById(R.id.profile_email);
        TextView points = findViewById(R.id.profile_points);
        Button edit = findViewById(R.id.editButton);

        SharedPref sharedPref = SharedPref.getInstance();
        User user = sharedPref.getUser(this);
        username.setText(user.getUsername());
        email.setText(user.getEmail());

        findViewById(R.id.imageViewProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EditPasswordActivity.class));
            }
        });

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Clear user session data
//                SharedPref sharedPref = SharedPref.getInstance();
//                sharedPref.clearUser(ProfileActivity.this);
//
//                // Navigate to login screen
//                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
//                // Add flags to clear the back stack so that user can't navigate back to ProfileActivity
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                // Finish the current activity to prevent user from coming back to it using back button
//                finish();
//            }
//        });

        // Calculate and set overall points
        calculateAndSetOverallPoints();
    }

    private void calculateAndSetOverallPoints() {
        // Get user's email
        String email = SharedPref.getInstance().getUser(this).getEmail();
        // Get overall points asynchronously
        new GetAllUserAttemptTask(email, new OverallPointsCallback() {
            @Override
            public void onOverallPointsCalculated(int overallPoints) {
                // Set overall points in the TextView
                TextView points = findViewById(R.id.profile_points);
                points.setText(String.valueOf(overallPoints));
            }
        }).execute();
    }

    interface OverallPointsCallback {
        void onOverallPointsCalculated(int overallPoints);
    }

    class GetAllUserAttemptTask extends AsyncTask<Void, Void, ArrayList<Attempt>> {

        private final String email;
        private final OverallPointsCallback callback;

        public GetAllUserAttemptTask(String email, OverallPointsCallback callback) {
            this.email = email;
            this.callback = callback;
        }

        @Override
        protected ArrayList<Attempt> doInBackground(Void... voids) {
            UserDatabase databaseClient = UserDatabaseClient.getInstance(getApplicationContext());
            return (ArrayList<Attempt>) databaseClient.userDao().getUserAndAttemptsWithSameEmail(email);
        }

        @Override
        protected void onPostExecute(ArrayList<Attempt> attempts) {
            super.onPostExecute(attempts);

            int overallPoints = 0;

            for (Attempt attempt : attempts) {
                overallPoints += attempt.getEarned();
            }

            // Invoke the callback with the calculated overall points
            callback.onOverallPointsCalculated(overallPoints);
        }
    }
}
