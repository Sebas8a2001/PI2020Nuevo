package com.example.pi2020;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.HashMap;

public class AddCropRequest extends JsonArrayRequest {
    HashMap<String,String> headers;
    public AddCropRequest(String username, Response.Listener<JSONArray> listener) {
        super(Method.GET,"https://androidpi2020-2.000webhostapp.com/AddCrop.php?username="+username,null, listener, null);
        headers = new HashMap<>();
        headers.put("username",username);
    }


    @Override
    public HashMap<String, String> getHeaders() {
        return headers;
    }
}
