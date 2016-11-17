package com.rayootech.www.itemchooseexample;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rayootech.www.itemchooseexample.bean.Person;

import java.util.ArrayList;

/**
 * File Description  : 多选
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/11/17 19:26
 */

public class MultipleListAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Person> persons;

    private LayoutInflater inflater;

    private int selectPosition = -1;//用于记录用户选择的变量

    // 用来控制CheckBox的选中状况
    private static SparseArray<Boolean> isSelected;

    private ArrayList<Person> personsChoose = new ArrayList<>();

    public MultipleListAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;

        isSelected = new SparseArray<Boolean>();

        initDate();

        inflater = LayoutInflater.from(context);
    }

    public static SparseArray<Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(SparseArray<Boolean> isSelected) {
        MultipleListAdapter.isSelected = isSelected;
    }

    // 初始化isSelected的数据
    private void initDate() {
        for (int i = 0; i < persons.size(); i++) {
            getIsSelected().put(i, false);
        }
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

    public ArrayList<Person> getPersonsChoose() {
        return personsChoose;
    }

    public void setPersonsChoose(ArrayList<Person> personsChoose) {
        this.personsChoose = personsChoose;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

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
        // 监听checkBox并根据原来的状态来设置新的状态
        holder.checkBox.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (isSelected.get(i)) {
                    isSelected.put(i, false);
                    setIsSelected(isSelected);
                    personsChoose.remove(persons.get(i));

                } else {
                    isSelected.put(i, true);
                    setIsSelected(isSelected);
                    personsChoose.add(persons.get(i));
                }

            }
        });

        // 根据isSelected来设置checkbox的选中状况

        holder.checkBox.setChecked(getIsSelected().get(i));

        return view;
    }

    class ViewHolder {

        CheckBox checkBox;
        TextView tvName;
    }
}
