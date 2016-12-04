package com.example.matiasmsi.proyectoprueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by NoBuNaGa on 03/12/2016.
 */

public class Login extends AppCompatActivity  {
    Button btnlogin;
    EditText usr,psd;
    String usuario;
    String password;
    Boolean respuestaws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        btnlogin = (Button) findViewById(R.id.btnlogin);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = usr.getText().toString();
                password = psd.getText().toString();
                if (respuestaws.equals("True")){
                    Toast.makeText(getApplicationContext(),"Login exitoso", Toast.LENGTH_LONG);
                    Intent myintent = new Intent(Login.this,
                            MainActivity.class);
                    startActivity(myintent);
                }

            }
        });

        }


   





}
