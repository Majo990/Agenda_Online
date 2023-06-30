package com.majo.cliente.agenda_online;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuPrincipal extends AppCompatActivity {

    // Declaración de variables para el botón de cerrar sesión, la autenticación de Firebase y el usuario actual

    Button CerrarSesion;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el diseño de la actividad a partir del archivo XML activity_menu_principal
        setContentView(R.layout.activity_menu_principal);

        CerrarSesion = findViewById(R.id.CerrarSesion); // Asigna el botón del diseño al botón CerrarSesion
        firebaseAuth = FirebaseAuth.getInstance();// Obtiene una instancia de FirebaseAuth
        user = firebaseAuth.getCurrentUser();// Obtiene el usuario actual

        // Establece un OnClickListener en el botón CerrarSesion para realizar una acción cuando se haga clic en él
        CerrarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Llama al método SalirAplicacion cuando se hace clic en el botón
                    SalirAplicacion();
            }
        });
    }

    private void SalirAplicacion() {
        firebaseAuth.signOut();// Cierra sesión en Firebase
        startActivity(new Intent(MenuPrincipal.this, MainActivity.class));// Inicia la actividad principal
        Toast.makeText(this, "Cerrastes sesion exitosamente", Toast.LENGTH_SHORT).show(); //Muestra un mensaje al usuario indicando que ha cerrado sesión correctamente
    }
}