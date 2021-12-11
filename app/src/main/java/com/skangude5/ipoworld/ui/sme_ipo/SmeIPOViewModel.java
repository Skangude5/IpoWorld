package com.skangude5.ipoworld.ui.sme_ipo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SmeIPOViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SmeIPOViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sme IPO fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}