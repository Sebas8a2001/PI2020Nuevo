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

public class Edit_profile extends AppCompatActivity {
      EditText edt_namep,edt_usuP,edt_passA,edt_passN,edt_passN2;
      String usernameP,pass;
      Button btn_save1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edt_namep=(EditText)findViewById(R.id.edt_nameP);
        edt_usuP=(EditText)findViewById(R.id.edt_usP);
        edt_passA=(EditText)findViewById(R.id.edt_passA);
        edt_passN=(EditText)findViewById(R.id.edt_passN);
        edt_passN2=(EditText)findViewById(R.id.edt_passN2);
        btn_save1=(Button)findViewById(R.id.btn_save1);
        Bundle bundle= this.getIntent().getExtras();
        usernameP= bundle.getString("usernameP");
        pass=bundle.getString("pass");


        btn_save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=edt_namep.getText().toString();
                final String username=edt_usuP.getText().toString();
                final String passA=edt_passA.getText().toString();
                final String passN=edt_passN.getText().toString();
                final String passN2=edt_passN2.getText().toString();


                if(edt_namep.getText().toString().isEmpty()){
                    Toast.makeText(Edit_profile.this, "Campo vacio", Toast.LENGTH_LONG).show();
                }else if(edt_usuP.getText().toString().isEmpty()){
                    Toast.makeText(Edit_profile.this, "Campo vacio", Toast.LENGTH_LONG).show();
                }else if(edt_passA.getText().toString().isEmpty()){
                    Toast.makeText(Edit_profile.this, "Campo vacio", Toast.LENGTH_LONG).show();
                }else if(edt_passN.getText().toString().isEmpty()){
                    Toast.makeText(Edit_profile.this, "Campo vacio", Toast.LENGTH_LONG).show();
                }else if(edt_passN2.getText().toString().isEmpty()){
                    Toast.makeText(Edit_profile.this, "Campo vacio", Toast.LENGTH_LONG).show();
                }

                if(!passN.equals(passN2)){
                    Toast.makeText(Edit_profile.this, "Contraseñas diferentes", Toast.LENGTH_LONG).show();

                }else{
                    Response.Listener<String> respoListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse= new JSONObject(response);

                                boolean succes = jsonResponse.getBoolean("succes");
                                if(succes){
                                    Intent intent= new Intent(Edit_profile.this,Profile1.class);
                                    intent.putExtra("usernameP",username);
                                    Edit_profile.this.startActivity(intent);





                                }else{

                                    AlertDialog.Builder builder= new AlertDialog.Builder(Edit_profile.this);
                                    builder.setMessage("jujuj")
                                            .setNegativeButton("Retry",null)
                                            .create().show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    EditRequest editRequest = new EditRequest(name,username,passN,usernameP, pass,respoListener);
                    RequestQueue queue = Volley.newRequestQueue(Edit_profile.this);
                    queue.add(editRequest);


                }

            }
        });
    }
}