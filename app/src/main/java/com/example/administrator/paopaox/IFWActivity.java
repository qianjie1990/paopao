package com.example.administrator.paopaox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IFWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ifw);

        Button ifw_open = findViewById(R.id.ifw_open);
        ifw_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_IFW_Open.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button ifw_close = findViewById(R.id.ifw_close);
        ifw_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_IFW_Close.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
