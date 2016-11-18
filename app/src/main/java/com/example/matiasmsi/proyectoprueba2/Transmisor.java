package com.example.matiasmsi.proyectoprueba2;

import android.widget.ArrayAdapter;
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

        @Override
        public void run() {
            String NAMESPACE = "http://tempuri.org/";
            String URL = "http://localhost/wsservice/Service.asmx";
            String METHOD_NAME = "TX_MOBILE";
            String SOAP_ACTION = "http://tempuri.org/TX_MOBILE";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            //request.addProperty("",value);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapObject resSoap = (SoapObject) envelope.getResponse();
                int nPropiedades = resSoap.getPropertyCount();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
