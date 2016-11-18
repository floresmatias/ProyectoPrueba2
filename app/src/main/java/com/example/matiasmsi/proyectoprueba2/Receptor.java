package com.example.matiasmsi.proyectoprueba2;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.value;

/**
 * Created by MatiasMSI on 09/11/2016.
 */

public class Receptor extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        ListView listView;
        String[] obras = {"Obra1", "Obra2", "Obra3", "Obra4", "Obra5","Obra6"};


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistanet);

        listView = (ListView) findViewById(R.id.listanet);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, obras);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Formulario.class);
                startActivity(intent);


            }
        });


    }



    public Integer ID_REG;
    public String INSPECTOR;
    public String OBRA;
    public String SECTOR;
    public String SUBSECTOR;
    public Integer TIPOFORMULARIO;
    public Integer Estaddo;

    public Receptor(Integer ID_REG, String INSPECTOR, String OBRA, String SECTOR, String SUBSECTOR,Integer TIPOFORMULARIO, Integer estaddo) {
        this.ID_REG = ID_REG;
        this.INSPECTOR = INSPECTOR;
        this.OBRA = OBRA;
        this.SECTOR = SECTOR;
        this.SUBSECTOR = SUBSECTOR;
        this.TIPOFORMULARIO = TIPOFORMULARIO;
        this.Estaddo = estaddo;
    }


    public Receptor() {
    }

    public int Id_reg() {
        return ID_REG;
    }

    public String toString() {
        return INSPECTOR;
    }

    public String toString1() {
        return OBRA;
    }

    public String toString2() {
        return SECTOR;
    }

    public String toString4() {
        return SUBSECTOR;
    }
    public int Id_TipoFormulario(){
        return TIPOFORMULARIO;
    }

    public int Id_Estado() {
        return Estaddo;
    }

    public ArrayList ConsulaTareas() {

         final ArrayList lista = new ArrayList();


                String NAMESPACE = "http://tempuri.org/";
                String URL = "http://172.18.19.253/wsservice/Service.asmx";
                String METHOD_NAME = "INS_REPORTE_PUNTO_WEB";
                String SOAP_ACTION = "http://tempuri.org/INS_REPORTE_PUNTO_WEB";

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;

                envelope.setOutputSoapObject(request);

                HttpTransportSE transporte = new HttpTransportSE(URL);

                try {
                    transporte.call(SOAP_ACTION, envelope);
                    SoapObject resSoap = (SoapObject) envelope.getResponse();
                    int nPropiedades = resSoap.getPropertyCount();
                    ID_REG=1;
                    INSPECTOR="Curbis";
                    OBRA="Curbis";
                    SECTOR="";
                    for (int i = 0; i < nPropiedades; i++) {
                        SoapObject ic = (SoapObject) resSoap.getProperty(i);
                        lista.add(new Receptor(
                                Integer.parseInt(ic.getProperty("ID_REG").toString()),
                                ic.getProperty("INSPECTOR").toString(),
                                ic.getProperty("OBRA").toString(),
                                ic.getProperty("SECTOR").toString(),
                                ic.getProperty("SUBSECTOR").toString(),
                                Integer.parseInt(ic.getProperty("TIPOFORMULARIO").toString()),
                                Integer.parseInt(ic.getProperty("ESTADO").toString())));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return lista;


            }


}
