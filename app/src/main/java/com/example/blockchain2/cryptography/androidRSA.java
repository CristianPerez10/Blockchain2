package com.example.blockchain2.cryptography;

import android.content.Context;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;

public class androidRSA{
    public PrivateKey llavePrivada = null;
    public PublicKey llavePublica = null;
    public Context context;

    public void generarLlaves(int size) throws NoSuchAlgorithmException {
        // Generamos las llaves
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(size);
        KeyPair parLlaves = generador.genKeyPair();

        PublicKey llavePublica = parLlaves.getPublic();
        PrivateKey llavePrivada = parLlaves.getPrivate();

        this.llavePrivada = llavePrivada;
        this.llavePublica = llavePublica;
    }

    public Context getContext(){
        return context;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void llavePrivadaToString(String llave) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte [] llavePrivadaCodificada = stringToBytes(llave);

        KeyFactory traductorLlave = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec especificacionLlavePriv = new PKCS8EncodedKeySpec(llavePrivadaCodificada); // Añade las especificaciones del algoritmo a la llave privada en bytes
        PrivateKey llavePrivadaTraducida = traductorLlave.generatePrivate(especificacionLlavePriv);
        this.llavePrivada = llavePrivadaTraducida;
    }

    public void llavePublicaToString(String llave) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte [] llavePublicaCodificada = stringToBytes(llave);

        KeyFactory traductorLlave = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec especificacionLlavePriv = new PKCS8EncodedKeySpec(llavePublicaCodificada); // Especifica la llave publica codificada en bytes
        PrivateKey llavePublicaTraducida = traductorLlave.generatePrivate(especificacionLlavePriv);
        this.llavePrivada = llavePublicaTraducida;
    }

    public String bytesToString(byte[] b){
        byte[] receptor = new byte[b.length + 1];
        receptor[0] = 1;
        System.arraycopy(b, 0, receptor, 1, b.length);
        return new BigInteger(receptor).toString(36);
    }

    public byte[] stringToBytes(String s){
        byte[] transformador = new BigInteger(s, 36).toByteArray(); // A un array de bytes
        return Arrays.copyOfRange(transformador, 1, transformador.length);
    }

    public String getPrivateKeyString(){
        PKCS8EncodedKeySpec especificacionLlavePrivada = new PKCS8EncodedKeySpec(this.llavePrivada.getEncoded());
        return bytesToString(especificacionLlavePrivada.getEncoded());
    }

    public String getPublicKeyString(){
        PKCS8EncodedKeySpec especificacionLlavePublica = new PKCS8EncodedKeySpec(this.llavePublica.getEncoded());
        return bytesToString(especificacionLlavePublica.getEncoded());
    }

}

