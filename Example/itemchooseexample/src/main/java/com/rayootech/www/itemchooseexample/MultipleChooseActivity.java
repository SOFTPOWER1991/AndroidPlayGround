package com.rayootech.www.itemchooseexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.geek.commonlib.utils.UIUtils;
import org.greenrobot.eventbus.EventBus;

/**
 * File Description  : 多选
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/11/17 19:16
 */

public class MultipleChooseActivity extends AppCompatActivity {

    private Button button;

    private ListView listView;

    private MultipleListAdapter multipleListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multiple);

        button = (Button) findViewById(R.id.btn_sure_m);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(multipleListAdapter.getPersonsChoose());

                UIUtils.closeActivity(MultipleChooseActivity.this);
            }
        });

        listView = (ListView) findViewById(R.id.lv_multiple);

        multipleListAdapter = new MultipleListAdapter(this, MockList.mockPersonList());

        listView.setAdapter(multipleListAdapter);


    }
}
