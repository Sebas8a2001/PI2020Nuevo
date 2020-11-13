package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    TextView tv_recContraseña,txt_cul,txt_cul2;
    EditText edt_usuario,edt_pass;
    Button btn_login,btn_volver;
    String return1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_usuario=(EditText)findViewById(R.id.TV_usu);
        edt_pass=(EditText)findViewById(R.id.TV_pas);
        tv_recContraseña=(TextView)findViewById(R.id.rec_contraseña) ;


        btn_login=(Button)findViewById(R.id.Btn_iniciar);
        btn_volver=(Button)findViewById(R.id.btn_volver1);

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
                            JSONObject jsonObject= new JSONObject(response);
                            boolean succes= jsonObject.getBoolean("succes");
                            if((edt_usuario.getText().length()==0)||edt_pass.getText().length()==0){
                                succes=false;

                            }
                            if(succes){

                                String nomCul= jsonObject.getString("nomCultivo");
                                Intent intent= new Intent(Login.this,AddCrop.class);
                                intent.putExtra("usernameP",username);
                                intent.putExtra("nomCultivo",nomCul);
                                Login.this.startActivity(intent);



                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(Login.this);
                                builder.setMessage("error Login")
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

    }
}

