package com.example.pi2020;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://androidpi2020-2.000webhostapp.com/Login.php";
    HashMap<String,String> headers;

    public LoginRequest(String username,String password, Response.Listener<String> listener) {
        super(Method.POST,REGISTER_REQUEST_URL , listener, null);
        headers = new HashMap<>();
        headers.put("username", username);
        headers.put("password", password);
    }



    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return headers;
    }
}






