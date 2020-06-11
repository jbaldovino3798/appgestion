package com.example.gestiondeportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddDeportistaActivity extends AppCompatActivity {

    private EditText edtCodigo;
    private EditText edtUsuario;
    private EditText edtNombres;
    private EditText edtApellidos;
    private EditText edtDireccion;
    private EditText edtContraseña;
    private EditText edtTelefono;
    private Button btnAgregarDeportista;
    private String codigo;
    private String nombres;
    private String usuario;
    private String apellidos;
    private String direccion;
    private String contraseña;
    private String telefono;
    DatabaseReference firebaseReference;
    //FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deportista);

        //auth = FirebaseAuth.getInstance();
        firebaseReference = FirebaseDatabase.getInstance().getReference();
        edtCodigo = findViewById(R.id.edtCodigoDeportista);
        edtUsuario = findViewById(R.id.edtNickDeportista);
        edtNombres = findViewById(R.id.edtNombresDeportista);
        edtApellidos = findViewById(R.id.edtApellidoDeportista);
        edtDireccion = findViewById(R.id.edtDireccionDeportista);
        edtContraseña = findViewById(R.id.edtPasswordDeportista);
        edtTelefono = findViewById(R.id.edtTelefonoDeportista);
        btnAgregarDeportista = findViewById(R.id.btnAgregarDeportista);

        btnAgregarDeportista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codigo = edtCodigo.getText().toString();
                usuario = edtUsuario.getText().toString();
                nombres = edtNombres.getText().toString();
                apellidos = edtApellidos.getText().toString();
                direccion = edtDireccion.getText().toString();
                telefono = edtTelefono.getText().toString();
                contraseña = edtContraseña.getText().toString();
                if(contraseña.length()>=6 && !codigo.isEmpty() && !usuario.isEmpty() && !nombres.isEmpty() && !apellidos.isEmpty()
                && !direccion.isEmpty() && !telefono.isEmpty()){
                    registrarDeportista(codigo, usuario, nombres, apellidos, direccion, telefono, contraseña);
                    //auth.createUserWithEmailAndPassword(usuario+"@unisimon.edu.co",contraseña);
                }else{
                    Toast.makeText(AddDeportistaActivity.this, "La contraseña debe contener minimo 6 caracteres", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarDeportista(String codigo, String usuario, String nombres, String apellidos, String direccion, String telefono, String contraseña) {
        Map<String, Object> datosDeportista = new HashMap<>();
        datosDeportista.put("codigo", codigo);
        datosDeportista.put("usuario", usuario);
        datosDeportista.put("nombres", nombres);
        datosDeportista.put("apellidos", apellidos);
        datosDeportista.put("direccion", direccion);
        datosDeportista.put("telefono", telefono);
        datosDeportista.put("contraseña", contraseña);
        firebaseReference.child("Deportista").push().setValue(datosDeportista);
        Toast.makeText(AddDeportistaActivity.this, "Deportista Añadido", Toast.LENGTH_SHORT).show();
    }


}
