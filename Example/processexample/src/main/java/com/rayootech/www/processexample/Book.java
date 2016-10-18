package com.rayootech.www.processexample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * File Description  :
 *
 * @author : zhanggeng
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/10/17 19:57
 * @version     : v1.0
 * **************修订历史*************
 */

public class Book implements Parcelable {
    public int bookId;
    public String bookName;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bookId);
        dest.writeString(this.bookName);
    }

    public Book() {
    }

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    protected Book(Parcel in) {
        this.bookId = in.readInt();
        this.bookName = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
