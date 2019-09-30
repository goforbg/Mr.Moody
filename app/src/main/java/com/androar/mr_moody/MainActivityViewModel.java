package com.androar.mr_moody;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<String> xmood =  new MutableLiveData<String>();;
    public MutableLiveData<String> reason =  new MutableLiveData<String>();


    public void selectMood (String moodx)
    {
        xmood.setValue(moodx);
    }

    public void selectReason (String reasonx)
    {
        reason.setValue(reasonx);
    }
    public MutableLiveData<String> getMood() {
        if (xmood == null)
        {
            xmood = new MutableLiveData<String>();
        }

        return  xmood;
    }

    public MutableLiveData<String> getReason() {
        return reason;
    }
}
