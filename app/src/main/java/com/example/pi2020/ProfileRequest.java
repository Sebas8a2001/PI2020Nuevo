package com.example.pi2020;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ProfileRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="https://androidpi2020-2.000webhostapp.com/profileRequest.php";
    private Map<String,String> params;
    public ProfileRequest(String username, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("username",username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
