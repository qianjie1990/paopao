package com.example.administrator.paopaox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuickSettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_setting);

        Context context = getApplicationContext();
        Integer qqs_count_value = Common.getValue(context,"paopao_qqs_count",5);
        RadioButton qqs_checked = findViewById(R.id.qqs_count_5);
        switch (qqs_count_value){
            case 4:
                qqs_checked = findViewById(R.id.qqs_count_4);
                break;
            case 5:
                qqs_checked = findViewById(R.id.qqs_count_5);
                break;
            case 6:
                qqs_checked = findViewById(R.id.qqs_count_6);
                break;
            case 7:
                qqs_checked = findViewById(R.id.qqs_count_7);
                break;
        }
        qqs_checked.setChecked(true);

        Integer num_count_value = Common.getValue(context,"paopao_num_columns",4);
        RadioButton num_checked = findViewById(R.id.num_count_4);
        switch (num_count_value){
            case 4:
                num_checked = findViewById(R.id.num_count_4);
                break;
            case 5:
                num_checked = findViewById(R.id.num_count_5);
                break;
            case 6:
                num_checked = findViewById(R.id.num_count_6);
                break;
            case 7:
                num_checked = findViewById(R.id.num_count_7);
                break;
        }
        num_checked.setChecked(true);

        Button quick_confirm = findViewById(R.id.quick_confirm);
        quick_confirm.setOnClickListener(new View.OnClickListener() {
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

        Integer qqs_count_value = 5;
        RadioGroup qqs_count = findViewById(R.id.qqs_count);
        int id = qqs_count.getCheckedRadioButtonId();
        switch (id){
            case R.id.qqs_count_4:
                qqs_count_value = 4;
                break;
            case R.id.qqs_count_5:
                qqs_count_value = 5;
                break;
            case R.id.qqs_count_6:
                qqs_count_value = 6;
                break;
            case R.id.qqs_count_7:
                qqs_count_value = 7;
                break;
        }
        Common.setValue(context,"paopao_qqs_count",qqs_count_value);

        Integer num_count_value = 4;
        RadioGroup num_count = findViewById(R.id.num_count);
        id = num_count.getCheckedRadioButtonId();
        switch (id){
            case R.id.num_count_4:
                num_count_value = 4;
                break;
            case R.id.num_count_5:
                num_count_value = 5;
                break;
            case R.id.num_count_6:
                num_count_value = 6;
                break;
            case R.id.num_count_7:
                num_count_value = 7;
                break;
        }
        Common.setValue(context,"paopao_num_columns",num_count_value);

    }
}
