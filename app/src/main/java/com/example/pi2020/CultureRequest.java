package com.example.pi2020;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CultureRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://androidpi2020-2.000webhostapp.com/return.php";
    private Map<String, String> params;

    public CultureRequest(String username,String cultivo, String date, String nomCultivo,Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("nomCultivo", nomCultivo);
        params.put("date", date);
        params.put("cultivo", cultivo);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    {
    }
}
