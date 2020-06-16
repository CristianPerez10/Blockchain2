package com.example.blockchain2.BBDD.utilidades;

public class utilidades {

    // Campos de la tabla de registro
    public static final String TABLA_USUARIO = "usuario";
    public static final String NOMBRE_USUARIO = "nombre";
    public static final String PASSWORD_USUARIO = "password";
    public static final String EMAIL_USUARIO = "email";
    public static final String TELEFONO_USUARIO = "telefono";
    public static final String PUBLIC_KEY_USUARIO = "private";
    public static final String PRIVATE_KEY_USUARIO = "public";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ TABLA_USUARIO +" ("+ PUBLIC_KEY_USUARIO + " TEXT PRIMARY KEY,"+ PRIVATE_KEY_USUARIO + " TEXT, "+ NOMBRE_USUARIO + " TEXT, "+ PASSWORD_USUARIO + " TEXT, "+ EMAIL_USUARIO + " TEXT, "+ TELEFONO_USUARIO +" TEXT)";
}
