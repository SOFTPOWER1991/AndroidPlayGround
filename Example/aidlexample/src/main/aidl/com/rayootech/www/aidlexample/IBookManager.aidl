// IBookManager.aidl
package com.rayootech.www.aidlexample;

// Declare any non-default types here with import statements

import com.rayootech.www.aidlexample.Book;

interface IBookManager {
   List<Book> getBookList();
   void addBook(in Book book);

   void registerListener(IOnNewBookArrivedListener listener);
   void unregisterListener(IOnNewBookArrivedListener unregisterListener);

}
