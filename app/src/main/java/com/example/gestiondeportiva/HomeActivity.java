package com.example.gestiondeportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onLaunchHorario(View view) {
        Intent intent = new Intent(HomeActivity.this, HorarioActivity.class);
        startActivity(intent);
    }

    public void onLaunchDeportistas(View view) {
        Intent intent = new Intent(HomeActivity.this, DeportistasActivity.class);
        startActivity(intent);
    }

    public void onLaunchActividades(View view) {
        Intent intent = new Intent(HomeActivity.this, ActividadesActivity.class);
        startActivity(intent);
    }

    public void onLaunchTorneos(View view) {
        Intent intent = new Intent(HomeActivity.this, TorneosActivity.class);
        startActivity(intent);
    }
}
