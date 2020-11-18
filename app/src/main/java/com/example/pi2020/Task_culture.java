package com.example.pi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Task_culture extends AppCompatActivity {
     TextView txt_title1,txt_consejoT;
     String consejo,title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_culture);

       txt_title1=(TextView)findViewById(R.id.txt_tittleT);
       txt_consejoT=(TextView)findViewById(R.id.txt_consejoT);

       Bundle bundle= this.getIntent().getExtras();
        title= bundle.getString("titleT");
        consejo= bundle.getString("consejoT");

        txt_title1.setText(title);
        txt_consejoT.setText(consejo);

    }
}