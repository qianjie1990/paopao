package com.example.administrator.paopaox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StatusSuperActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_super);

        Context context = getApplicationContext();

        Integer network_super_value = Common.getValue(context,"paopao_status_bar_traffic_style",0);
        RadioButton network_super_checked = findViewById(R.id.network_super_0);
        switch (network_super_value){
            case 0:
                network_super_checked = findViewById(R.id.network_super_0);
                break;
            case 1:
                network_super_checked = findViewById(R.id.network_super_1);
                break;
            case 2:
                network_super_checked = findViewById(R.id.network_super_2);
                break;
            case 3:
                network_super_checked = findViewById(R.id.network_super_3);
                break;
        }
        network_super_checked.setChecked(true);

        Integer temp_super_value = Common.getValue(context,"m_temperature_settings",0);
        RadioButton temp_super_checked = findViewById(R.id.temp_super_0);
        switch (temp_super_value){
            case 0:
                temp_super_checked = findViewById(R.id.temp_super_0);
                break;
            case 1:
                temp_super_checked = findViewById(R.id.temp_super_1);
                break;
            case 2:
                temp_super_checked = findViewById(R.id.temp_super_2);
                break;
            case 3:
                temp_super_checked = findViewById(R.id.temp_super_3);
                break;
        }
        temp_super_checked.setChecked(true);

        Integer battery_super_value = Common.getValue(context,"paopao_Battery_Icon",0);
        RadioButton battery_super_checked = findViewById(R.id.battery_super_0);
        switch (battery_super_value){
            case 0:
                battery_super_checked = findViewById(R.id.battery_super_0);
                break;
            case 1:
                battery_super_checked = findViewById(R.id.battery_super_1);
                break;
        }
        battery_super_checked.setChecked(true);

        Integer signal_super_1_value = Common.getValue(context,"paopao_statusbar_signal_1",0);
        CheckBox signal_super_1_cb = findViewById(R.id.signal_super_1);
        signal_super_1_cb.setChecked(signal_super_1_value==1);

        Integer signal_super_2_value = Common.getValue(context,"paopao_statusbar_signal_2",0);
        CheckBox signal_super_2_cb = findViewById(R.id.signal_super_2);
        signal_super_2_cb.setChecked(signal_super_2_value==1);

        Integer signal_super_3_value = Common.getValue(context,"paopao_statusbar_signal_3",0);
        CheckBox signal_super_3_cb = findViewById(R.id.signal_super_3);
        signal_super_3_cb.setChecked(signal_super_3_value==1);

        Button status_super_confirm = findViewById(R.id.status_super_confirm);
        status_super_confirm.setOnClickListener(new View.OnClickListener() {
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

        Integer network_super_value = 0;
        RadioGroup network_super = findViewById(R.id.network_super);
        int id = network_super.getCheckedRadioButtonId();
        switch (id){
            case R.id.network_super_0:
                network_super_value = 0;
                break;
            case R.id.network_super_1:
                network_super_value = 1;
                break;
            case R.id.network_super_2:
                network_super_value = 2;
                break;
            case R.id.network_super_3:
                network_super_value = 3;
                break;
        }
        Common.setValue(context,"paopao_status_bar_traffic_style",network_super_value);

        Integer temp_super_value = 0;
        RadioGroup temp_super = findViewById(R.id.temp_super);
        id = temp_super.getCheckedRadioButtonId();
        switch (id){
            case R.id.temp_super_0:
                temp_super_value = 0;
                break;
            case R.id.temp_super_1:
                temp_super_value = 1;
                break;
            case R.id.temp_super_2:
                temp_super_value = 2;
                break;
            case R.id.temp_super_3:
                temp_super_value = 3;
                break;
        }
        Common.setValue(context,"m_temperature_settings",temp_super_value);

        Integer battery_super_value = 0;
        RadioGroup battery_super = findViewById(R.id.battery_super);
        id = battery_super.getCheckedRadioButtonId();
        switch (id){
            case R.id.battery_super_0:
                battery_super_value = 0;
                break;
            case R.id.battery_super_1:
                battery_super_value = 1;
                break;
        }
        Common.setValue(context,"paopao_Battery_Icon",battery_super_value);

        CheckBox signal_super_1_cb = findViewById(R.id.signal_super_1);
        Integer signal_super_1 = signal_super_1_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_signal_1",signal_super_1);

        CheckBox signal_super_2_cb = findViewById(R.id.signal_super_2);
        Integer signal_super_2 = signal_super_2_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_signal_2",signal_super_2);

        CheckBox signal_super_3_cb = findViewById(R.id.signal_super_3);
        Integer signal_super_3 = signal_super_3_cb.isChecked()?1:0;
        Common.setValue(context,"paopao_statusbar_signal_3",signal_super_3);


    }
}
