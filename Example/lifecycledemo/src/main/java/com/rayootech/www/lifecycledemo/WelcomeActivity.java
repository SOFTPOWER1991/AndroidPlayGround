package com.rayootech.www.lifecycledemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(WelcomeActivity.class.getSimpleName(), "============onCreate====" + dumpTaskAffinity());

        textView = (TextView) findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key", "value");

                intent.putExtras(bundle);

                intent.setClass(WelcomeActivity.this , LoginActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(WelcomeActivity.class.getSimpleName(), "==========onRestart=====" + dumpTaskAffinity());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(WelcomeActivity.class.getSimpleName() , "==============onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(WelcomeActivity.class.getSimpleName() , "=============onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(WelcomeActivity.class.getSimpleName() , "=============onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(WelcomeActivity.class.getSimpleName() , "=============onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(WelcomeActivity.class.getSimpleName() , "=============onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(WelcomeActivity.class.getSimpleName(), "=============onSaveInstanceState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Log.e(WelcomeActivity.class.getSimpleName(), "PersistableBundle=============onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.e(WelcomeActivity.class.getSimpleName(), "=============onRestoreInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        Log.e(WelcomeActivity.class.getSimpleName(), "PersistableBundle=============onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(WelcomeActivity.class.getSimpleName() + "newConfig", newConfig.orientation + "======");
    }

    protected String dumpTaskAffinity() {
        try {
            ActivityInfo info = this.getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);

            return info.taskAffinity;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return "==";
    }
}
