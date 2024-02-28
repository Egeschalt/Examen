package com.example.ejerciciopropuesto2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario, etContraseña;
    Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario = findViewById(R.id.et_usuario);
        etContraseña = findViewById(R.id.et_contraseña);
        btEntrar = findViewById(R.id.bt_entrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarCredenciales();
            }
        });
    }
    private void verificarCredenciales() {
        String usuario = etUsuario.getText().toString().trim();
        String contraseña = etContraseña.getText().toString().trim();

        if (usuario.equals("Eberlin") && contraseña.equals("123456")) {
            // Credenciales correctas, puedes realizar la acción deseada, por ejemplo, abrir una nueva actividad.
            Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            // Agrega aquí la lógica para pasar a la siguiente actividad o realizar otras acciones.
            pantallaincio(btEntrar);
        } else {
            // Credenciales incorrectas, muestra un mensaje de error.
            Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    public void pantallaincio(View view) {
        Context context=view.getContext();
        String nombres=etUsuario.getText().toString();
        Intent intent=new Intent(context, Actividad_Matricula.class);
        intent.putExtra("ClienteNombre",nombres);
        startActivity(intent);
    }
}