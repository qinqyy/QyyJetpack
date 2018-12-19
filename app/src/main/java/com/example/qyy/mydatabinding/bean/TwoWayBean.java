package com.example.qyy.mydatabinding.bean;

import android.databinding.BaseObservable;

/**
 * 双向绑定
 */
public class TwoWayBean extends BaseObservable{

    public String getTwoway() {
        return twoway;
    }

    public void setTwoway(String twoway) {
        this.twoway = twoway;
    }

    private String twoway;

}
