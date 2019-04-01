package com.example.administrator.paopaox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhouyou.view.seekbar.SignSeekBar;

public class DPIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpi);

        Context context = getApplicationContext();
        Integer dpi_value = Common.getValue(context,"paopao_dpi_value",440);
        SignSeekBar dpibar = findViewById(R.id.dpiseekbar);
        dpibar.setProgress(dpi_value);

        Button dpi_default = findViewById(R.id.dpi_default);
        dpi_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SignSeekBar dpibar = findViewById(R.id.dpiseekbar);
                    dpibar.setProgress(440);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button dpi_confirm = findViewById(R.id.dpi_confirm);
        dpi_confirm.setOnClickListener(new View.OnClickListener() {
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

    public void setCount() {
        Context context = getApplicationContext();
        SignSeekBar dpibar = findViewById(R.id.dpiseekbar);
        Integer dpi_value = dpibar.getProgress();
        Common.setValue(context,"paopao_dpi_value",dpi_value);
        String command = "wm density "+dpi_value;
        CommandExecution.execCommand(command, true);
    }
}
