package com.example.administrator.paopaox;

import android.content.Context;
import android.widget.LinearLayout;

public class SignalClusterView extends LinearLayout {
    public boolean mNotchEar;
    public boolean mNotchEarDual;
    public boolean mNotchEarDualEnable;
    public SignalClusterView(final Context context){
        super(context);
    }

    public void get(){
        MainActivity.dualSignal(this);
    }

    public void set(){
       Context context = this.getContext();
    }
}
