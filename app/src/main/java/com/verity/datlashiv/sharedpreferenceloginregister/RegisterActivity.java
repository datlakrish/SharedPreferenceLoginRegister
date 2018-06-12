package com.verity.datlashiv.sharedpreferenceloginregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_name, reg_email, reg_pass;
    private Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_name = findViewById(R.id.reg_name);
        reg_email = findViewById(R.id.reg_email);
        reg_pass = findViewById(R.id.reg_password);
        reg_btn = findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newUser = reg_name.getText().toString().trim();
                String newEmail = reg_email.getText().toString().trim();
                String newPass = reg_pass.getText().toString().trim();

                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user", newUser);
                editor.putString("email", newEmail);
                editor.putString("pass", newPass);
                editor.apply();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
