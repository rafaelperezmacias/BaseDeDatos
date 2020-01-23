package com.zamnadev.basededatos;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PeticionPorPost extends StringRequest {

    private HashMap<String, String> hashMap;

    public PeticionPorPost(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener, HashMap<String, String> hashMap) {
        super(method, url, listener, errorListener);
        this.hashMap = hashMap;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return hashMap;
    }
}
