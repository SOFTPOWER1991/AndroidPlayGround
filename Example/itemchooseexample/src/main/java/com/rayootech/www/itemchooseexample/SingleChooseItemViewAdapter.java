package com.rayootech.www.itemchooseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

public class SingleChooseItemViewAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Person> persons;

    private LayoutInflater inflater;


    public SingleChooseItemViewAdapter(Context context, ArrayList<Person> persons) {
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_bean_custom, null);

            holder = new ViewHolder();

            holder.singleChooseItemView = (SingleChooseItemView) view.findViewById(R.id.singleView);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        holder.singleChooseItemView.setName(persons.get(i).getName());

        return view;
    }

    class ViewHolder {
        SingleChooseItemView singleChooseItemView;
    }
}
