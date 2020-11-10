package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckUsername extends AppCompatActivity {
    EditText edt_username;
    Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_username);
        edt_username= (EditText)findViewById(R.id.edt_usuario);
        btn_check=(Button)findViewById(R.id.btn_verificar);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edt_username.getText().toString();
                Response.Listener<String> respoListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean succes = jsonResponse.getBoolean("succes");
                            if(succes){

                                Intent intent = new Intent(CheckUsername.this,ChangePassword.class);
                                intent.putExtra("username", username);
                                CheckUsername.this.startActivity(intent);


                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(CheckUsername.this);
                                builder.setMessage("usuaio no econtrado")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                CheckRequest checkRequest = new CheckRequest(username, respoListener);
                RequestQueue queue = Volley.newRequestQueue(CheckUsername.this);
                queue.add(checkRequest);
            }
        });
    }
}