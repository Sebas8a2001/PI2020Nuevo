package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Settings extends AppCompatActivity {
ImageButton btn_exit,btn_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btn_exit=(ImageButton)findViewById(R.id.btn_exit);
        btn_remove=(ImageButton)findViewById(R.id.btn_deleteC);
        Bundle bundle= this.getIntent().getExtras();
        final String username=bundle.getString("usernameP");

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Response.Listener<String> respoListener = new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            boolean succes= jsonObject.getBoolean("succes");

                            if(succes){
                                Intent intent= new Intent(Settings.this,Login.class);
                                Settings.this.startActivity(intent);




                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(Settings.this);
                                builder.setMessage("error Login")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                SettingsRequest settings= new SettingsRequest(username,respoListener);
                RequestQueue queue = Volley.newRequestQueue(Settings.this);
                queue.add(settings);
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Settings.this,Login.class);
                Settings.this.startActivity(intent);
            }
        });




    }
}