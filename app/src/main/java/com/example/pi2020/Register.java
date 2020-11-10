package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {
     EditText edt_name, edt_username, edt_password;
     Button btn_registar, btnLogin;
     ImageButton btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_password=(EditText)findViewById(R.id.edt_password);
        btn_volver= findViewById(R.id.btn_volver2);
        btn_registar=(Button)findViewById(R.id.btn_registrar);
        btnLogin = findViewById(R.id.btnLogin);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Register.this,MainActivity.class);
                Register.this.startActivity(intent);
            }
        });
        btn_registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edt_name.getText().toString();
                String username= edt_username.getText().toString();
                String password= edt_password.getText().toString();

                Response.Listener<String> respoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);

                            boolean succes = jsonResponse.getBoolean("succes");
                            if(succes){

                            Intent intent= new Intent(Register.this,Login.class);
                            Register.this.startActivity(intent);




                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(Register.this);
                                builder.setMessage("error registro")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest= new RegisterRequest(name,username,password,respoListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
}