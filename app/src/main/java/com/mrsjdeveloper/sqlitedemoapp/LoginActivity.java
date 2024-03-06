package com.mrsjdeveloper.sqlitedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button signin;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        signin=findViewById(R.id.signin);
        DB=new DBhelper(this);
        
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String user=username.getText().toString();
                String pass=password.getText().toString();
                
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "All fields are Required..", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean checkuserpass=DB.checkUsernamePassword(user,pass);
                    if (checkuserpass){
                        Toast.makeText(LoginActivity.this, "Login Successfully..!!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}