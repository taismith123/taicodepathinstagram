package com.example.taicodepathinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private AppCompatCheckBox checkbox;
    private Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });


        checkbox = (AppCompatCheckBox) findViewById(R.id.checkbox);
        etPassword = (EditText) findViewById(R.id.etPassword);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    // show password

                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the ParseUser
                ParseUser user = new ParseUser();
                // Set core properties
                user.setUsername("joestevens");
                user.setPassword("secret123");
                user.setEmail("email@example.com");
                // Set custom properties
                user.put("phone", "650-253-0000");
                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                           // goMainActivity();
                            // Hooray! Let them use the app now.
                        } else {
                            Log.e(TAG, "Issue with signup");
                            e.printStackTrace();
                            return;
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                        }
                    }
                });

            }
        });


        ParseUser.logInInBackground("tai", "test", new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                   // goMainActivity();
                    // Hooray! The user is logged in.
                } else {
                    Log.e(TAG, "Issue with logInBackground");
                    e.printStackTrace();
                    return;
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });

        //  ParseUser currentUser = ParseUser.getCurrentUser();
        //if (currentUser != null) {
//
        //          // do stuff with the user
        //   } else {

        //goLoginScreen();
        // show the signup or login screen
        //}

    }


    private void goLoginScreen() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }



    private void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!= null ){
                    Log.e(TAG, "Issue with login");
                    e.printStackTrace();
                    return;
                }

            //navigate to new activity if user has signed in properly
            goMainActivity();

                }
            });
        }

    private void goMainActivity() {
      Intent i = new Intent(this,InstagramActivity.class);
       startActivity(i);
       finish();
    }

}


