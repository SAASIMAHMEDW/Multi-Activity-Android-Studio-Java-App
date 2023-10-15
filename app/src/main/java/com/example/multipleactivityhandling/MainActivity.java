package com.example.multipleactivityhandling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String name,email,password,passwordHint,about;
    int age;
    String nameS,emailS,passwordS,passwordHintS,aboutS;
    int ageS;
    Button createBTN,loginBTN,dataBTN,resetBTN2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetBTN(false);
        getIntentDataF();
        setIntentDataSuccess();

        createBTN = findViewById(R.id.createBTN_C);
        createBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        loginBTN = findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentActivityAndVerifyInfoLogin();
            }
        });

        dataBTN = findViewById(R.id.dataBTN);
        dataBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentActivityAndSuccess();
            }
        });

    }

    public void resetBTN(@NonNull Boolean status){
        if (status){
            resetBTN2 = findViewById(R.id.resetBTN2);
            resetBTN2.setClickable(true);
            resetBTN2.setVisibility(View.VISIBLE);
            resetBTN2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this, "LOL", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            resetBTN2 = findViewById(R.id.resetBTN2);
            resetBTN2.setClickable(false);
            resetBTN2.setVisibility(View.INVISIBLE);

        }

    }
    public void getIntentDataF(){
        Intent getIntentData = getIntent();
        name = getIntentData.getStringExtra(CreateActivity.NAME);
        email = getIntentData.getStringExtra(CreateActivity.EMAIL);
        password = getIntentData.getStringExtra(CreateActivity.PASSWORD);
        passwordHint = getIntentData.getStringExtra(CreateActivity.PASSWORD_HINT);
        about = getIntentData.getStringExtra(CreateActivity.ABOUT);
        age = getIntentData.getIntExtra(CreateActivity.AGE,0);

    }

    public void IntentActivityAndVerifyInfoLogin(){

        Intent intent;
        intent = new Intent(MainActivity.this, loginActivity.class);
        intent.putExtra(CreateActivity.NAME, name);
        intent.putExtra(CreateActivity.AGE, age);
        intent.putExtra(CreateActivity.EMAIL, email);
        intent.putExtra(CreateActivity.PASSWORD, password);
        intent.putExtra(CreateActivity.PASSWORD_HINT, passwordHint);
        intent.putExtra(CreateActivity.ABOUT, about);
        startActivity(intent);

    }

    public void IntentActivityAndSuccess(){

        Intent intent;
        intent = new Intent(MainActivity.this, successActivity.class);
        intent.putExtra(CreateActivity.NAME, nameS);
        intent.putExtra(CreateActivity.AGE, ageS);
        intent.putExtra(CreateActivity.EMAIL, emailS);
        intent.putExtra(CreateActivity.PASSWORD, passwordS);
        intent.putExtra(CreateActivity.PASSWORD_HINT, passwordHintS);
        intent.putExtra(CreateActivity.ABOUT, aboutS);
        startActivity(intent);

    }
    public void setIntentDataSuccess(){

        nameS = name;
        emailS = email;
        passwordS = password;
        passwordHintS = passwordHint;
        aboutS = about;
        ageS = age;

    }


}