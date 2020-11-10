package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class SelectDate extends AppCompatActivity  {
    Button btn_calendario,btn_save;
    EditText edt_nameCult;
    TextView txt_fecha;
    int day,month,year;
    String usernameP,date,cultivo,nomCultivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);

        btn_calendario=(Button)findViewById(R.id.btn_calen);
        btn_save=(Button)findViewById(R.id.btn_save);
        edt_nameCult=(EditText)findViewById(R.id.edt_nomCult);
        txt_fecha=(TextView)findViewById(R.id.txt_fecha);
        Bundle parameter= this.getIntent().getExtras();
        usernameP= parameter.getString("usernameP");
        cultivo= parameter.getString("nomCultivo");


        btn_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c=Calendar.getInstance();

                day=c.get(Calendar.DAY_OF_MONTH);
                month=c.get(Calendar.MONTH);
                year=c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog= new DatePickerDialog(SelectDate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        txt_fecha.setText(day+"/"+(month+1)+"/"+year);
                        date= txt_fecha.getText().toString();
                    }
                }
                        ,day,month,year);
                datePickerDialog.show();
            }


        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomCultivo= edt_nameCult.getText().toString();

                Response.Listener<String> respoListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);

                            boolean succes = jsonResponse.getBoolean("succes");
                            if(succes){






                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(SelectDate.this);
                                builder.setMessage("error registro")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                CultureRequest cultureRequest= new CultureRequest(usernameP,cultivo,date, nomCultivo,respoListener);
                RequestQueue queue = Volley.newRequestQueue(SelectDate.this);
                queue.add(cultureRequest);

            }
        });



    }


}