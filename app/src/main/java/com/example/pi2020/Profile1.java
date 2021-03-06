package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile1 extends AppCompatActivity {
    String usernameP, usernamep2,name,pass,nomCultivo;
    EditText edt_name,edt_usu,edt_pass;
    ImageButton btn_settings,btn_addcrop2,btn_weather;
    Button btn_edi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        edt_name=(EditText)findViewById(R.id.etNombre1);
        edt_usu=(EditText)findViewById(R.id.etCorreo1);
        edt_pass=(EditText)findViewById(R.id.etClave1);
        btn_settings=(ImageButton)findViewById(R.id.btnSettings);
        btn_edi=(Button)findViewById(R.id.btnEditar);
        btn_addcrop2=(ImageButton)findViewById(R.id.btn_addcrop2);
        btn_weather=(ImageButton)findViewById(R.id.btn_weather);










        Bundle bundle= this.getIntent().getExtras();
       usernameP= bundle.getString("usernameP");
       nomCultivo=bundle.getString("nomCultivo");







        btn_edi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String pass= edt_pass.getText().toString();

                Intent intent= new Intent(Profile1.this,Edit_profile.class);
              intent.putExtra("usernameP",usernameP);
              intent.putExtra("pass",pass);
                Profile1.this.startActivity(intent);
            }
        });

        Response.Listener<String> respoListener = new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    boolean succes= jsonObject.getBoolean("succes");

                    if(succes){
                        usernameP= jsonObject.getString("username");
                        name=jsonObject.getString("name");
                        pass= jsonObject.getString("contraseña");

                        edt_name.setText(name);
                        edt_usu.setText(usernameP);
                        edt_pass.setText(pass);



                    }else{

                        AlertDialog.Builder builder= new AlertDialog.Builder(Profile1.this);
                        builder.setMessage("error Login")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ProfileRequest profileRequest= new ProfileRequest(usernameP, respoListener);
        RequestQueue queue = Volley.newRequestQueue(Profile1.this);
        queue.add(profileRequest);

        btn_addcrop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Profile1.this,AddCrop.class);
                intent.putExtra("usernameP",usernameP);
                intent.putExtra("nomCultivo",nomCultivo);
                Profile1.this.startActivity(intent);
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Profile1.this,Get_weather.class);
                intent.putExtra("usernameP",usernameP);
                intent.putExtra("nomCultivo",nomCultivo);
                Profile1.this.startActivity(intent);
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Profile1.this,Settings.class);
                intent.putExtra("usernameP",usernameP);
                Profile1.this.startActivity(intent);
            }
        });

    }
}