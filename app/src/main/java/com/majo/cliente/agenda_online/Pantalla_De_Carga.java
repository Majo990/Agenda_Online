package com.majo.cliente.agenda_online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Pantalla_De_Carga extends AppCompatActivity {
   //autenticacion de incio de sesion del usuario

     FirebaseAuth  firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        //instacia para autenticiar los usaurio en la app

        firebaseAuth = FirebaseAuth.getInstance();

        int Tiempo = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               /* startActivity(new Intent( Pantalla_De_Carga.this, MainActivity.class));
                finish();*/
                VerificarUsuario();
            }
        },Tiempo);
    }

    private  void VerificarUsuario (){
        //se Obtiene el usuario actual usuario que previamente se registro y a inciado sesion
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        //ahora creamos la condicion si e lsuario esta logueado

        if (firebaseUser == null){
            startActivity(new Intent(Pantalla_De_Carga.this, MainActivity.class));
            finish();//si el suario es nulo lo mandar a la pantalla main actitvit pagian pricipna
        }else {
            startActivity(new Intent(Pantalla_De_Carga.this, MenuPrincipal.class));
            finish();//si el suario se a logueado lo dejara aceder
        }

    }
}