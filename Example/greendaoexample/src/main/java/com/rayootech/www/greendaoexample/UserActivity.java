/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rayootech.www.greendaoexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class UserActivity extends AppCompatActivity {

    private EditText editText;
    private View addNoteButton;


    private EditText edtUserid;
    private Button queryUserInfoBtn;

    private UserIMInfoDao userIMInfoDao;

    private Query<UserIMInfo> userIMInfoQuery;
    private UserInfoAdapter userInfoAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setUpViews();

        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        userIMInfoDao = daoSession.getUserIMInfoDao();

        // query all notes, sorted a-z by their text
        userIMInfoQuery = userIMInfoDao.queryBuilder().build();
        updateNotes();
    }

    private void updateNotes() {
        List<UserIMInfo> userIMInfos = userIMInfoQuery.list();
        userInfoAdapter.setNotes(userIMInfos);
    }

    protected void setUpViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNotes);
        //noinspection ConstantConditions
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userInfoAdapter = new UserInfoAdapter(userInfoClick);
        recyclerView.setAdapter(userInfoAdapter);

        queryUserInfoBtn = (Button) findViewById(R.id.btn_queryId);
        queryUserInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onQueryUserInfo();
            }
        });

        edtUserid = (EditText) findViewById(R.id.edt_queryId);

        addNoteButton = findViewById(R.id.buttonAdd);
        //noinspection ConstantConditions
        addNoteButton.setEnabled(false);

        editText = (EditText) findViewById(R.id.editTextNote);
        editText.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addUserInfo();
                    return true;
                }
                return false;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean enable = s.length() != 0;
                addNoteButton.setEnabled(enable);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void onQueryUserInfo() {

        String userId = edtUserid.getText().toString();

        UserIMInfo userImInfo = userIMInfoDao.queryBuilder().where(UserIMInfoDao.Properties.UserId.eq(userId)).build().unique();

        if (userImInfo == null) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, userImInfo.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    public void onAddButtonClick(View view) {
        addUserInfo();
    }

    private void addUserInfo() {
        String userid = editText.getText().toString();

        UserIMInfo userIMInfo = new UserIMInfo();
        userIMInfo.setUserId(userid + "");
        userIMInfo.setUserName("hha" + Math.random());
        userIMInfo.setDiease("肝疼");
        userIMInfo.setSex("女");
        userIMInfo.setIcon("icon==" + Math.random());

        userIMInfoDao.insert(userIMInfo);

        updateNotes();
    }


    UserInfoAdapter.UserInfoClick userInfoClick = new UserInfoAdapter.UserInfoClick() {

        @Override
        public void onNoteClick(int position) {
            UserIMInfo userIMInfo = userInfoAdapter.getUserInfo(position);

//            Long userId = userIMInfo.getId();
//
//            userIMInfoDao.deleteByKey(userId);

            updateNotes();

        }
    };
}