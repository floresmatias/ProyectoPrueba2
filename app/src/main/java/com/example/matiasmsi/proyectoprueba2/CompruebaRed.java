package com.example.matiasmsi.proyectoprueba2;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * Created by MatiasMSI on 12/11/2016.
 */

public class CompruebaRed extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        Log.d("hola", "estoy en Comprueba red");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    Context context;
    boolean valor;


    public CompruebaRed(Context context) {
        this.context = context;
    }

    public boolean isConnected() {
        Log.d("hola","estoy en coneccion");
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if(info!=null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    Log.d("estado","conectado");
                    return true;


                }
            }
    }
        Log.d("estado","no conectado");

        return false;
        //84

    }

}
