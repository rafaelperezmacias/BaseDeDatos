package com.zamnadev.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            SharedPreferences preferences = getSharedPreferences("usuarios",MODE_PRIVATE);
            String nombre = preferences.getString("asdasd","default");
            Log.e("Nombre","" + nombre);

            SharedPreferences sharedPreferences = getSharedPreferences("usuarios",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("usuario","rafa");
            editor.apply();
        */

        /*
        ManejadorLocal manejadorLocal = new ManejadorLocal(MainActivity.this,"bdPrueba",null,1);
        SQLiteDatabase db = manejadorLocal.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ManejadorLocal.NOMBRE,"sdas");
        contentValues.put(ManejadorLocal.CANTIDAD,10320);
        contentValues.put(ManejadorLocal.PRECIO,23245.30);

        Long id = db.insert(ManejadorLocal.TABLA_PRODUCTOS,null,contentValues);
        if (id != null) {
            Log.e("id","" + id);
        }

        db = manejadorLocal.getReadableDatabase();

        String[] columnas = {
                ManejadorLocal.ID_PRODUCTO,
                ManejadorLocal.NOMBRE,
                ManejadorLocal.CANTIDAD,
                ManejadorLocal.PRECIO,
        };


        Cursor cursor = db.query(ManejadorLocal.TABLA_PRODUCTOS,columnas,ManejadorLocal.ID_PRODUCTO+ "=?",new String[]{id.toString()},null,null,null);

        cursor.moveToFirst();

        do {
            Log.e("ID","" + cursor.getInt(0));
            Log.e("Nombre",cursor.getString(1));
        } while (cursor.moveToNext());

        db = manejadorLocal.getWritableDatabase();

        contentValues.clear();
        contentValues.put(ManejadorLocal.NOMBRE,"adssadasd");
        contentValues.put(ManejadorLocal.CANTIDAD,123123);
        contentValues.put(ManejadorLocal.PRECIO,12312312.123);

        int resupltado = db.update(ManejadorLocal.TABLA_PRODUCTOS,contentValues,ManejadorLocal.ID_PRODUCTO+ "=?",new String[]{id.toString()});

        if (resupltado == 1) {
            db = manejadorLocal.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM " + ManejadorLocal.TABLA_PRODUCTOS + " WHERE " + ManejadorLocal.ID_PRODUCTO + " = " + id.toString(),null);

            cursor.moveToFirst();

            do {
                Log.e("ID","" + cursor.getInt(0));
                Log.e("Nombre",cursor.getString(1));
            } while (cursor.moveToNext());
        } else {
            Log.e("Erro","ERror");
        }

        db.close(); */

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("usuario","prueba");
        hashMap.put("password","1234");

        String get = "Taco";

        String url = "http://192.168.0.101/pruebaConexion/insert.php?nombre="+ get;

        /*PeticionPorPost post = new PeticionPorPost(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("RESPUESTA",response);
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.getInt("code");
                    switch (code) {
                        case 1: case 2: case 3:
                            Log.e("Error","Errores sistema");
                            break;
                        case 4:
                            Log.e("USUARIO","Usuario incorrecto");
                            break;
                        case 5:
                            Log.e("USUARIO","Contraseña incorrecta");
                            break;
                        case 6:
                            Log.e("USUARIO","Usuario encontrado");
                            Log.e("IDUSUARIO",object.getString("idUsuario"));
                            Log.e("USUARIO",object.getString("usuario"));
                            break;
                    }
                } catch (JSONException e) {
                    Log.e("ERROR","" + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RESPUESTA","" + error.getMessage());
            }
        },hashMap); */

        StringRequest post = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Respuesta",response);

                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.getInt("code");
                    if (code == 2) {
                        JSONArray jsonArray = object.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++){
                            JSONObject producto = jsonArray.getJSONObject(i);
                            Log.e("Id",producto.getString("idProducto"));
                            Log.e("Id",producto.getString("nombre"));
                        }
                    }
                } catch (JSONException e) {
                    Log.e("ERROR","" + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(post);
    }
} /*SharedPreferences sharedPreferences = getSharedPreferences("usuarios",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usuario","rafa");
        editor.apply(); */
