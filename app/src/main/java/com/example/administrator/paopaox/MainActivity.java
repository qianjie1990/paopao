package com.example.administrator.paopaox;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check();
        checkPermission();
        new MyAsyncTask().execute(getPackageCodePath());
//        upgradeRootPermission(getPackageCodePath());

        LinearLayout go_status_time = findViewById(R.id.go_status_time);
        go_status_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, StatusTimeActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_status_hide = findViewById(R.id.go_status_hide);
        go_status_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, StatusHideActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_status_super = findViewById(R.id.go_status_super);
        go_status_super.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, StatusSuperActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_layout = findViewById(R.id.go_layout);
        go_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, LayoutActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_pull = findViewById(R.id.go_pull);
        go_pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PullActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_quick_setting = findViewById(R.id.go_quick_setting);
        go_quick_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, QuickSettingActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_dpi = findViewById(R.id.go_dpi);
        go_dpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DPIActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

//        LinearLayout go_donghua = findViewById(R.id.go_donghua);
//        go_donghua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent = new Intent();
//                    intent.setClass(MainActivity.this, DonghuaActivity.class);
//                    MainActivity.this.startActivity(intent);
//                } catch (Exception e) {
//
//                }
//            }
//        });

//        LinearLayout go_home = findViewById(R.id.go_home);
//        go_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent = new Intent();
//                    intent.setClass(MainActivity.this, HomeActivity.class);
//                    MainActivity.this.startActivity(intent);
//                } catch (Exception e) {
//
//                }
//            }
//        });

//        LinearLayout go_thermal = findViewById(R.id.go_thermal);
//        go_thermal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent = new Intent();
//                    intent.setClass(MainActivity.this, ThermalActivity.class);
//                    MainActivity.this.startActivity(intent);
//                } catch (Exception e) {
//
//                }
//            }
//        });

        LinearLayout go_ifw = findViewById(R.id.go_ifw);
        go_ifw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, IFWActivity.class);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

        LinearLayout go_wifi = findViewById(R.id.go_wifi);
        go_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("WIFI信息");
                    builder.setMessage(getWifi());

                    builder.create().show();
                } catch (Exception e) {

                }
            }
        });

//        LinearLayout go_mipush = findViewById(R.id.go_mipush);
//        go_mipush.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("提示");
//                    builder.setMessage("需安装两个应用，确认安装吗");
//                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Context context = getApplicationContext();
//                            boolean b = context.getPackageManager().canRequestPackageInstalls();
//                            if (b) {
//                                //安装应用
//                                File file = new File("/system/media/paopaox/MIPush/XiaomiServicePush.apk");
//                                installApk(context, file);
//
//                                file = new File("/system/media/paopaox/MIPush/XiaomiServiceFramework.apk");
//                                installApk(context, file);
//                            } else {
//                                //请求安装未知应用来源的权限
//                                Uri packageURI = Uri.parse("package:"+context.getPackageName());
//                                Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageURI);
//                                startActivityForResult(intent, 10012);
//                            }
//                        }
//                    });
//                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                    builder.setCancelable(false);
//                    builder.create().show();
//
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        LinearLayout go_paopao = findViewById(R.id.go_paopao);
        go_paopao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("https://weibo.com/u/1798825707");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } catch (Exception e) {

                }
            }
        });

//        Button go_rec = findViewById(R.id.go_rec);
//        go_rec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("提示");
//                    builder.setMessage("确认重启吗");
//                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            CommandExecution.execCommand("sh "+prefix+"/bin/PP_REC.sh", true);
//                        }
//                    });
//                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                    builder.setCancelable(false);
//                    builder.create().show();
//
//                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        Button go_fas = findViewById(R.id.go_fas);
//        go_fas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("提示");
//                    builder.setMessage("确认重启吗");
//                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            CommandExecution.execCommand("sh "+prefix+"/bin/PP_FAS.sh", true);
//                        }
//                    });
//                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                    builder.setCancelable(false);
//                    builder.create().show();
//
//                    Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            Context context = getApplicationContext();
//            if (resultCode == RESULT_OK && requestCode == 10012) {
//                //安装应用
//                File file = new File("/system/media/paopaox/MIPush/XiaomiServicePush.apk");
//                installApk(context, file);
//
//                file = new File("/system/media/paopaox/MIPush/XiaomiServiceFramework.apk");
//                installApk(context, file);
//            }
//        } catch (Exception e) {
//            Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void installApk(Context pContext,File file){
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        Uri _uri;
//        _uri = FileProvider.getUriForFile(pContext, pContext.getPackageName(), file);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setDataAndType(_uri, "application/vnd.android.package-archive");
//        pContext.startActivity(intent);
//    }

    public static boolean upgradeRootPermission(String pkgCodePath) {
        String cmd="chmod 777 " + pkgCodePath;
        CommandExecution.execCommand(cmd, true);
        return true;
    }

    public void check(){
        File file = new File("/system/xbin/paopao");
        if(file.exists()){
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("非法ROM");
        builder.setMessage("请使用PaoPao-ROM，谢谢");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    private void checkPermission() {
        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //用户已经拒绝过一次，再次弹出权限申请对话框需要给用户一个解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission
                    .WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "请开通相关权限，否则无法正常使用本应用！", Toast.LENGTH_SHORT).show();
            }
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);

        }
    }

    public String getWifi(){
        String str = "";
        try {
            String cmd="\\cp -f /data/misc/wifi/WifiConfigStore.xml /storage/emulated/0/wifi.txt";
            CommandExecution.execCommand(cmd, true);

            File file = new File("/storage/emulated/0/wifi.txt");
            if (!file.isDirectory()) {  //检查此路径名的文件是否是一个目录(文件夹)
                if (file.getName().endsWith("txt")) {//文件格式为""文件
                    try {
                        InputStream instream = new FileInputStream(file);
                        if (instream != null) {
                            InputStreamReader inputreader
                                    = new InputStreamReader(instream, "UTF-8");
                            BufferedReader buffreader = new BufferedReader(inputreader);
                            String line;
                            //分行读取
                            while ((line = buffreader.readLine()) != null) {
                                if(line.trim().contains("name=\"SSID\"")){
                                    String[] list = line.split("&quot;");
                                    str += "SSID："+new String(list[1])+"\n";
                                }
                                if(line.trim().contains("name=\"PreSharedKey\"")){
                                    String[] list = line.split("&quot;");
                                    str += "密码："+list[1]+"\n\n";
                                }
                            }
                            instream.close();//关闭输入流
                        }
                    } catch (java.io.FileNotFoundException e) {
                        Log.d("paopaox", "The File doesn't not exist.");
                    } catch (IOException e) {
                        Log.d("paopaox", e.getMessage());
                    }
                }
            }
            cmd="rm -rf /storage/emulated/0/wifi.txt";
            CommandExecution.execCommand(cmd, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }



    public static void dualSignal(SignalClusterView view){
        Context context = view.getContext();
        ContentResolver resolver = context.getContentResolver();
        String str = "paopao_statusbar_signal_3";
        int value = 0;
        value = Settings.System.getInt(resolver,str,value);
        boolean a = false;
        if(value==1){
            a = true;
        }
        view.mNotchEar = a;
        view.mNotchEarDual = a;
        view.mNotchEarDualEnable = a;
    }

    class MyAsyncTask extends AsyncTask<String,Integer,Boolean>{
        @Override
        protected Boolean doInBackground(String... params){
            String cmd="chmod 777 " + params[0];
            CommandExecution.execCommand(cmd, true);
            return true;
        }
    }
}
