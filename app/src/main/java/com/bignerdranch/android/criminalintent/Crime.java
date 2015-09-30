package com.bignerdranch.android.criminalintent;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by guilhermecardoso on 9/21/15.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Calendar mCalendar;
    private boolean mSolved;

    public Crime(){
        //Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
        mCalendar = Calendar.getInstance();
    }

    public boolean isSolved() {
        return mSolved;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    public void setCalendar(Calendar calendar) {
        mCalendar = calendar;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
