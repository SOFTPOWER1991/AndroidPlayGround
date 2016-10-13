package com.rayootech.www.lifecycledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainAActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a);

        Log.e(MainAActivity.class.getSimpleName() , "============onCreate");

        button = (Button) findViewById(R.id.btn_a);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key", "value");

                intent.putExtras(bundle);

                intent.setClass(MainAActivity.this , LoginActivity.class);

                startActivity(intent);
            }
        });
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(MainAActivity.class.getSimpleName() , "==========onRestart" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(MainAActivity.class.getSimpleName() , "==============onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(MainAActivity.class.getSimpleName() , "=============onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(MainAActivity.class.getSimpleName() , "=============onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(MainAActivity.class.getSimpleName() , "=============onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(MainAActivity.class.getSimpleName() , "=============onDestroy");
    }

}
