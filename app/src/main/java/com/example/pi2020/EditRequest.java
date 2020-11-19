package com.example.pi2020;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EditRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://androidpi2020-2.000webhostapp.com/EditP.php";
    private Map<String, String> params;

    public EditRequest(String name, String username,String password,String username2,String password2,Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("username2", username2);
        params.put("password2", password2);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}