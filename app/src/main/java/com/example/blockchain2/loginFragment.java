package com.example.blockchain2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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

public class loginFragment extends Fragment {
    public loginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        // Referencias a elementos visuales
        Button volver_main_fragment = view.findViewById(R.id.login_volverMainFrag_btn_id);
        Button login_btn = view.findViewById(R.id.login_bbdd_btn_id);
        final EditText email = view.findViewById(R.id.login_email_inp_id);
        final EditText password = view.findViewById(R.id.login_pass_inp_id);
        conexionBBDD conexionLogin = new conexionBBDD(getContext(), "blockchain1_users_db", null, 1);
        final SQLiteDatabase db = conexionLogin.getReadableDatabase();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] columnas = {"email", "password"};
                String selection = "email=? and password=?";
                String[] valor_campos = {email.getText().toString(), password.getText().toString()};
                Cursor cursor = db.query(utilidades.TABLA_USUARIO, columnas, selection, valor_campos, null, null, null);

                if (cursor.getCount() > 0) {
                    // Estoy tratando de pasar de un fragment a una activity y es aqui donde me esta dando error
                    Intent intent = new Intent(getActivity(), InicioActivity.class);
                    startActivity(intent);
                    ((Activity) getActivity()).overridePendingTransition(0, 0);
                } else {
                    Toast.makeText(getContext(), "EMAIL O PASSWORD INCORRECTAS", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

        volver_main_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.mainFragment);
            }
        });

    }
}
