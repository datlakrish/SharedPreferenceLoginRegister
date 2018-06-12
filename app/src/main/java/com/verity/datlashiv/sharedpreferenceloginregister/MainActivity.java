package com.verity.datlashiv.sharedpreferenceloginregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainTitle, mainTitle1, mainTitle2;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTitle = findViewById(R.id.main_text);
        mainTitle1 = findViewById(R.id.main_text1);
        mainTitle2 = findViewById(R.id.main_text2);
        logout = findViewById(R.id.logout);

        SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        String name = preferences.getString("user", null);
        String email = preferences.getString("email", null);
        String password = preferences.getString("pass", null);

        mainTitle.setText(name);
        mainTitle1.setText(email);
        mainTitle2.setText(password);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                finish();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
