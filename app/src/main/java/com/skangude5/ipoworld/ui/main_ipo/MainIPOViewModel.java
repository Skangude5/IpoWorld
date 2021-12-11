package com.skangude5.ipoworld.ui.main_ipo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainIPOViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MainIPOViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Main IPO fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}