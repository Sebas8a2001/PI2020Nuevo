package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class SelectCulti extends AppCompatActivity {
    RadioButton rb_yuca,rb_maiz,rb_papa,rb_cilantro,rb_alberja,rb_lechuga,rb_cafe,rb_cebolla;
    Button btn_seleCul,btn_volver;
    String usernameP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_culti);
        rb_yuca=(RadioButton)findViewById(R.id.rb_yuca);
        rb_maiz=(RadioButton)findViewById(R.id.rb_maiz);
        rb_papa=(RadioButton)findViewById(R.id.rb_papa);
        rb_cilantro=(RadioButton)findViewById(R.id.rb_cilantro);
        rb_alberja=(RadioButton)findViewById(R.id.rb_alberja);
        rb_lechuga=(RadioButton)findViewById(R.id.rb_lechuga);
        rb_cafe=(RadioButton)findViewById(R.id.rb_cafe);
        rb_cebolla=(RadioButton)findViewById(R.id.rb_cebolla);
        btn_seleCul=(Button)findViewById(R.id.btn_selCult);
        Bundle parameter= this.getIntent().getExtras();
        usernameP= parameter.getString("usernameP");





        btn_seleCul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb_yuca.isChecked()==true){

                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Yuca");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_alberja.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Alberja");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_cafe.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Cafe");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_cebolla.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Cebolla");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_cilantro.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Cilantro");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_lechuga.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Lechuga");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_maiz.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Maiz");
                    SelectCulti.this.startActivity(intent);

                }else if(rb_papa.isChecked()==true){
                    Intent intent= new Intent(SelectCulti.this,SelectDate.class);
                    intent.putExtra("usernameP",usernameP);
                    intent.putExtra("nomCultivo","Papa");
                    SelectCulti.this.startActivity(intent);

                }
            }
        });

    }
}