package com.example.blockchain2.ui.config;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.blockchain2.R;

import org.w3c.dom.Text;

public class configFragment extends Fragment {

    private configViewModel configViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        configViewModel = new ViewModelProvider(this).get(configViewModel.class);
        View root = inflater.inflate(R.layout.fragment_config, container, false);
        final TextView textView = root.findViewById(R.id.config_id);
        configViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
