package com.rayootech.www.processexample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * File Description  :
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/10/17 15:12
 */

public class User implements Parcelable {

    private int age;
    private String name;
    private String sex;
    private boolean live;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.age);
        dest.writeString(this.name);
        dest.writeString(this.sex);
        dest.writeByte(this.live ? (byte) 1 : (byte) 0);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.age = in.readInt();
        this.name = in.readString();
        this.sex = in.readString();
        this.live = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
