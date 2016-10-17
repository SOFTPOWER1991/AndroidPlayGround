package org.geek.commonlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class UIUtils {
    public static void startActivity(Context context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class<?> cls,
                                     Bundle bundle) {

        if (context instanceof  Activity){
            Intent intent = new Intent();
            intent.setClass(context, cls);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }else{
            startActivityByApplication(context , cls , bundle);
        }

    }
    public static void startActivityByApplication(Context context, Class<?> cls,
                                     Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void closeActivity(Context context) {
        ((Activity) context).finish();
    }
}
