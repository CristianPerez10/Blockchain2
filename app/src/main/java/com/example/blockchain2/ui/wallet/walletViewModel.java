package com.example.blockchain2.ui.wallet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class walletViewModel extends ViewModel {
    private MutableLiveData<String> mtext;

    public walletViewModel() {
        mtext = new MutableLiveData<>();
        mtext.setValue("Bienvenido al wallet fragment");
    }

    public LiveData<String> getText() { return mtext; }

}
