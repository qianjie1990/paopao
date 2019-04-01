package com.example.administrator.paopaox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);

        Context context = getApplicationContext();

        Integer pull_weather_value = Common.getValue(context,"paopao_weather_info",1);
        RadioButton pull_weather_checked = findViewById(R.id.pull_weather_1);
        switch (pull_weather_value){
            case 0:
                pull_weather_checked = findViewById(R.id.pull_weather_0);
                break;
            case 1:
                pull_weather_checked = findViewById(R.id.pull_weather_1);
                break;
            case 2:
                pull_weather_checked = findViewById(R.id.pull_weather_2);
                break;
        }
        pull_weather_checked.setChecked(true);

        Integer pull_nl_value = Common.getValue(context,"paopao_StatusBar_Lunar",0);
        RadioButton pull_nl_checked = findViewById(R.id.pull_nl_0);
        switch (pull_nl_value){
            case 0:
                pull_nl_checked = findViewById(R.id.pull_nl_0);
                break;
            case 1:
                pull_nl_checked = findViewById(R.id.pull_nl_1);
                break;
        }
        pull_nl_checked.setChecked(true);

        Integer pull_nlsp_value = Common.getValue(context,"show_lunar_calendar",0);
        RadioButton pull_nlsp_checked = findViewById(R.id.pull_nlsp_0);
        switch (pull_nlsp_value){
            case 0:
                pull_nlsp_checked = findViewById(R.id.pull_nlsp_0);
                break;
            case 1:
                pull_nlsp_checked = findViewById(R.id.pull_nlsp_1);
                break;
        }
        pull_nlsp_checked.setChecked(true);

        Button pull_confirm = findViewById(R.id.pull_confirm);
        pull_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setCount();
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                    Thread.sleep(1500);
                    CommandExecution.rebootStatusBar();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setCount(){
        Context context = getApplicationContext();

        Integer pull_weather_value = 1;
        RadioGroup pull_weather = findViewById(R.id.pull_weather);
        int id = pull_weather.getCheckedRadioButtonId();
        switch (id){
            case R.id.pull_weather_0:
                pull_weather_value = 0;
                break;
            case R.id.pull_weather_1:
                pull_weather_value = 1;
                break;
            case R.id.pull_weather_2:
                pull_weather_value = 2;
                break;
        }
        Common.setValue(context,"paopao_weather_info",pull_weather_value);

        Integer pull_nl_value = 0;
        RadioGroup pull_nl = findViewById(R.id.pull_nl);
        id = pull_nl.getCheckedRadioButtonId();
        switch (id){
            case R.id.pull_nl_0:
                pull_nl_value = 0;
                break;
            case R.id.pull_nl_1:
                pull_nl_value = 1;
                break;
        }
        Common.setValue(context,"paopao_StatusBar_Lunar",pull_nl_value);

        Integer pull_nlsp_value = 0;
        RadioGroup pull_nlsp = findViewById(R.id.pull_nlsp);
        id = pull_nlsp.getCheckedRadioButtonId();
        switch (id){
            case R.id.pull_nlsp_0:
                pull_nlsp_value = 0;
                break;
            case R.id.pull_nlsp_1:
                pull_nlsp_value = 1;
                break;
        }
        Common.setValue(context,"show_lunar_calendar",pull_nlsp_value);

    }
}
