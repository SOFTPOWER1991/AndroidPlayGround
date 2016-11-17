package com.rayootech.www.itemchooseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.rayootech.www.itemchooseexample.bean.Person;

import org.geek.commonlib.utils.L;
import org.geek.commonlib.utils.UIUtils;
import org.greenrobot.eventbus.EventBus;

/**
 * File Description  : 单选
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/11/17 19:16
 */

public class SingleChooseActivity extends AppCompatActivity {

    Button button;

    ListView listView;

    SingleListAdapter singleListAdapter;

//    SingleChooseItemViewAdapter singleChooseItemViewAdapter;
    private int selectPosition = -1;//用于记录用户选择的变量

    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single);


        button = (Button) findViewById(R.id.btn_sure);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(person);
                UIUtils.closeActivity(SingleChooseActivity.this);
            }
        });
        listView = (ListView) findViewById(R.id.lv_single);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        singleListAdapter = new SingleListAdapter(this, MockList.mockPersonList());

        listView.setAdapter(singleListAdapter);

//        singleChooseItemViewAdapter = new SingleChooseItemViewAdapter(this , MockList.mockPersonList());
//
//        listView.setAdapter(singleChooseItemViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                selectPosition = i;

                singleListAdapter.setSelectPosition(selectPosition);

                singleListAdapter.notifyDataSetChanged();


                L.et("item", "position==" + i + "===" + (singleListAdapter.getItem(i)).getName());

                person = singleListAdapter.getItem(i);


//                person = singleChooseItemViewAdapter.getItem(i);


            }
        });


    }
}
