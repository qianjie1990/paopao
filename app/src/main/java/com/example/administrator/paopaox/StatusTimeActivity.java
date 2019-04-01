package com.example.administrator.paopaox;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StatusTimeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_time);

        Context context = getApplicationContext();
        Integer show_week = Common.getValue(context,"paopao_statusbar_clock_show_week",0);
        Integer show_day = Common.getValue(context,"paopao_statusbar_clock_show_day",0);
        Integer show_month = Common.getValue(context,"paopao_statusbar_clock_show_month",0);
        Integer show_year = Common.getValue(context,"paopao_statusbar_clock_show_year",0);
        Integer show_dizhi = Common.getValue(context,"paopao_statusbar_clock_show_timedetail2",0);
        Integer show_zaowan = Common.getValue(context,"paopao_statusbar_clock_show_timedetail1",0);
        Integer show_second = Common.getValue(context,"paopao_statusbar_clock_show_second",0);
        Integer delete_space = Common.getValue(context,"paopao_statusbar_clock_space",0);
        Integer small_text = Common.getValue(context,"paopao_statusbar_clock_small",0);
        Integer show_double = Common.getValue(context,"paopao_statusbar_clock_double",0);
        CheckBox show_week_cb = findViewById(R.id.show_week);
        show_week_cb.setChecked(show_week==1);

        CheckBox show_day_cb = findViewById(R.id.show_day);
        show_day_cb.setChecked(show_day==1);

        CheckBox show_month_cb = findViewById(R.id.show_month);
        show_month_cb.setChecked(show_month==1);

        CheckBox show_year_cb = findViewById(R.id.show_year);
        show_year_cb.setChecked(show_year==1);

        CheckBox show_dizhi_cb = findViewById(R.id.show_dizhi);
        show_dizhi_cb.setChecked(show_dizhi==1);

        CheckBox show_zaowan_cb = findViewById(R.id.show_zaowan);
        show_zaowan_cb.setChecked(show_zaowan==1);

        CheckBox show_second_cb = findViewById(R.id.show_second);
        show_second_cb.setChecked(show_second==1);

        CheckBox delete_space_cb = findViewById(R.id.delete_space);
        delete_space_cb.setChecked(delete_space==1);

        CheckBox small_text_cb = findViewById(R.id.small_text);
        small_text_cb.setChecked(small_text==1);

        CheckBox show_double_cb = findViewById(R.id.show_double);
        show_double_cb.setChecked(show_double==1);

        Button status_bar_confirm = findViewById(R.id.status_bar_confirm);
        status_bar_confirm.setOnClickListener(new View.OnClickListener() {
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

        CheckBox show_week_cb = findViewById(R.id.show_week);
        Integer show_week = show_week_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_week",show_week);

        CheckBox show_day_cb = findViewById(R.id.show_day);
        Integer show_day = show_day_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_day",show_day);

        CheckBox show_month_cb = findViewById(R.id.show_month);
        Integer show_month = show_month_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_month",show_month);

        CheckBox show_year_cb = findViewById(R.id.show_year);
        Integer show_year = show_year_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_year",show_year);

        CheckBox show_dizhi_cb = findViewById(R.id.show_dizhi);
        Integer show_dizhi = show_dizhi_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_timedetail2",show_dizhi);

        CheckBox show_zaowan_cb = findViewById(R.id.show_zaowan);
        Integer show_zaowan = show_zaowan_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_timedetail1",show_zaowan);

        CheckBox show_second_cb = findViewById(R.id.show_second);
        Integer show_second = show_second_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_show_second",show_second);

        CheckBox delete_space_cb = findViewById(R.id.delete_space);
        Integer delete_space = delete_space_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_space",delete_space);

        CheckBox small_text_cb = findViewById(R.id.small_text);
        Integer small_text = small_text_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_small",small_text);

        CheckBox show_double_cb = findViewById(R.id.show_double);
        Integer show_double = show_double_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_clock_double",show_double);

    }
}
