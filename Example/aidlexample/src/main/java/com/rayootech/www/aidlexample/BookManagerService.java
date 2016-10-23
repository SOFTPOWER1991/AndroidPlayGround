package com.rayootech.www.aidlexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookManagerService extends Service {

    private static final String TAG = BookManagerService.class.getSimpleName();
    private CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();

    private AtomicBoolean mIsServiceDestoryed = new AtomicBoolean(false);

//    private CopyOnWriteArrayList<IOnNewBookArrivedListener> listeners = new CopyOnWriteArrayList<>();




//    private Binder binder = new IBookManager.Stub(){
//
//        @Override
//        public List<Book> getBookList() throws RemoteException {
//            return books;
//        }
//
//        @Override
//        public void addBook(Book book) throws RemoteException {
//            books.add(book);
//        }
//    };

    private Binder binder = new IOnNewBookArrivedListener.Stub(){

        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {

        }
    };



    @Override
    public void onCreate() {
        super.onCreate();

        books.add(new Book(1 , "Android"));
        books.add(new Book(2 , "IOS"));

    }

    public BookManagerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
