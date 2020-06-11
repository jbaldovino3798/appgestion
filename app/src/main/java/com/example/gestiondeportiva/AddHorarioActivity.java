package com.example.gestiondeportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddHorarioActivity extends AppCompatActivity {

    private EditText edtHora;
    private EditText edtFecha;
    private EditText edtDescripcion;
    private Button btnAgregarHorario;
    private String hora;
    private String fecha;
    private String descripcion;
    DatabaseReference firebaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_horario);

        firebaseReference = FirebaseDatabase.getInstance().getReference();
        edtHora = findViewById(R.id.edtHora);
        edtFecha = findViewById(R.id.edtFecha);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        btnAgregarHorario = findViewById(R.id.btnAgregarHorario);

        btnAgregarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora = edtHora.getText().toString();
                fecha = edtFecha.getText().toString();
                descripcion = edtDescripcion.getText().toString();
                if(!hora.isEmpty() && !fecha.isEmpty() && !descripcion.isEmpty()){
                    registrarHorario(hora, fecha, descripcion);
                }else{
                    Toast.makeText(AddHorarioActivity.this, "Debe completar los campos ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarHorario(String hora, String fecha, String descripcion) {
        Map<String, Object> datosHorario = new HashMap<>();
        datosHorario.put("hora", hora);
        datosHorario.put("fecha", fecha);
        datosHorario.put("descripcion", descripcion);
        firebaseReference.child("Horario").push().setValue(datosHorario);
        Toast.makeText(AddHorarioActivity.this, "Horario añadido", Toast.LENGTH_SHORT).show();
    }
}
