package com.example.blockchain2.BBDD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.blockchain2.BBDD.utilidades.utilidades;

public class conexionBBDD extends SQLiteOpenHelper{

    // Constructor que inicia la base de datos
    public conexionBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Como la clase extiende un SQLiteOpenHelper, en onCreate le pasamos un parametro que es la conexion a la BBDD, y luego creamos una tabla llamada usuarios
        db.execSQL(utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        // Eliminador de la tabla si ya existe
        db.execSQL("DROP TABLE IF EXISTS USUARIOS");
        onCreate(db);
    }

    public boolean checkmail(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE email=? AND password=?", new String[]{email, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }
}