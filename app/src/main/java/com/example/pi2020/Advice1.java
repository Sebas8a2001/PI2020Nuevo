package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Advice1 extends AppCompatActivity {
String consejo,titulo;
TextView txt_consejo, txt_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice1);

        Bundle bundle= this.getIntent().getExtras();
        consejo= bundle.getString("consejo");
        titulo=bundle.getString("titulo");
        txt_consejo=(TextView)findViewById(R.id.txt_consejo);
        txt_titulo=(TextView)findViewById(R.id.txt_titulo);

        txt_consejo.setText(consejo);
        txt_titulo.setText(titulo);

    }
}