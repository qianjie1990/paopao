package com.example.administrator.paopaox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThermalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermal);

        Button thermal_mr = findViewById(R.id.thermal_mr);
        thermal_mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_Thermal_MR.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button thermal_yh = findViewById(R.id.thermal_yh);
        thermal_yh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_Thermal_YH.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
