package com.zamnadev.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ManejadorLocal extends SQLiteOpenHelper {


    public static final String TABLA_PRODUCTOS = "productos";
    public static final String ID_PRODUCTO = "idProducto";
    public static final String NOMBRE = "nombre";
    public static final String CANTIDAD = "cantiad";
    public static final String PRECIO = "precio";


    public ManejadorLocal(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL("CREATE TABLE IF NOT EXISTS " + TABLA_PRODUCTOS + "("
                + ID_PRODUCTO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOMBRE + " TEXT, "
                + CANTIDAD + " INTEGER, "
                + PRECIO + " REAL );" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
