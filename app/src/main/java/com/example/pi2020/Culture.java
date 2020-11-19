package com.example.pi2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Culture extends AppCompatActivity {
 String cultivo, nomCultivo,title,consejo;
 TextView txt_nomCultivo;
 Button btn_cs1,btn_cs2,btn_cs3,btn_cs4,btn_task1,btn_task2,btn_task3,btn_galle,btn_clima;
 ImageView img;
 ImageButton im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture);


        Bundle bundle= this.getIntent().getExtras();
        cultivo= bundle.getString("cultivo");
        nomCultivo= bundle.getString("nomCultivo");
        txt_nomCultivo= (TextView)findViewById(R.id.txt_nom2Cult);
        btn_galle=(Button)findViewById(R.id.btn_galle);
        btn_cs1=(Button) findViewById(R.id.btn_cs1);
        btn_cs2=(Button)findViewById(R.id.btn_cs2);
        btn_cs3=(Button)findViewById(R.id.btn_cs3);
        btn_cs4=(Button)findViewById(R.id.btn_cs4);
        btn_task1=(Button)findViewById(R.id.task1);
        btn_task2=(Button)findViewById(R.id.task2);
        btn_task3=(Button)findViewById(R.id.task3);
        img=(ImageView)findViewById(R.id.imageView);




        if (ContextCompat.checkSelfPermission(Culture.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Culture.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Culture.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        btn_galle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                intent.setType("image/*");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


            txt_nomCultivo.setText(nomCultivo);

        btn_task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Culture.this,Task_culture.class);
               String titleT="REGAR";
               String consejoT="VERANO: de 2 a 3 veces al día, debiendo ser el más abundante el realizado al atardecer, para evitar pérdidas de agua innecesarias en las horas de más sol, además de posibles quemaduras en las hojas (en el caso de que realices el riego por aspersión).\n" +
                               "\nINVIERNO: una vez al día, de forma poco cuantiosa, y realizándolo preferiblemente al amanecer, para evitar posibles heladas \n"+
                                "\n¿QUÉ RIEGOS USAR EN LOS CULTIVOS?\n" +
                       "Igualmente, también es importante conocer los sistemas de riego que podemos aplicar en una explotación, tanto a la hora de proporcionarle el agua necesaria como de aplicar los correspondientes tratamientos.\n" +
                       "\n" +
                       "EL RIEGO POR GOTEO\n" +
                       "Permite que el agua se infiltre directamente en el suelo llegando a la zona de influencia radicular a través de un sistema de tuberías e irrigadores.\n" +
                       "\n" +
                       "EL SISTEMA HIDROPÓNICO\n" +
                       "Posibilita que las raíces de las plantas reciban directamente el agua, con sus correspondientes tratamientos \n"+
                       "\n" +
                       "EL RIEGO POR ASPERSIÓN\n" +
                       "Es el más adecuado para hacer un reparto homogéneo del agua teniendo en cuenta el clima y las necesidades de cada cultivo. Puede realizarse incluso con microaspersores para conseguir gotas muy finas que se distribuyan todavía mejor.\n" +
                       "\n" +
                       "RIEGO POR NEBULIZACIÓN\n" +
                       "Produce una niebla fina al trabajar con presiones relativamente elevadas.\n" +
                       "\n" +
                       "Aplicar el sistema de riego más adecuado para las características de cada explotación también nos resultar de ayuda a la hora de prevenir la aplicación de un exceso de fertilizante.";
               intent.putExtra("titleT",titleT);
               intent.putExtra("consejoT",consejoT);
               Culture.this.startActivity(intent);



            }
        });


        btn_task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Culture.this,Task_culture.class);
                String titleT="LIMPIEZA DEL AREA DE CULTIVO";
                String consejoT="• ARADO\n" +
                        "Consiste en voltear la parte superficial del suelo a profundidades que varían hasta los 45 cm. Se puede voltear el suelo o removerse, dependiendo del implemento que se utilice. Generalmente se usa el arado de vertedera o de discos. Esta práctica debe hacerla cuando el suelo tiene todavía más del 30% de humedad. Con la aradura se ayuda a incorporarrastrojos de cultivos anteriores, se destruye malezas, se expone plagas de suelo a los rayos solares y a los enemigos naturales.\n" +
                        "\n" +
                        "• RASTREO\n" +
                        "Esta práctica persigue pulverizar los terrones que han quedado después de la aradura, ésta debe realizarse cuando el suelo tenga la suficiente humedad que permita que los terrones se desmenucen. Se puede utilizar rastra pesada y rastra pulidora. El número depasadas depende del tamaño de los terrones y el mullido que se quiera dejar, pero se recomienda dejar lo más mullido que se pueda, porque de esta labor depende mucho la calidad de la cama y la eficiencia en el trasplante. Antes del último paso de rastra esta se aprovecha para incorporar las enmiendas de cal y las aportaciones de materia orgánica que se hagan en el terreno\n" +
                        "\n" +
                        "\n" +
                        "• OTRAS LABORES DE PREPARACION\n" +
                        "Además de las labores antes mencionadas, cuando se tienen terrenos con pendientes, es necesario sembrar en curvas a nivel para evitar erosión del terreno, y cuando se tienen terrenos con problemas de inundación o terrenos no nivelados, es necesario hacer un sistema de drenajes que incluyan los drenes interiores y drenes recolectores, para evitar anegamientos dentro del cultivo.";
                intent.putExtra("consejoT",consejoT);
                intent.putExtra("titleT",titleT);
                Culture.this.startActivity(intent);
            }
        });

        btn_task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Culture.this,Task_culture.class);
                String titleT="APLICAR FERTILIZANTES";
                String consejoT="Cobertura total: los fertilizantes se aplican de manera uniforme en toda la superficie del suelo.\n" +
                        "\n" +
                        "En bandas: se realizan aplicaciones en bandas antes de la plantación o siembra cerca del lugar donde serán colocadas las semillas o plántulas.\n" +
                        "\n" +
                        "Al decidir aplicar en bandas se deben tomar en cuenta las siguientes consideraciones:\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "El suelo: suelos arenosos retienen menor cantidad de nutrientes que aquellos de textura fina. Es por esto que se recomienda aplicar menor cantidad de fertilizantes, pero con mayor frecuencia.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Clima: las precipitaciones incrementan el riesgo de lixiviación del nitrógeno y climas cálidos pérdidas por volatilización.";
                intent.putExtra("consejoT",consejoT);
                intent.putExtra("titleT",titleT);
                Culture.this.startActivity(intent);
            }
        });



        btn_cs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cultivo.equals("Alberja")){

                    consejo="El cultivo de arveja se desarrolla bien en los pisos térmicos fríos y medios con alturas sobre el nivel del mar entre 1.800 2.800 metros, temperatura promedio entre13°C y 18°C. Para el adecuado establecimiento del cultivo se recomienda terrenos con buen drenaje para evitar encharcamientos donde solo se desarrollan platas raquíticas con amarillamiento prematuro y poca capacidad de carga. El requerimiento hídrico es de 250 a 380 milímetros de agua con mayor demanda en las etapas de crecimiento y floración. Se requiere preferiblemente suelos sueltos, profundos, con buen contenido de materia orgánica y pH entre 5.5 y 6.8.";
                    title="1.Condiciones de clima y suelo";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);
                }else if(cultivo.equals("Yuca")){

                    consejo="Lo primero es preparar el terreno, si bien la yuca es una planta que se adapta a diversos tipos de suelos, es recomendable preparar el terreno con anterioridad (unos 20 días antes), removiendo la tierra y mezclándola con fertilizantes orgánicos o compost, también hay que eliminar las piedras y las malas hierbas presentes.\n" +
                            "\n" +
                            "De esta forma el terreno queda apto para la siembra, con un mejor drenaje, más profundo y suelo, además adquiere los nutrientes necesarios para el buen desarrollo de la planta.";
                    title="1.Preparación del terreno";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cafe")){
                    consejo="Un factor a tener en cuenta sobre cómo plantar café es el suelo o sustrato. Este debe proporcionar los nutrientes necesarios para el buen desarrollo del arbusto y que facilite el agarre de sus raíces. Estos suelos pueden ser preparados o mejorados mediante técnicas agronómicas de preparación con compost que harán que el suelo tenga el color apropiado y su tono oscuro que son los mejores para el café.\n" +
                            "\n" +
                            "El suelo para el café no debe ser demasiado ligero ni demasiado pesado. En lo que se refiere a cómo plantar café, un pH acido de entre 5 a 5,5 puede ser ideal para el cultivo del café, pero  esto depende de la variedad. La materia orgánica que el suelo debe tener es de por lo menos un 10% de materiales o residuos descompuestos muchas veces del mismo café como la pulpa.";
                    title="1.Sustrato o Suelo";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cebolla")){
                    consejo="Las cebollas necesitan suelos buenos y ricos para desarrollarse. Prefieren los suelos franco arenosos, la turba y el limo y rechazan los suelos arcillosos y arenosos.\n" +
                            "\n" +
                            "A las cebollas les gusta la abundancia de potasio y de fósforo pero no el exceso de nitrógeno. Es recomendable poner una buena capa superficial de compost maduro sobre el suelo donde vamos a plantar, ya sea en el huerto o en los maceteros. El Ph indicado del suelo para plantar cebollas es de 6.";
                    title="1.Tipo de Tierra";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cilantro")){
                    consejo="El cilantro prefiere un suelo liviano y bien drenado de arcilla o tierra arenosa que sea moderadamente fértil, pero puede tolerar muchos tipos de suelo, siempre y cuando los niveles de nutrientes y la humedad sean monitoreados.";
                    title="1.Preparación del suelo";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Lechuga")){
                    consejo="Los suelos preferidos por la lechuga son los ligeros, arenoso-limosos, con buen drenaje, situando el pH óptimo entre 6,7 y 7,4.\n" +
                            "En los suelos humíferos, la lechuga vegeta bien, pero si son excesivamente ácidos será necesario encalar.\n" +
                            "Este cultivo, en ningún caso admite la sequía, aunque la superficie del suelo es conveniente que esté seca para evitar en todo lo posible la aparición de podredumbres de cuello.\n" +
                            "\n" +
                            "-En cultivos de primavera, se recomiendan los suelos arenosos , pues se calientan más rápidamente y permiten cosechas más tempranas.\n" +
                            "-En cultivos de otoño, se recomiendan los suelos francos, ya que se enfrían más despacio que los suelos arenosos.\n" +
                            "-En cultivos de verano, es preferible los suelos ricos en materia orgánica, pues hay un mejor aprovechamiento de los recursos hídricos y el crecimiento de las plantas es más rápido";
                    title="1.Suelo";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Maiz")){
                    consejo="El maiz es sensible a las heladas, es un cultivo de clima templado-cálido, tampoco tolera exposiciones prolongadas a bajas temperaturas. La temperatura óptima del cultivo es entre 15° y 24°C con una máxima de 32°C y mínima de 10°C. Prefiere los suelos francos a franco-arcillosos por retener más la humedad, aunque se puede cultivar en una amplia gama de suelos salvo los que tengan problemas de salinidad o acidez. Responde muy bien a un suelo de elevada fertilidad por lo cual se aconseja que el maíz continúe en la rotación a la arveja o haba, debido al aporte de nitrógeno por simbiosis que dejan estos cultivos.";
                    title="1.Suelo y clima";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Papa")){
                    consejo="Las papas pueden crecer casi en todos los tipos de suelos, salvo donde son salinos o alcalinos. Los suelos naturalmente suelos, que ofrecen menos resistencia al crecimiento de los tubérculos, son los más convenientes, y los suelos arcillosos o de arena con arcilla y abundante materia orgánica, con buen drenaje y ventilación, son los mejores. Se considera ideal un pH de 5,2 a 6,4 en el suelo.\n" +
                            "\n" +
                            "El cultivo de papas requiere una gran preparación del suelo. Es necesario rastrillar el suelo hasta eliminar todas las raíces de la maleza. Por lo general es necesario arar tres veces, rastrillar con frecuencia y aplicar el rodillo, para que el suelo adquiera la condición adecuada: suave, bien drenado y bien ventilado.";
                    title="1.Suelo y la preparación de la tierra";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }



            }
        });


        btn_cs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cultivo.equals("Alberja")){

                    consejo="Para asegurar el máximo rendimiento en el cultivo es fundamental el uso de semilla certificada o seleccionada ofrecida por entidades como Fenalce  donde su proceso de producción es dirigido y supervisado por especialistas en semillas, no tiene mezclas de variedades ni elementos contaminantes y son tratadas para garantizar su conservación y evitar la presencia de plagas y enfermedades, de lo contrario, el uso de semillas de las siembras anteriores o mercado local siempre tendrá bajos rendimientos.";
                    title="2.Semilla y Siembra.";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);
                }else if(cultivo.equals("Yuca")){

                    consejo="Es recomendable realizar esta siembre por esqueje o por pedazos de tallo de la planta, los cuales deben cortarse el mismo día de la siembra y debes seleccionar tallos que tengan unos 7 brotes, del cual solo podemos seleccionar los 4 más cercanos a la base del tallo. Luego colocamos cada una de las 4 partes del tallo de forma vertical (esto favorece el crecimiento de la planta) y a una profundidad de unos 6 a 10 cm, además de colocar cada pedazo de tallo a una distancia de 1 metro entre cada una de las plantas.";
                    title="2.Sembrar la planta de yuca";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cafe")){
                    consejo="El café generalmente se trabaja con almácigos debido a que esto garantiza la germinación controlada de los plantones y luego se trasplanta en su lugar definitivo o productivo.\n" +
                            "\n" +
                            "Lo primero que debes hacer es llenar los almácigos con compost, que son semilleros donde se cuidan de manera cuidadosa las semillas y su crecimiento. Para esto se debe utilizar un compost totalmente nuevo para evitar ciertas enfermedades.\n" +
                            "Sebes mantener el riego diario del almácigo hasta que la planta germine. No debes usar agua en exceso ya que solo se realizar para mantener húmedo el sustrato. La germinación por lo general tarda entre unos 2 a 6 meses.";
                    title="2.Semilleros o almacigos";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cebolla")){
                    consejo="Plántulas: se siembra en febrero, en condiciones ambientales controladas (invernadero, dentro de casa, etc.), o bien en abril, cuando la temperatura sube, al aire libre. Se suelen dejar 25 cm entre hileras y 25 cm entre cebollas. En el caso de la siembra temprana, ya en el aire libre y no en interior como hemos comentado antes, se siembra a finales de marzo. \n"+
                            "\n" +
                            "Cebollas de invierno: hemos dicho al principio que había variedades tempranas y tardías. En este caso, la cebolla de invierno se siembra en la 2ª quincena de agosto (con el mismo marco de plantación).";
                    title="2.Fechas para cultivar cebolla";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cilantro")){
                    consejo="El cilantro es un cultivo de temporada fría que se da mejor a temperaturas de entre 50 y 85 grados F. Puede tolerar temperaturas tan bajas como 10 grados F, pero si las temperaturas superan los 85 grados F comenzará a florear. En Texas, el mejor momento para plantar cilantro es en febrero para cosecharlo en abril y de nuevo en septiembre para cosecharlo en noviembre. Plantar semanalmente le asegurará un cultivo continuo.";
                    title="2.Siembra";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Lechuga")){
                    consejo="En general, las plantas de lechuga necesitan un clima fresco para prosperar. Debemos centrarnos en plantar semillas en la franja de tiempo adecuada, dependiendo de cuándo queremos cosecharlas.\n" +
                            "\n" +
                            "Dependiendo de la variedad, la lechuga puede crecer a una temperatura entre 45 a 64°F (7-18°C). Bajo ciertas circunstancias y manejo especial (por ejemplo, sombras), la lechuga puede crecer incluso a 84°C (29°C). Cuando decidimos plantar lechuga en primavera u otoño, la ubicación perfecta es un área soleada. Por el contrario, cuando decidimos plantar a fines del verano, la lechuga requiere suficiente protección contra el sol. Esto puede ser proporcionado por sombras. Cuando el clima comienza a ser más frío, podemos quitar las sombras y dejar que las plantas jóvenes reciban la luz solar que necesitan.";
                    title="2.Siembra y Espaciamiento de la Lechuga";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Maiz")){
                    consejo="La eopca de siembra de un cultivo de maiz puede ser desde septiembre a noviembre, según la variedad, evitando las siembras tardías ya que pueden ser muy perjudiciales por ataque de isoca de la espiga. Se siembra en forma directa a golpe, en chacra a 1,40 x 1,40 m o en surcos a 70 cm entre surcos y 30 cm entre plantas. Se recomienda realizar siembras escalonadas cada 15-20 días para prolongar el periodo de cosecha hasta Marzo – Abril";
                    title="2.Forma y epoca de siembra";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Papa")){
                    consejo="En el ciltivo de papa por lo general no se lleva a cabo con semillas, sino con \"papas semillas\", que son pequeños tubérculos o fragmentos de éstos, los cuales se introducen a una profundidad de 5 a 10 centímetros en la tierra. La pureza de los cultivares y la salud de los tubérculos semilla son esenciales para obtener una buena cosecha. El tubérculo semilla debe estar libre de enfermedades, tener buenos brotes y pesar de 30 a 40 gr. El uso de semilla comercial de buena calidad puede aumentar la producción del 30 % al 50 %, en comparación con la semilla del agricultor, pero las ganancias previstas deben compensar el costo más elevado";
                    title="2.La siembra";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }
            }
        });
        btn_cs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cultivo.equals("Alberja")){

                    consejo="En un cultivo de arverja se debe hacer previamente un análisis de suelo para saber la disponibilidad de nutrientes, definir la cantidad y tipo de fertilizante  y correctivos  para aplicar. Para una producción de arveja de 4 a 5 toneladas de vaina verde por hectárea el cultivo extrae del suelo 125 kilogramos de Nitrógeno, 30 kilogramos de Fosforo y 75 kilogramos de Potasio, además requiere de 65 a 100 kilogramos de Calcio y 13 kilogramos de Magnesio por hectárea.  Como generalidad en lotes sin análisis de suelo se aplica al momento de la siembra 4 bultos de fertilizante químico 10-30-10 y a los 40 días se aplica 6 bultos de 15-1-5-15";
                    title="3.Fertilización";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);
                }else if(cultivo.equals("Yuca")){

                    consejo="La yuca puede crecer en climas cálidos y de sequía pero al ser una planta tropical necesita ser regada constantemente tanto el tallo como las hojas, esto para mantener la humedad en la planta, pero teniendo siempre en cuenta que no debe excederse en el regado y no debe producir charcos de agua.\n" +
                            "\n" +
                            "Este riego debe realizarlo con mayor frecuencia durante el primer mes de la siembra, aquí es donde la planta es más vulnerable al calor, luego de transcurrido el primer mes ya la planta puede soportar mejor las sequías";
                    title="3.Riego";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cafe")){
                    consejo="Una vez que los plantones de cafeto están en tierra, necesitan mucha humedad, sobre todo en sus etapas críticas, si es período de lluvias no habrá mucho de qué preocuparse. Existen tres métodos de riego que son riego por inundación a través de un surco, riego por aspersión y riego por goteo. Este último método de riego se ha convertido en el sistema por excelencia debido al ahorro de agua y energía, junto con el aseguramiento de la humedad necesaria para la siembra; además logra potenciar la producción de una manera significativa.";
                    title="3.Riego";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cebolla")){
                    consejo="El riego ha de ser constante, pero no necesita mucha agua. Parece que últimamente solemos decir mucho lo de riego constante pero en este caso, en el cultivo de la cebolla lo requerimos más que nunca. De hecho, lo ponemos de otro color, la cebolla no tolera exceso de humedad, por lo tanto lo que se debe hacer es menor volumen de riego pero con mayor frecuencia. No dejar que se seque la tierra y cuando nos demos cuenta añadir un riego muy abundante y ale, a ver la tele. Así se produce agrietamiento y pudrición";
                    title="3.Riego";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cilantro")){
                    consejo="La necesidad de agua más crítica de la planta ocurre durante la germinación y el establecimiento. Una vez que las plantas están establecidas, no necesitan mucha agua.";
                    title="3.Riego";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Lechuga")){
                    consejo="Las plantas de lechuga tienen un sistema de raíces poco profundas. Normalmente prefieren sesiones de riego más pequeñas pero más frecuentes. Durante los calurosos meses de verano, es posible que tengamos que regar las plantas de lechuga todos los días y tal vez ponerles sombra. Si no regamos regularmente nuestras plantas durante esta temporada, las plantas de lechuga sufrirán de calor y la producción de semillas puede ser un problema (la planta comienza a producir semillas). En consecuencia, las hojas de lechuga pueden llegar a ser amargas. El empernado es generalmente irreversible y esas plantas no pueden comercializarse. La mayoría de los agricultores utilizan sistemas de riego por aspersión o por goteo.";
                    title="3.Requerimientos de Agua de la Lechuga";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Maiz")){
                    consejo="como es una planta que requiere humedad para obtener buen desarrollo y producir choclos de buen tamaño, debe tener buena humedad en su época critica que es entre formación de las barbas y el final de llenado de los granos. Igualmente la falta de agua en el resto del ciclo resiente la obtención de buenos rindes.\n" +
                            "\n" +
                            "Se estima que el maíz precisa, en suelos franco-arcillosos, unos 25 mm de agua por semana en la época de crecimiento y unos 40 mm por semana durante la formación de la espiga.";
                    title="3.Riegos";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Papa")){
                    consejo="El suelo debe mantener un contenido de humedad relativamente elevado. Las mejores cosechas, en cultivos de 120 a 150 días, se obtienen con de 500 a 700 mm de agua. En general, la falta de agua hace disminuir la producción cuando se produce a mitad o fines del período de desarrollo, más que si falta al inicio. Cuando hay poca agua, ésta se concentra en obtener la producción máxima por hectárea en vez de aplicarse a una superficie más amplia.";
                    title="3.Suministro de agua";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }
            }
        });
        btn_cs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cultivo.equals("Alberja")){

                    consejo="Los primeros estados de desarrollo y posteriormente la etapa de floración y llenado de vaina son los momentos más críticos de la competencia de malezas, por esta razón el primer control de malezas se hace en presiembra y ya instalado el cultivo los controles se inician dos semanas después de la emergencia.\n" +
                            "\n" +
                            "La primera plaga que se presenta en el cultivo es el gusano de la semilla que son larvas de moscas que perfora los cotiledones, mata el embrión, afectando la germinación. Simultáneamente aparecen los trozadores o tierreros que son larvas de polillas de hábitos nocturnos que se alimentan inicialmente de raíces y posteriormente trozan los tallos causando la muerte de la planta.";
                    title="4.Manejo fitosanitario";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);
                }else if(cultivo.equals("Yuca")){

                    consejo="Para poder cosechar el cultivo de yucas, hay que esperar de 8 a 12 meses, dependiendo de las condiciones climáticas y de los nutrientes presentes en el terreno. Una vez cumplido este periodo de tiempo se procede a cortar el tallo (el cual se puede volver a utilizar para sembrar más plantas) y extraer las raíces del terreno (estas pueden estas hasta unos 60 cm de profundidad)";
                    title="4.Cosecha de yuca";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cafe")){
                    consejo="La temporada de cosecha de las bayas de café varía de acuerdo a las condiciones climáticas, del suelo, del método de cultivo y de la especie. Por lo general un periodo seco bien definido solo deja madurar las bayas para una cosecha, En lugares con lluvias bien distribuida puede producir de dos a tres cosechas durante el año";
                    title="4.Cosecha";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cebolla")){
                    consejo="Hay que prestar especial atención con los siguientes «malos amigos» en el cultivo de cebolla.\n" +
                            "\n" +
                            "Plagas.\n" +
                            "\n" +
                            "Trips\n" +
                            "Minadores\n" +
                            "Polilla de la cebolla\n" +
                            "Mosca de la cebolla";
                    title="4.Plagas";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Cilantro")){
                    consejo="Las hojas de cilantro están listas para la cosecha de 45 a 70 días después de la siembra. Corte las hojas exteriores una vez que alcancen de 4 a 6 pulgadas de largo. Otra opción es cortar la planta entera de 1 a 2 pulgadas por encima del nivel del suelo para usar tanto las hojas pequeñas como las grandes.";
                    title="4.Cosecha";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Lechuga")){
                    consejo="Como regla general, la lechuga puede tomar de 65 a 130 días desde la siembra hasta la cosecha (dependiendo de la variedad). En la mayoría de los casos, la lechuga se puede cosechar entre 30 y 70 días después del trasplante. El momento adecuado para cosechar nuestras plantas depende no solo de diferentes variedades sino también de las condiciones locales (clima, distancias de siembra, peso de mercado preferido, fertilización, etc.).";
                    title="4.Cosecha de Lechuga";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Maiz")){
                    consejo="Se calcula entre 70 y 120 días según la variedad y época de siembra. Como dato orientativo la cosecha puede comenzar de 15 a 20 días después de la aparición de las barbas (estigmas) que comienzan a secarse, estando los granos al estado lechoso al hincarse la uña revientan fácilmente largando un líquido blanquecino.";
                    title="4.Cosecha";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }else if(cultivo.equals("Papa")){
                    consejo="Cuando las hojas de la planta de la papa se ponen amarillas y los tubérculos se desprenden con facilidad de sus estolones, significa que la papa está madura. Si las papas van a almacenarse en vez de consumirse enseguida, se dejan en el suelo para que la piel se haga más gruesa, porque una piel más gruesa previene las enfermedades que se producen durante el almacenamiento y evitan que la papa se encoja por pérdida de agua. Sin embargo, si se dejan los tubérculos en el suelo demasiado tiempo, aumenta la posibilidad de que contraigan la enfermedad fúngica llamada viruela de la papa";
                    title="4.Cosecha";
                    Intent intent= new Intent(Culture.this, Advice2.class);
                    intent.putExtra("consejo",consejo);
                    intent.putExtra("title",title);
                    Culture.this.startActivity(intent);

                }
            }
        });





    }

    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    public void tomarfoto (View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI.toString());
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
    }

}