package com.example.blockchain2.ui.inicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class inicioViewModel extends ViewModel {

    private MutableLiveData<String> mtext;

    public inicioViewModel() {
        mtext = new MutableLiveData<>();
        mtext.setValue("Este es el fragment de inicio");
    }

    public LiveData<String> getText() { return mtext; }

}
