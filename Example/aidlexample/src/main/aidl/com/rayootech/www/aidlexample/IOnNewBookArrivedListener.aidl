// IOnNewBookArrivedListener.aidl
package com.rayootech.www.aidlexample;

// Declare any non-default types here with import statements

import com.rayootech.www.aidlexample.Book;


interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}
