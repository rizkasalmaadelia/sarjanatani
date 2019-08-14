package com.rizkasalma.test4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView  textViewname, textViewEmail, textViewNo_hp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }



        textViewname = (TextView) findViewById(R.id.textViewname);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewNo_hp = (TextView) findViewById(R.id.textViewNo_hp);



        //getting the current user
        User user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews

        textViewname.setText(user.getname());
        textViewEmail.setText(user.getEmail());
        textViewNo_hp.setText(user.getNo_hp());

        //when the user presses logout button
        //calling the logout method
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }
}