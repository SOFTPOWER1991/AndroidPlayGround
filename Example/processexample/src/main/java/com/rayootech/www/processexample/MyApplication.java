package com.rayootech.www.processexample;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import org.geek.commonlib.utils.L;

/**
 * File Description  :
 *
 * @author : zhanggeng
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/10/16 17:38
 * @version     : v1.0
 * **************修订历史*************
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        int pid = android.os.Process.myPid();//获取进程pid
        String processName = "";
        ActivityManager am = (ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);//获取系统的ActivityManager服务
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()){
            if(appProcess.pid == pid){
                processName = appProcess.processName;
                break;
            }
        }


        L.et(MyApplication.class.getSimpleName() , processName + "====" + pid);
    }
}
