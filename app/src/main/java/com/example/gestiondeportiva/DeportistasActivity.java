package com.example.gestiondeportiva;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class DeportistasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportistas);

        FloatingActionButton fabdeportista = findViewById(R.id.fabdeportistas);
        fabdeportista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeportistasActivity.this, AddDeportistaActivity.class);
                startActivity(intent);
            }
        });
    }
}
