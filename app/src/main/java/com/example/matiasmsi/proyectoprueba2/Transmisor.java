package com.example.matiasmsi.proyectoprueba2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;


import java.io.IOException;
import java.util.Arrays;

import static android.R.attr.value;


/**
 * Created by MatiasMSI on 18/11/2016.
 */

public class Transmisor {

    //Formulario ok = new Formulario();
    //Formulario form = new Formulario();
    //prueba


    Transmisor.TareaInsertar tareaInsertar = new Transmisor.TareaInsertar();

    public TareaInsertar getTareaInsertar() {
        Log.d("hola","estoy en get");
        return tareaInsertar;
    }

    //@Override
       public class TareaInsertar extends AsyncTask<String,Integer,Boolean> {



            @Override
            protected Boolean doInBackground(String... strings) {
                boolean resul = true;
                Log.d("hola","Estoy en doing");

                final String NAMESPACE = "http://tempuri.org/";
                final String URL = "http://181.73.38.61/WSivan2/Service.asmx";
                final String METHOD_NAME = "TX_MOBILE";
                final String SOAP_ACTION = "http://tempuri.org/TX_MOBILE";


                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("CADENA","null");



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
            protected void onPostExecute(Boolean result){

                if (result){
                }
            }


            }
        }
           // Log.d("hola","estoy en transmisor");


