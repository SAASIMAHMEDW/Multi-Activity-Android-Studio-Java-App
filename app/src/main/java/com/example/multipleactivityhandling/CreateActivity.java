package com.example.multipleactivityhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    public static final String NAME = "NAME",EMAIL = "EMAIL",PASSWORD = "PASSWORD",PASSWORD_HINT = "PASSWORD_HINT",ABOUT = "ABOUT",AGE = "AGE";
    public static final String TAG = "CreateActivity";
    String name;
    String email;
    String password;
    String passwordHint;
    String about;
    String age;
    Button createBTN_C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createBTN_C = findViewById(R.id.createBTN_C);
        createBTN_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createActivityBuilder();
                createIntentActivityAndSendInfo();

            }
        });
    }

    private void createActivityBuilder() {

        EditText nameETV_C, aboutETV_C;
        EditText emailETV_C;
        EditText AgeENV_C;
        EditText passwordETV_C,passwordHintPassETV_C;


        nameETV_C = findViewById(R.id.nameETV_A);
        emailETV_C = findViewById(R.id.emailETV_A);
        aboutETV_C = findViewById(R.id.aboutETV_A);
        passwordETV_C = findViewById(R.id.passwordPETV_A);
        passwordHintPassETV_C = findViewById(R.id.passwordHintPassETV_A);
        AgeENV_C = findViewById(R.id.AgeENV_A);


         name = nameETV_C.getText().toString();
         email = emailETV_C.getText().toString();
         password = passwordETV_C.getText().toString();
         passwordHint = passwordHintPassETV_C.getText().toString();
         about = aboutETV_C.getText().toString();
         age = AgeENV_C.getText().toString();
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }

    public void createIntentActivityAndSendInfo(){

        Intent intent;
        intent = new Intent(CreateActivity.this, MainActivity.class);
        intent.putExtra(NAME, name);
        intent.putExtra(AGE, age);
        intent.putExtra(EMAIL, email);
        intent.putExtra(PASSWORD, password);
        intent.putExtra(PASSWORD_HINT, passwordHint);
        intent.putExtra(ABOUT, about);
        startActivity(intent);

    }
}