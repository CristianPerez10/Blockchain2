package com.example.blockchain2.ui.wallet;

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

public class walletFragment extends Fragment {
    private walletViewModel walletViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        walletViewModel = new ViewModelProvider(this).get(walletViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wallet, container, false);
        final TextView textView = root.findViewById(R.id.wallet_id);
        walletViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
