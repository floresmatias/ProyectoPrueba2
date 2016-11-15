package com.example.matiasmsi.proyectoprueba2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import static android.R.attr.value;

/**
 * Created by MatiasMSI on 09/11/2016.
 */

public class Receptor extends Activity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
    }



    public  void EnviarOnclic(View v){
        Thread thread = new Thread(){
         String res;
         @Override
         public void run(){
             String NAMESPACE="http://tempuri.org/";
             String URL= "http://ww2.qanalytics.cl/gps_migps/service.asmx";
             String METHOD_NAME="WM_INS_REPORTE";
             String SOAP_ACTION ="http://tempuri.org/WM_INS_REPORTE";

             SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
             request.addProperty("",value);

             SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
             envelope.dotNet=true;

             envelope.setOutputSoapObject(request);

             HttpTransportSE transporte = new HttpTransportSE(URL);

             try {
                 transporte.call(SOAP_ACTION,envelope);
                 SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
                 res = resultado_xml.toString();
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (XmlPullParserException e) {
                 e.printStackTrace();
             }
             runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     Toast.makeText(Receptor.this,res,Toast.LENGTH_SHORT).show();

                 }
             });
         }


        };
        thread.start();

    }
}
