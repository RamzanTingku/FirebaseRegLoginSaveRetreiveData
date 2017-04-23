package com.example.ramzanullah.firebaseregistrationlogin;

/**
 * Created by RamzanUllah on 23-Apr-17.
 */

public class Authors {
    String mName,mQuote;

    public Authors() {
    }

    public Authors( String mName, String mQuote) {

        this.mName = mName;
        this.mQuote = mQuote;
    }



    public String getmName() {
        return mName;
    }

    public String getmQuote() {
        return mQuote;
    }
}
