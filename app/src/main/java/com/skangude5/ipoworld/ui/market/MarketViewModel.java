package com.skangude5.ipoworld.ui.market;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarketViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MarketViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Market fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}