package com.example.multipleactivityhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    Button createBTN;
    String name,email,password,passwordHint,about;
    String testEmail,testPassword;
    int age;

    EditText passwordPETV_A;
    EditText emailETV_A;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getIntentDataL();
        emailETV_A = findViewById(R.id.emailETV_A);
        passwordPETV_A = findViewById(R.id.passwordPETV_A);

        createBTN = findViewById(R.id.createBTN_C);
        createBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testEmail = emailETV_A.getText().toString();
                testPassword = passwordPETV_A.getText().toString();
                if(testEmail.equals(email) && testPassword.equals(password)){
                    Toast.makeText(loginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {

                    if ((!testPassword.equals(password)) && (!testEmail.equals(email))){
                        Toast.makeText(loginActivity.this, "WRONG EMAIL/PASSWORD", Toast.LENGTH_SHORT).show();
                    }
                    if ((testEmail.equals(email))){

                    Toast.makeText(loginActivity.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                    }
                    if ((testPassword.equals(password))){
                        Toast.makeText(loginActivity.this, "WRONG EMAIL", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void getIntentDataL(){
        Intent getIntentData = getIntent();
        name = getIntentData.getStringExtra(CreateActivity.NAME);
        email = getIntentData.getStringExtra(CreateActivity.EMAIL);
        password = getIntentData.getStringExtra(CreateActivity.PASSWORD);
        passwordHint = getIntentData.getStringExtra(CreateActivity.PASSWORD_HINT);
        about = getIntentData.getStringExtra(CreateActivity.ABOUT);
        age = getIntentData.getIntExtra(CreateActivity.AGE,000);

    }
}