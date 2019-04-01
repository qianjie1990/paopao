package com.example.administrator.paopaox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Context context = getApplicationContext();

        Integer home_layout_value = Common.getValue(context,"paopao_home_layout",1);
        RadioButton home_layout_checked = findViewById(R.id.home_layout_1);
        switch (home_layout_value){
            case 1:
                home_layout_checked = findViewById(R.id.home_layout_1);
                break;
            case 2:
                home_layout_checked = findViewById(R.id.home_layout_2);
                break;
            case 3:
                home_layout_checked = findViewById(R.id.home_layout_2);
                break;
            case 4:
                home_layout_checked = findViewById(R.id.home_layout_4);
                break;
            case 5:
                home_layout_checked = findViewById(R.id.home_layout_5);
                break;
            case 6:
                home_layout_checked = findViewById(R.id.home_layout_6);
                break;
            case 7:
                home_layout_checked = findViewById(R.id.home_layout_7);
                break;
        }
        home_layout_checked.setChecked(true);

        Button home_confirm = findViewById(R.id.home_confirm);
        home_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setCount();
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void setCount(){
        Context context = getApplicationContext();

        Integer home_layout_value = 1;
        String command = "sh /system/bin/PP_Home_4x6.sh";
        RadioGroup home_layout = findViewById(R.id.home_layout);
        int id = home_layout.getCheckedRadioButtonId();
        switch (id){
            case R.id.home_layout_1:
                home_layout_value = 1;
                command = "sh /system/bin/PP_Home_4x6.sh";
                break;
            case R.id.home_layout_2:
                home_layout_value = 2;
                command = "sh /system/bin/PP_Home_4x7.sh";
                break;
            case R.id.home_layout_3:
                home_layout_value = 3;
                command = "sh /system/bin/PP_Home_5x6.sh";
                break;
            case R.id.home_layout_4:
                home_layout_value = 4;
                command = "sh /system/bin/PP_Home_5x7.sh";
                break;
            case R.id.home_layout_5:
                home_layout_value = 5;
                command = "sh /system/bin/PP_Home_6x6.sh";
                break;
            case R.id.home_layout_6:
                home_layout_value = 6;
                command = "sh /system/bin/PP_Home_6x7.sh";
                break;
            case R.id.home_layout_7:
                home_layout_value = 7;
                command = "sh /system/bin/PP_Home_7x7.sh";
                break;
        }
        Common.setValue(context,"paopao_home_layout",home_layout_value);
        CommandExecution.execCommand(command, true);

    }
}
