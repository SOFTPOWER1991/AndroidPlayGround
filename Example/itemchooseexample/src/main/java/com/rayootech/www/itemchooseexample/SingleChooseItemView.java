package com.rayootech.www.itemchooseexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * File Description  : 单选item
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/11/17 20:12
 */

public class SingleChooseItemView extends RelativeLayout implements Checkable {

    private CheckBox checkBox;

    private TextView textView;

    public SingleChooseItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_bean, this, true);

        checkBox = (CheckBox) view.findViewById(R.id.checkBox);

        textView = (TextView) view.findViewById(R.id.tv_name);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    @Override
    public void setChecked(boolean b) {
        checkBox.setChecked(b);

    }

    @Override
    public boolean isChecked() {
        return checkBox.isChecked();
    }

    @Override
    public void toggle() {
        checkBox.toggle();
    }
}
