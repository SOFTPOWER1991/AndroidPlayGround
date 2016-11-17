package com.rayootech.www.itemchooseexample;

import com.rayootech.www.itemchooseexample.bean.Person;

import java.util.ArrayList;

/**
 * File Description  :
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/11/17 19:24
 */

public class MockList {

    public static ArrayList<Person> mockPersonList() {
        ArrayList<Person> list = new ArrayList<>();


        for (int index = 0; index < 20; index++) {
            Person person = new Person();

            person.setName("张生" + index);

            list.add(person);
        }

        return list;
    }
}
