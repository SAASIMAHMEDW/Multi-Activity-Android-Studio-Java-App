package com.example.multipleactivityhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class successActivity extends AppCompatActivity {
    Button goHomeBTN;
    String nameS,emailS,passwordS,passwordHintS,aboutS;
    int ageS;
    TextView AboutAndGender,emailDataTV,passwordDataTV,passwordHintDataTV,fullNameTV,ageTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        getAndSetIntentDataSuccess();
        setInfo();

        goHomeBTN = findViewById(R.id.goHomeBTN);
        goHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(successActivity.this,Integer.toString(ageS), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(successActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });
    }

    public void getAndSetIntentDataSuccess(){
        Intent getIntentData = getIntent();
        nameS = getIntentData.getStringExtra(CreateActivity.NAME);
        emailS = getIntentData.getStringExtra(CreateActivity.EMAIL);
        passwordS = getIntentData.getStringExtra(CreateActivity.PASSWORD);
        passwordHintS = getIntentData.getStringExtra(CreateActivity.PASSWORD_HINT);
        aboutS = getIntentData.getStringExtra(CreateActivity.ABOUT);
        ageS = getIntentData.getIntExtra(CreateActivity.AGE,0);

    }

    public void setInfo(){

        AboutAndGender = findViewById(R.id.AboutAndGenderDataTV);
        emailDataTV = findViewById(R.id.emailDataTV);
        passwordDataTV = findViewById(R.id.passwordDataTV);
        passwordHintDataTV = findViewById(R.id.passwordHintDataTV);
        fullNameTV = findViewById(R.id.fullNameDataTV);
        ageTV = findViewById(R.id.ageDataTV);

        String fullName = fullNameTV.getText().toString();
        String email = emailDataTV.getText().toString();
        String password = passwordDataTV.getText().toString();
        String passwordHint = passwordHintDataTV.getText().toString();
        String about = AboutAndGender.getText().toString();

        String age = ageTV.getText().toString();
        String ageSTR = Integer.toString(ageS);
        ageTV.setText(age+ageSTR);

        fullNameTV.setText(fullName+nameS);
        emailDataTV.setText(email+emailS);
        passwordDataTV.setText(password+passwordS);
        passwordHintDataTV.setText(passwordHint+passwordHintS);
        AboutAndGender.setText(about+aboutS);
    }
}