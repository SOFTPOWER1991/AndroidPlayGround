package com.rayootech.www.processexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.geek.commonlib.utils.L;
import org.geek.commonlib.utils.UIUtils;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserManager.sUserId = 2;

        L.et(MainActivity.class.getSimpleName() , UserManager.sUserId + "====");

        textView = (TextView) findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtils.startActivity(MainActivity.this, LoginActivity.class);
            }
        });


    }
}
