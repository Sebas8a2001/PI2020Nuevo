package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Advice2 extends AppCompatActivity {
String title, consejo;
TextView txt_title,txt_consejo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice2);
        txt_title= (TextView)findViewById(R.id.txt_titulo2);
        txt_consejo=(TextView)findViewById(R.id.txt_consejo1);
        Bundle bundle= this.getIntent().getExtras();
        title= bundle.getString("title");
        consejo= bundle.getString("consejo");

        txt_title.setText(title);
        txt_consejo.setText(consejo);
    }
}