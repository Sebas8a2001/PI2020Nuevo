package com.example.pi2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.awareness.Awareness;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
public class Get_weather<client> extends AppCompatActivity {
    private static final String OPEN_WEATHER_MAP_URL="http://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric";
    private static final String OPEN_WEATHER_MAP_API="6b2715eba21914ebb7bc2dc349ffa929";
    String username,nomcultivo;
    ImageButton btn_add_crop,btn_profile;
    TextView cityField, detailsField,currentTemperatureField,humidityField,presureField, weatherIcon,updateField;
    Typeface weatherfont;
    static String latitude;
    static String longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_weather);

        Bundle bundle= this.getIntent().getExtras();
        username= bundle.getString("usernameP");
        nomcultivo=bundle.getString("nomCultivo");
        btn_add_crop= (ImageButton)findViewById(R.id.btn_addcrop);
        btn_profile=(ImageButton)findViewById(R.id.btn_profile);

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Get_weather.this,Profile1.class);
                intent.putExtra("usernameP",username);
                Get_weather.this.startActivity(intent);
            }
        });
        btn_add_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Get_weather.this,AddCrop.class);
                intent.putExtra("usernameP",username);
                intent.putExtra("nomCultivo",nomcultivo);
                Get_weather.this.startActivity(intent);
            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        requestPermissions();
        FusedLocationProviderClient mFusedlocationProviderClient;
        mFusedlocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if(ActivityCompat.checkSelfPermission(Get_weather.this, ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
         return;
        } 
        mFusedlocationProviderClient.getLastLocation().addOnSuccessListener(Get_weather.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                     latitude= String.valueOf(location.getLatitude());
                     longitude= String.valueOf(location.getLongitude());

                     cityField= findViewById(R.id.city_field);
                     currentTemperatureField = findViewById(R.id.current_temperature_field);
                     updateField = findViewById(R.id.updated_field);

                     humidityField= findViewById(R.id.humidity_field);
                     presureField = findViewById(R.id.pressure_field);


                     String [] jsonData= getJSONResponse();
                     cityField.setText(jsonData[0]);

                     currentTemperatureField.setText("Clima: "+jsonData[2]);
                     humidityField.setText("Humedad : "+jsonData[3]);
                     presureField.setText("Presion : "+jsonData[4]);
                     updateField.setText(jsonData[5]);






                }
            }
        });
    }
     public String [] getJSONResponse(){
        String [] jsonData= new String[7];
         JSONObject jsonWeather= null;
         try {
             jsonWeather= getWeatherJSON(latitude, longitude);

         }catch (Exception e){
             Log.d("error","cannot procces");

         }
        try {
            if(jsonWeather != null ){
                JSONObject details= jsonWeather.getJSONArray("weather").getJSONObject(0);
                JSONObject main= jsonWeather.getJSONObject("main");
                DateFormat df= DateFormat.getDateInstance();

                String city = jsonWeather.getString("name")+", "+jsonWeather.getJSONObject("sys").getString("country");

                String temperature= String.format("%.0f",main.getDouble("temp"))+ "°";
                String humidity = main.getString("humidity")+ "%";
                String pressure= main.getString("pressure")+" hPa";
                String updateOn= df.format(new Date(jsonWeather.getLong("dt")*1000));

                jsonData[0]= city;

                jsonData[2]=temperature;
                jsonData[3]= humidity;
                jsonData[4]= pressure;
                jsonData[5]= updateOn;


            }
        }catch (Exception e){


        }
        return jsonData;
     }



     public static  JSONObject getWeatherJSON(String lat, String lon){
        try {
                URL url = new URL(String.format(OPEN_WEATHER_MAP_URL,lat,lon));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("x-api-key",OPEN_WEATHER_MAP_API);
            BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer json=  new StringBuffer(1024);
            String tmp= "";
            while((tmp= reader.readLine())!=null){
                json.append(tmp).append("\n");

            }
            reader.close();
            JSONObject data= new JSONObject((json.toString()));
            if(data.getInt("cod") != 200){
               return null;

            }
            return data;
        }catch (Exception ee){
            return null;

        }


     }
    public void requestPermissions(){
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);


    }

}