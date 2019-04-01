package com.example.administrator.paopaox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DonghuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donghua);

        Button dh_yuansheng = findViewById(R.id.dh_yuansheng);
        dh_yuansheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_Android.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button dh_blur = findViewById(R.id.dh_blur);
        dh_blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_blur.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Button dh_dx8 = findViewById(R.id.dh_dx8);
//        dh_dx8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_dx8.sh", true);
//                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        Button dh_emui = findViewById(R.id.dh_emui);
//        dh_emui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_EMUI.sh", true);
//                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        Button dh_ios = findViewById(R.id.dh_ios);
//        dh_ios.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_IOS.sh", true);
//                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        Button dh_jiuwei = findViewById(R.id.dh_jiuwei);
//        dh_jiuwei.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_jiuwei.sh", true);
//                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        Button dh_chuizi = findViewById(R.id.dh_chuizi);
        dh_chuizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_Smartisan.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button dh_miui = findViewById(R.id.dh_miui);
        dh_miui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommandExecution.execCommand("sh /system/bin/PP_DongHua_MIUI.sh", true);
                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
