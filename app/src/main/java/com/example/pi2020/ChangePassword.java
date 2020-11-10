package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ChangePassword extends AppCompatActivity {
    EditText edt_pass,edt_pass2;
    Button btn_change;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        edt_pass=(EditText)findViewById(R.id.edt_pass);
        edt_pass2=(EditText)findViewById(R.id.edt_pass2);
        btn_change=(Button)findViewById(R.id.btn_cambiar);
        Bundle parameter= this.getIntent().getExtras();
        username= parameter.getString("username");






        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass= edt_pass.getText().toString();
                String pass2=edt_pass2.getText().toString();

                if(edt_pass.getText().toString().isEmpty()){
                    Toast.makeText(ChangePassword.this, "Campo vacio", Toast.LENGTH_LONG).show();

                }else if(edt_pass2.getText().toString().isEmpty()){
                    Toast.makeText(ChangePassword.this, "Campo vacio", Toast.LENGTH_LONG).show();

                }

                if(!pass.equals(pass2)){
                    Toast.makeText(ChangePassword.this, "Contraseñas diferentes", Toast.LENGTH_LONG).show();

                }else{

                    Response.Listener<String> respoListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse= new JSONObject(response);

                                boolean succes = jsonResponse.getBoolean("succes");
                                if(succes){

                                    Intent intent= new Intent(ChangePassword.this, Login.class);
                                    ChangePassword.this.startActivity(intent);





                                }else{

                                    AlertDialog.Builder builder= new AlertDialog.Builder(ChangePassword.this);
                                    builder.setMessage("error")
                                            .setNegativeButton("Retry",null)
                                            .create().show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    ChangeRequest checkRequest = new ChangeRequest(username,edt_pass.getText().toString(), respoListener);
                    RequestQueue queue = Volley.newRequestQueue(ChangePassword.this);
                    queue.add(checkRequest);

                }
            }
        });


    }
}

