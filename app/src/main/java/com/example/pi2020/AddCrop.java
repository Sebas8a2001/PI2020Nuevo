package com.example.pi2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddCrop extends AppCompatActivity {
 CardView btn_consejo1,btn_consejo2,btn_consejo3,btn_consejo4,btn_consejo5,btn_consejo6,btn_consejo7,btn_consejo8;
 Button btn_agregarC;
 String namCulture,usernameP;
 TextView txt_culture,txt_cul1,txt_cul2,txt_cul3,txt_cul4,txt_cul5,txt_cul6,txt_cul7,txt_cul8,txt_cul9,txt_cul10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);



        txt_cul1=(TextView)findViewById(R.id.txt_cul1);
        txt_cul2=(TextView)findViewById(R.id.txt_cul2);
        txt_cul3=(TextView)findViewById(R.id.txt_cul3);
        txt_cul4=(TextView)findViewById(R.id.txt_cul4);
        txt_cul5=(TextView)findViewById(R.id.txt_cul5);
        txt_cul6=(TextView)findViewById(R.id.txt_cul6);
        txt_cul7=(TextView)findViewById(R.id.txt_cul7);
        txt_cul8=(TextView)findViewById(R.id.txt_cul8);
        txt_cul9=(TextView)findViewById(R.id.txt_cul9);
        txt_cul10=(TextView)findViewById(R.id.txt_cul10);


        btn_consejo1=findViewById(R.id.button1);
        btn_consejo2=findViewById(R.id.button2);
        btn_consejo3=findViewById(R.id.button3);
        btn_consejo4=findViewById(R.id.button4);
        btn_consejo5=findViewById(R.id.button5);
        btn_consejo6=findViewById(R.id.button6);
        btn_consejo7=findViewById(R.id.button7);


        btn_agregarC=(Button)findViewById(R.id.btn_agregarC);
        Bundle parameter= this.getIntent().getExtras();
         namCulture= parameter.getString("nomCultivo");

        usernameP= parameter.getString("usernameP");


        Response.Listener<JSONArray> respoListener = new Response.Listener<JSONArray>() {
        public void onResponse(JSONArray response) {
            JSONObject jsonObject=null;

            for (int i=0;i<response.length();i++) {

                try {
                    jsonObject=response.getJSONObject(i);
                    if(txt_cul1.getText().length()==0) {

                        txt_cul1.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul1.getText().toString();

                        txt_cul1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });



                    }else if(txt_cul2.getText().length()==0){

                        txt_cul2.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul2.getText().toString();

                        txt_cul2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });


                    }else if(txt_cul3.getText().length()==0){

                        txt_cul3.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul3.getText().toString();

                        txt_cul3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);

                            }
                        });


                    }else if(txt_cul4.getText().length()==0){

                        txt_cul4.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul4.getText().toString();

                        txt_cul4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });
                    }else if(txt_cul5.getText().length()==0){
                        txt_cul5.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul5.getText().toString();

                        txt_cul5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });

                    }else if(txt_cul6.getText().length()==0){
                        txt_cul6.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul6.getText().toString();

                        txt_cul6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });


                    }else if(txt_cul7.getText().length()==0){
                        txt_cul7.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul7.getText().toString();

                        txt_cul7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });

                    }else if(txt_cul8.getText().length()==0){
                        txt_cul8.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul8.getText().toString();

                        txt_cul8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });


                    }else if(txt_cul9.getText().length()==0){
                        txt_cul9.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul9.getText().toString();

                        txt_cul9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });


                    }else if(txt_cul10.getText().length()==0){
                        txt_cul10.setText(jsonObject.getString("cultivo"));
                        final String nomc= jsonObject.getString("nomcultivo");
                        final String cul=txt_cul10.getText().toString();

                        txt_cul10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent= new Intent(AddCrop.this, Culture.class);
                                intent.putExtra("nomCultivo",nomc);
                                intent.putExtra("cultivo",cul);
                                AddCrop.this.startActivity(intent);
                            }
                        });


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };
        AddCropRequest addCropRequest= new AddCropRequest(usernameP,respoListener);
        RequestQueue queue = Volley.newRequestQueue(AddCrop.this);
        queue.add(addCropRequest);






        btn_consejo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "La primera operación que hay que realizar para asegurarse que un cultivo pueda alcanzar el mejor rendimiento, es proporcionar a las plantas un suelo en las mejores condiciones. El objetivo es preparar un lecho con los nutrientes adecuados y con unas condiciones que permitan la germinación de la semilla y el establecimiento del cultivo para su posterior desarrollo. Esto se ha venido haciendo mediante técnicas agresivas tradicionalmente, como el volteo, la quema de rastrojo, etc. Estas, además de no ser sostenibles a largo plazo, requieren mano de obra, especialmente en contextos con una baja mecanización, convirtiéndose en una carga para los pequeños agricultores que han de preparar el terreno con herramientas básicas y de forma manual.";
                String titulo="1.Preparación del terreno";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);

            }
        });

        btn_consejo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "Entre las numerosas labores que determinan el rendimiento de un cultivo, la siembra y escarda son de las principales. Unas dosis de siembra adecuadas, con marcos de siembra correctos son cruciales para el desarrollo de la planta. Esto también está relacionado con las condiciones del suelo y el sistema de cultivo. De la siembra a voleo hasta la siembra de precisión neumática, hay toda una gama de herramientas y equipos que pueden mejorar las operaciones de siembra a la vez que se adaptan al contexto económico, social y ambiental del agricultor";
                String titulo="2.Operaciones de cultivo";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);

            }
        });

        btn_consejo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "Cuando creamos un huerto, existe una serie de herramientas que son necesarias para facilitar la actividad. Algunas de esas herramientas son: " +
                        "Pala pequeña\n" +
                        "Escarificador pequeño\n" +
                        "Azadilla pequeña\n" +
                        "Saco para desechos\n" +
                        "Guantes de jardinería\n" +
                        "Motoazada\n" +
                        "Herramientas de riego (pistola de riego, manguera, etc.)";
                String titulo="3.TEN A MANO LAS HERRAMIENTAS" +
                        " ADECUADAS";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);
            }
        });

        btn_consejo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "La escarda o eliminación de malas hierbas usando herramientas convencionales como una azada de mano, puede llevar 140 horas por persona y hectária (que disminuye hasta 65 horas por hectária en la tercera escarda). Las malas hierbas se eliminan en momentos críticos para evitar su establecimiento y que dañen al cultivo. Una escarda tardía del cultivo anterior se ha de hacer para evitar que sus semillas permanezcan. El uso de herramientas adecuadas y de un equipo correcto, pueden contribuir a hacer esta labor más rápido y con menos mano de obra, mejorando la calidad de vida del agricultor y la eficiencia de su trabajo. Hay dos modos de control de las malas hierbas: mecánico o químico. Para la opción mecánica, el objetivo es erradicar la planta y para la química es matarla mediante un agente químico de acción selectiva, que normalmente se aplican mediante pulverización.";
                String titulo="4.Escarda";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);
            }
        });

        btn_consejo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "El huerto tiene unas dimensiones limitadas, y las hortalizas necesitan su espacio. Por ello, debemos tener en cuenta que no se puede abarcar una gran multitud de cultivos y sobre todo de la misma familia, pues competirían entre sí por los mismos nutrientes y no conseguiríamos una buena cosecha.\n" +
                        "\n" +
                        "Una posible solución es asociar cultivos sembrando plantas que se complementen entre sí, de tal manera que se ayuden a crecer y desarrollarse. De lo contrario, existiría la posibilidad de que aquellas hortalizas que son de la misma familia compitan y, como consecuencia, no conseguir un huerto sano y productivo.";
                String titulo="5.DALES ESPACIO A TUS CULTIVOS";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);
            }
        });

        btn_consejo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "Es tan importante los demás consejos como saber exactamente cuánto y cuándo regar los cultivos. El por qué es sencillo: tan malo es no regar lo suficiente como regar más de lo necesario.\n" +
                        "\n" +
                        "Para evitarlo, la mejor opción es hacer uso responsable del agua. ¿Cómo? Cultivar juntas plantas que necesitan riegos similares. De este modo, no tendrás plantas que necesiten un riego diario al lado de plantas que necesiten un riego menos frecuente.\n" +
                        "\n" +
                        "Además, siempre es importante regar las plantas por el atardecer para evitar que el agua se evapore con el sol y pueda impregnarse con la tierra.";
                String titulo="6.RIEGA CUANDO SEA NECESARIO";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);

            }
        });

        btn_consejo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "Por último, cuando cultivamos hortalizas u otras plantas, siempre estamos expuestos a la posibilidad de recibir plagas o enfermedades que debiliten y estropeen nuestro cultivo. Y como más vale prevenir que curar, es importante saber cómo anticiparse a ellas.\n" +
                        "\n" +
                        "Una muy buena opción es tener plantas que previenen las plagas y no perjudican a nuestro cultivo. Además, los insectos como, por ejemplo, las Catarinas y las abejas, son amigos de las plantas, por lo que traerán beneficios para ellas.\n" +
                        "\n" +
                        "Pon cerca de tus cultivos plantas que atraigan a estos insectos como las margaritas o los geranios";
                String titulo="7.CUIDADO CON LAS PLAGAS O ENFERMEDADES";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);
            }
        });

        btn_agregarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AddCrop.this,SelectCulti.class);
                intent.putExtra("usernameP",usernameP);
                AddCrop.this.startActivity(intent);
            }
        });



    }





}