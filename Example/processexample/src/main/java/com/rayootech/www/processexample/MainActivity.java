package com.rayootech.www.processexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


        ClassLoader classLoader = getClassLoader();
        if (classLoader != null){
            L.et(MainActivity.class.getSimpleName(), "[onCreate] classLoader  1"  + " : " + classLoader.toString());
            while (classLoader.getParent()!=null){
                classLoader = classLoader.getParent();
                L.et(MainActivity.class.getSimpleName(),"[onCreate] classLoader 2"  + " : " + classLoader.toString());
            }
        }

        UserManager.sUserId = 2;

        L.et(MainActivity.class.getSimpleName() , UserManager.sUserId + "====");

        textView = (TextView) findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("main" , "main");

                UIUtils.startActivity(MainActivity.this, LoginActivity.class , bundle);
            }
        });


    }
}
