package com.zamnadev.basededatos;

import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

public class Productos {

    private String nombre;

    public Productos() {
        this.nombre = nombre;
    }

    public Productos(JSONObject jsonObject){
        try {
            nombre= jsonObject.getString("nombre");
        } catch (JSONException e) {

        }
    }

}
