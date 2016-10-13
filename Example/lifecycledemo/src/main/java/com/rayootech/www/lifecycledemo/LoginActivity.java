package com.rayootech.www.lifecycledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.e(LoginActivity.class.getSimpleName() , "============onCreate");

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key", "value");

                intent.putExtras(bundle);

                intent.setClass(LoginActivity.this , MainAActivity.class);

                startActivity(intent);
            }
        });

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LoginActivity.class.getSimpleName() , "==========onRestart" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LoginActivity.class.getSimpleName() , "==============onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LoginActivity.class.getSimpleName() , "=============onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LoginActivity.class.getSimpleName() , "=============onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LoginActivity.class.getSimpleName() , "=============onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LoginActivity.class.getSimpleName() , "=============onDestroy");
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Intent intent1 = intent;

        Log.e("intent" , intent1.getExtras().getString("key"));
    }

}

