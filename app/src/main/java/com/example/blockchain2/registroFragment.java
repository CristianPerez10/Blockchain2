package com.example.blockchain2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.blockchain2.BBDD.conexionBBDD;
import com.example.blockchain2.BBDD.utilidades.utilidades;
import com.example.blockchain2.cryptography.androidRSA;

import java.security.NoSuchAlgorithmException;

public class registroFragment extends Fragment {
    public registroFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.registro_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Button volver_main = view.findViewById(R.id.registro_volverMainFrag_btn_id);
        Button registro_btn = view.findViewById(R.id.registro_bbdd_btn_id);
        final EditText nombre = view.findViewById(R.id.registro_nombre_inp_id);
        final EditText password = view.findViewById(R.id.registro_pass_inp_id);
        EditText confirm_pass = view.findViewById(R.id.registro_confirmPass_inp_id);
        final EditText email = view.findViewById(R.id.registro_correo_inp_id);
        final EditText numero = view.findViewById(R.id.registro_phone_inp_id);
        conexionBBDD conexionRegistro = new conexionBBDD(getContext(), "blockchain1_users_db", null, 1);
        final SQLiteDatabase db = conexionRegistro.getWritableDatabase();
        final androidRSA rsa = new androidRSA();

        registro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rsa.generarLlaves(1024);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                ContentValues valores_db = new ContentValues();
                valores_db.put(utilidades.NOMBRE_USUARIO, nombre.getText().toString());
                valores_db.put(utilidades.EMAIL_USUARIO, email.getText().toString());
                valores_db.put(utilidades.PASSWORD_USUARIO, password.getText().toString());
                valores_db.put(utilidades.TELEFONO_USUARIO, numero.getText().toString());
                valores_db.put(utilidades.PRIVATE_KEY_USUARIO, rsa.getPrivateKeyString());
                valores_db.put(utilidades.PUBLIC_KEY_USUARIO, rsa.getPublicKeyString());

                Long insertar = db.insert(utilidades.TABLA_USUARIO, utilidades.NOMBRE_USUARIO, valores_db);
                Toast.makeText(getContext(), "Usuario registrado con exito: " + insertar, Toast.LENGTH_LONG).show();
                db.close();
            }
        });

        volver_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.mainFragment);
            }
        });
    }
}
