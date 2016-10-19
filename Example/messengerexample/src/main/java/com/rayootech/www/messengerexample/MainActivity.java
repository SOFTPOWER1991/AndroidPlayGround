package com.rayootech.www.messengerexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import org.geek.commonlib.utils.Constants;
import org.geek.commonlib.utils.L;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = MainActivity.class.getSimpleName();

    private Messenger messenger;

    private Messenger getReplyMessenger = new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case Constants.MSG_FROM_SERVER:
                    L.et(TAG , "receive msg from server:"  + msg.getData().getString("reply"));


                    break;
                default:
                    break;
            }
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);

            Message msg = Message.obtain(null , Constants.MSG_FROM_CLIENT);
            Bundle bundle = new Bundle();
            bundle.putString("msg" , "hello  server, my name is client  , come from client!");
            msg.setData(bundle);

            msg.replyTo = getReplyMessenger;

            try {
                messenger.send(msg);
            } catch (RemoteException e) {
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

        Intent intent = new Intent(this , MessengerService.class);
        bindService(intent , connection , Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindService(connection);


    }
}
