package com.example.blockchain2.ui.config;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class configViewModel extends ViewModel {

    private MutableLiveData<String> mtext;

    public configViewModel() {
        mtext = new MutableLiveData<>();
        mtext.setValue("Bienvenido a la configuracion");
    }

    public LiveData<String> getText() { return mtext; }
}
