package com.rayootech.www.itemchooseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rayootech.www.itemchooseexample.bean.Person;

import java.util.ArrayList;

/**
 * File Description  :
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/11/17 19:26
 */

public class SingleListAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Person> persons;

    private LayoutInflater inflater;

    private int selectPosition = -1;//用于记录用户选择的变量

    public SingleListAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setSelectPosition(int position){
        selectPosition = position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_bean, null);

            holder = new ViewHolder();

            holder.checkBox = (CheckBox) view.findViewById(R.id.checkBox);
            holder.tvName = (TextView) view.findViewById(R.id.tv_name);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        holder.tvName.setText(persons.get(i).getName());

        if (selectPosition == i){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(false);
        }

        return view;
    }

    class ViewHolder {

        CheckBox checkBox;
        TextView tvName;
    }
}
