package com.example.administrator.paopaox;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StatusHideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_hide);

        Context context = getApplicationContext();
        Integer hide_volume = Common.getValue(context,"paopao_statusbar_hide_volume",0);
        Integer hide_alarm_clock = Common.getValue(context,"paopao_statusbar_hide_alarm_clock",0);
        Integer hide_headset = Common.getValue(context,"paopao_statusbar_clock_hide_headset",0);
        Integer hide_bluetooth = Common.getValue(context,"paopao_statusbar_hide_bluetooth",0);

        CheckBox hide_volume_cb = findViewById(R.id.hide_volume);
        hide_volume_cb.setChecked(hide_volume==1);

        CheckBox hide_alarm_clock_cb = findViewById(R.id.hide_alarm_clock);
        hide_alarm_clock_cb.setChecked(hide_alarm_clock==1);

        CheckBox hide_headset_cb = findViewById(R.id.hide_headset);
        hide_headset_cb.setChecked(hide_headset==1);

        CheckBox hide_bluetooth_cb = findViewById(R.id.hide_bluetooth);
        hide_bluetooth_cb.setChecked(hide_bluetooth==1);

        Button status_hide_confirm = findViewById(R.id.status_hide_confirm);
        status_hide_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setCount();
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                    CommandExecution.rebootStatusBar();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setCount(){
        Context context = getApplicationContext();
        List<String> list = new ArrayList<>();
        list.add("paopao");

        CheckBox hide_volume_cb = findViewById(R.id.hide_volume);
        Integer hide_volume = hide_volume_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_hide_volume",hide_volume);
        if(hide_volume_cb.isChecked()){
            list.add("volume");
        }

        CheckBox hide_alarm_clock_cb = findViewById(R.id.hide_alarm_clock);
        Integer hide_alarm_clock = hide_alarm_clock_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_hide_alarm_clock",hide_alarm_clock);
        if(hide_alarm_clock_cb.isChecked()){
            list.add("alarm_clock");
        }

        CheckBox hide_headset_cb = findViewById(R.id.hide_headset);
        Integer hide_headset = hide_headset_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_hide_headset",hide_headset);
        if(hide_headset_cb.isChecked()){
            list.add("headset");
        }

        CheckBox hide_bluetooth_cb = findViewById(R.id.hide_bluetooth);
        Integer hide_bluetooth = hide_bluetooth_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_hide_bluetooth",hide_bluetooth);
        if(hide_bluetooth_cb.isChecked()){
            list.add("bluetooth");
        }

        String hideStr = TextUtils.join(",",list);
        ContentResolver contentResolver = context.getContentResolver();
        Settings.Secure.putString(contentResolver,"icon_blacklist",hideStr);
    }
}
