package com.example.gestiondeportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddTorneoActivity extends AppCompatActivity {

    private EditText edtFechaTorneo;
    private EditText edtDescripcionTorneo;
    private Button btnAgregarTorneo;
    private String fecha;
    private String descripcion;
    DatabaseReference firebaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_horario);

        firebaseReference = FirebaseDatabase.getInstance().getReference();
        edtFechaTorneo = findViewById(R.id.edtFechaTorneo);
        edtDescripcionTorneo = findViewById(R.id.edtDescripcionTorneo);
        btnAgregarTorneo = findViewById(R.id.btnAgregarTorneo);

        btnAgregarTorneo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fecha = edtFechaTorneo.getText().toString();
                descripcion = edtDescripcionTorneo.getText().toString();
                if(!fecha.isEmpty() && !descripcion.isEmpty()){
                    registrarTorneo(fecha, descripcion);
                }else{
                    Toast.makeText(AddTorneoActivity.this, "Debe completar los campos ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarTorneo(String fecha, String descripcion) {
        Map<String, Object> datosTorneo = new HashMap<>();
        datosTorneo.put("fecha", fecha);
        datosTorneo.put("descripcion", descripcion);
        firebaseReference.child("Torneo").push().setValue(datosTorneo);
        Toast.makeText(AddTorneoActivity.this, "Torneo añadido", Toast.LENGTH_SHORT).show();
    }
}
