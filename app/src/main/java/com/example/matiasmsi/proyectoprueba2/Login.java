package com.example.matiasmsi.proyectoprueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

/**
 * Created by NoBuNaGa on 03/12/2016.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btnlogin;
    EditText usr,psd;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        btnlogin = (Button) findViewById(R.id.btnlogin);

    }



    @Override
    public void onClick(View view) {

    }
}
