package com.rayootech.www.glideexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int resourceId = R.mipmap.ic_launcher;

        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String internetUrl = "http://img2.3lian.com/2014/f5/135/d/92.jpg";

        Glide.with(this)
                .load(internetUrl)
                .into(targetImageView);
    }
}
