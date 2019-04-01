package com.example.administrator.paopaox;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class Common {
    //public static final String prefix = "/system";//mix2s
    //public static final String prefix = "/system/system";//mix3
    public static Integer getValue(Context context, String name, Integer value){
        // 判断是否有WRITE_SETTINGS权限if(!Settings.System.canWrite(this))
        if (!Settings.System.canWrite(context)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                    Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            ContentResolver contentResolver = context.getContentResolver();
            return Settings.System.getInt(contentResolver, name, value);
        }
        return value;
    }
    public static void setValue(Context context, String name, Integer value){
        // 判断是否有WRITE_SETTINGS权限if(!Settings.System.canWrite(this))
        if (!Settings.System.canWrite(context)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                    Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            ContentResolver contentResolver = context.getContentResolver();
            Settings.System.putInt(contentResolver, name, value);
        }
    }
}
