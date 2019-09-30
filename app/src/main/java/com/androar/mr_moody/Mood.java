package com.androar.mr_moody;

import java.io.Serializable;

public class Mood implements Serializable {
    private String mood;
    private String reason;
    private String date;

    public Mood(String mood, String reason, String date) {
        this.mood = mood;
        this.reason = reason;
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
