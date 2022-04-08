package com.example.recycledfeed2parcial;

public class elemento {
    private String mName;
    private String mYear;
    private String mDirector;
    private String mLengu;

    public elemento(String mName,String mYear, String mDirector, String mLengu){
        this.mName=mName;
        this.mYear=mYear;
        this.mDirector=mDirector;
        this.mLengu=mLengu;
    }

    public String getmName() {
        return mName;
    }

    public String getmDirector() {
        return mDirector;
    }

    public String getmYear() {
        return mYear;
    }

    public String getmLengu() {
        return mLengu;
    }
}