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

public class AddActividadActivity extends AppCompatActivity {

    private EditText edtHoraActividad;
    private EditText edtFechaActividad;
    private EditText edtDescripcionActividad;
    private Button btnAgregarActividad;
    private String hora;
    private String fecha;
    private String descripcion;
    DatabaseReference firebaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_horario);

        firebaseReference = FirebaseDatabase.getInstance().getReference();
        edtHoraActividad = findViewById(R.id.edtHoraActividad);
        edtFechaActividad = findViewById(R.id.edtFechaActividad);
        edtDescripcionActividad = findViewById(R.id.edtDescripcionActividad);
        btnAgregarActividad = findViewById(R.id.btnAgregarActividad);

        btnAgregarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora = edtHoraActividad.getText().toString();
                fecha = edtFechaActividad.getText().toString();
                descripcion = edtDescripcionActividad.getText().toString();
                if(!hora.isEmpty() && !fecha.isEmpty() && !descripcion.isEmpty()){
                    registrarActividad(hora, fecha, descripcion);
                }else{
                    Toast.makeText(AddActividadActivity.this, "Debe completar los campos ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarActividad(String hora, String fecha, String descripcion) {
        Map<String, Object> datosActividad = new HashMap<>();
        datosActividad.put("hora", hora);
        datosActividad.put("fecha", fecha);
        datosActividad.put("descripcion", descripcion);
        firebaseReference.child("Actividad").push().setValue(datosActividad);
        Toast.makeText(AddActividadActivity.this, "Actividad añadida", Toast.LENGTH_SHORT).show();
    }
}
