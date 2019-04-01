package com.example.administrator.paopaox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Context context = getApplicationContext();

        Integer time_layout_value = Common.getValue(context,"paopao_time_layout",0);
        RadioButton time_layout_checked = findViewById(R.id.time_layout_0);
        switch (time_layout_value){
            case 0:
                time_layout_checked = findViewById(R.id.time_layout_0);
                break;
            case 1:
                time_layout_checked = findViewById(R.id.time_layout_1);
                break;
        }
        time_layout_checked.setChecked(true);

        Button time_confirm = findViewById(R.id.time_confirm);
        time_confirm.setOnClickListener(new View.OnClickListener() {
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

        Integer time_layout_value = 0;
        String command = "sh /system/bin/PP_SystemUI_MR.sh";
        RadioGroup time_layout = findViewById(R.id.time_layout);
        int id = time_layout.getCheckedRadioButtonId();
        switch (id){
            case R.id.time_layout_0:
                time_layout_value = 0;
                command = "sh /system/bin/PP_SystemUI_MR.sh";
                break;
            case R.id.time_layout_1:
                time_layout_value = 1;
                command = "sh /system/bin/PP_SystemUI_IOS.sh";
                break;
        }
        Common.setValue(context,"paopao_time_layout",time_layout_value);
        CommandExecution.execCommand(command, true);
    }
}
