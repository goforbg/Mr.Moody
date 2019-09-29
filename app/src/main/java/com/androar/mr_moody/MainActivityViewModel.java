package com.androar.mr_moody;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<String> mood =  new MutableLiveData<String>();;
    public MutableLiveData<String> reason =  new MutableLiveData<String>();

    public void selectMood (String moodx)
    {
        mood.setValue(moodx);
    }

    public void selectReason (String reasonx)
    {
        reason.setValue(reasonx);
    }
    public LiveData<String> getMood() {
        return  mood;
    }

    public LiveData<String> getReason() {
        return reason;
    }
}
