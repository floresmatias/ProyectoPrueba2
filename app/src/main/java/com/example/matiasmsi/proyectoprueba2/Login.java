package com.example.matiasmsi.proyectoprueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
    String usuario;
    String password;
    Boolean respuestaws;
    @Override

    protected Boolean doInBackground(String... strings) {
        boolean resul = true;
        Log.d("hola","Estoy en doing");

        final String NAMESPACE = "http://tempuri.org/";
        final String URL = "http://181.73.38.61/WSivan2/Service.asmx";
        final String METHOD_NAME = "TX_MOBILE";
        final String SOAP_ACTION = "http://tempuri.org/TX_MOBILE";


        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("CADENA","usuario = usr.getText().toString();");
        request.addProperty("CADENA","password = psd.getText().toString();");



        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE transporte = new HttpTransportSE(URL);

        try {
            Log.d("hola","Estoy en el try");
            transporte.call(SOAP_ACTION, envelope);
            SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
            String res=resultado_xml.toString();

            if(!res.equalsIgnoreCase("1")) {
                resul=false;


            }else {
                Log.d("hola","Estamos mal con el resultado del ws");

            }

        } catch (Exception e) {
            Log.d("hola","Estoy en el catch y el error es="+e.toString());
            resul= false;
        }
        return resul;


    }
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
