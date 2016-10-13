package com.rayootech.www.lifecycledemo;

import android.content.Intent;
import android.os.Bundle;
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

        Log.e(WelcomeActivity.class.getSimpleName() , "============onCreate");

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
        Log.e(WelcomeActivity.class.getSimpleName() , "==========onRestart" );
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
}
