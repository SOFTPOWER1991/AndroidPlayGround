package com.rayootech.www.itemchooseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rayootech.www.itemchooseexample.bean.Person;

import org.geek.commonlib.utils.UIUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvChoose;
    private Button btnSingle, btnMutiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EventBus.getDefault().register(this);

        tvChoose = (TextView) findViewById(R.id.tv_choose);

        btnMutiple = (Button) findViewById(R.id.btn_multiple);
        btnMutiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIUtils.startActivity(MainActivity.this, MultipleChooseActivity.class);
            }
        });

        btnSingle = (Button) findViewById(R.id.btn_single);
        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIUtils.startActivity(MainActivity.this, SingleChooseActivity.class);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCall(Person person) {
        tvChoose.setText("您选择了：" + person.getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMCall(ArrayList<Person> persons) {
        String name = "";
        for (Person person : persons) {
            name += person.getName() + "，";
        }

        tvChoose.setText("您选择了：" + name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
