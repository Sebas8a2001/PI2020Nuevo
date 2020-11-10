package com.example.pi2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddCrop extends AppCompatActivity {
 Button btn_consejo1,btn_consejo2,btn_consejo3,btn_consejo4,btn_consejo5,btn_consejo6,btn_consejo7,btn_consejo8,btn_agregarC;
 String namCulture,usernameP;
 TextView txt_culture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);

        btn_consejo1=(Button)findViewById(R.id.button1);
        btn_consejo2=(Button)findViewById(R.id.button2);
        btn_consejo3=(Button)findViewById(R.id.button3);
        btn_consejo4=(Button)findViewById(R.id.button4);
        btn_consejo5=(Button)findViewById(R.id.button5);
        btn_consejo6=(Button)findViewById(R.id.button6);
        btn_consejo7=(Button)findViewById(R.id.button7);
        txt_culture=(TextView)findViewById(R.id.txt_response);
        btn_agregarC=(Button)findViewById(R.id.btn_agregarC);
        Bundle parameter= this.getIntent().getExtras();
        namCulture= parameter.getString("namCulture");
        usernameP= parameter.getString("usernameP");

        if(namCulture.equals("null")){
            namCulture="Sin cultivos";

        }

        txt_culture.setText(namCulture);



        btn_consejo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "Es importante no querer abarcar todas las hortalizas desde el principio ya que no será efectivo. Lo importante es comenzar con una variedad menor y que luego, paulatinamente, incorporar otras plantas diferentesDe esta manera podrás controlar todos los cultivos y sacar el máximo potencial de cada hortaliza. Además, es necesario que a tu huerto le dé un mínimo de 5 horas diarias de sol para garantizar la efectividad del cultivo ya que, en caso de no tener una suficiente exposición al sol, no tendrán un buen desarrollo";
                String titulo="1.PLANTA CON MODERACIÓN";
                Intent intent= new Intent(AddCrop.this,Advice1.class);
                intent.putExtra("consejo", consejo);
                intent.putExtra("titulo",titulo);
                AddCrop.this.startActivity(intent);

            }
        });

        btn_consejo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consejo = "Para que un huerto tenga un buen resultado en primer lugar es tener un suelo en buenas condiciones. Por ejemplo, si el suelo está muy encharcado, se debe fresar la tierra para conseguir que no se acumule tanta agua. Por el contrario, si está muy seca, se fresará para conseguir acumular mayor cantidad de agua. En segundo lugar, también es importante suministrar el abono y el sustrato adecuado. Existen una gran variedad de opciones para conseguirlo, como es el caso del abono orgánico, que se puede conseguir en casa de forma rápida y fácil.";
                String titulo="2.POSEE UN TERRENO DE CALIDAD";
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
                String consejo = "Para asegurarse la calidad de tus hortalizas, el clima es uno de los factores más importantes en tu huerto. De hecho, si los cultivos son autóctonos, menor será la probabilidad de contraer enfermedades o plagas.\n" +
                        "\n" +
                        "Es importante saber el momento y el clima adecuado para cada una de ellas, teniendo siempre en cuenta qué hortalizas son propias de tu zona.\n" +
                        "\n" +
                        "Si en el lugar que tu vives existe un gran nivel de contaminación, la opción idónea es plantar aquellos alimentos que son menos propicios a la contaminación (zanahorias, cebolla, ajo, remolacha, etc.).\n" +
                        "Si el clima de tu zona es húmedo y frío, lo ideal es cultivar brócoli, col o guisante.\n" +
                        "Si el clima de tu zona es seco y caluroso podrás cultivar tomate, pimiento, calabacín, perejil o pepino. En este caso recuerda siempre suministrar el agua y el sustrato necesarios.";
                String titulo="4.PLANTA ACORDE AL CLIMA DE TU ZONA";
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