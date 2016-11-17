package com.rayootech.www.animationexample;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.tv);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_test);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "======view");

//                textView.startAnimation(animation);

                ObjectAnimator.ofFloat(textView, "translationY", textView.getHeight()).start();
            }
        });
    }
}
