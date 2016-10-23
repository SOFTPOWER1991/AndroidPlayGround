package com.rayootech.www.aidlexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

import org.geek.commonlib.utils.L;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = MainActivity.class.getSimpleName();


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager iBookManager = IBookManager.Stub.asInterface(service);

            try {
                List<Book> list = iBookManager.getBookList();

                L.et(TAG, "query book list , list type:" + list.getClass().getCanonicalName());



                for (Book item : list){
                    L.et(TAG , "query book list , before add : " + item.toString());
                }


                Book newBook = new Book(3 , "Swift");
                iBookManager.addBook(newBook);

                List<Book> newList = iBookManager.getBookList();

                for (Book item : newList){
                    L.et(TAG , "query book list , after add : " + item.toString());
                }




            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this , BookManagerService.class);

        bindService(intent , serviceConnection , Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
