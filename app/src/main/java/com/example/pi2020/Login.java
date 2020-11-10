package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    EditText edt_usuario,edt_pass;
    Button btn_login, btnRegistro, tv_recContraseña;
    ImageButton btn_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_usuario=(EditText)findViewById(R.id.TV_usu);
        edt_pass=(EditText)findViewById(R.id.TV_pas);
        tv_recContraseña= findViewById(R.id.rec_contraseña) ;

        btn_login = findViewById(R.id.Btn_iniciar);
        btn_volver = findViewById(R.id.btn_volver1);
        btnRegistro = findViewById(R.id.btn_registrar);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Login.this,MainActivity.class);
                Login.this.startActivity(intentReg);
            }
        });

        tv_recContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this, CheckUsername.class);
                Login.this.startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username= edt_usuario.getText().toString();
                String password= edt_pass.getText().toString();

                Response.Listener<String> respoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);

                            boolean succes = jsonResponse.getBoolean("succes");
                            if(succes){
                             String namCulture= jsonResponse.getString("cultivo");
                             Intent intent= new Intent(Login.this,AddCrop.class);
                             intent.putExtra("namCulture",namCulture);
                             intent.putExtra("usernameP",username);

                              Login.this.startActivity(intent);



                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(Login.this);
                                builder.setMessage("error registro")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest= new LoginRequest(username,password,respoListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(loginRequest);

            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

    }
}

