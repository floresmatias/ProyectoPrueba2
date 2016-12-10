package com.example.matiasmsi.proyectoprueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by NoBuNaGa on 03/12/2016.
 */
//asdasd

public class Login extends AppCompatActivity  {
    Button btnlogin;
    EditText usr,psd;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.login);

        _("LoginActivity born");

        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String username = usr.getText()+"";
                String pasword = psd.getText()+"";


                if(username.length()== 0 || pasword.length()== 0){
                    Toast.makeText(Login.this,"Favor llenar campos usuario y contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }

            }


        });


    }




}
