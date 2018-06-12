package com.verity.datlashiv.sharedpreferenceloginregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText login_email, login_pass;
    private Button login_btn, login_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.login_email);
        login_pass = findViewById(R.id.login_pass);
        login_btn = findViewById(R.id.login_btn);
        login_reg = findViewById(R.id.login_reg);

        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginEmail = login_email.getText().toString().trim();
                String loginPass = login_pass.getText().toString().trim();

                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String name = preferences.getString("user", null);
                String email = preferences.getString("email", null);
                String password = preferences.getString("pass", null);

                if(loginEmail.equals(email)&& loginPass.equals(password)){

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(LoginActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
