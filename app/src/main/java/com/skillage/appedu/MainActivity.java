package com.skillage.appedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout menuKoperasi = findViewById(R.id.menuKoperasi);
        ConstraintLayout menuEDU = findViewById(R.id.menuEDU);

        menuEDU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EDUMainActivity.class);
                startActivity(i);
            }
        });

        menuKoperasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),KoperasiMainActivity.class);
                startActivity(i);
            }
        });

    }
}