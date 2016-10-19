package com.rayootech.www.messengerexample;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import org.geek.commonlib.utils.Constants;
import org.geek.commonlib.utils.L;

public class MessengerService extends Service {

    private static final String TAG = MessengerService.class.getSimpleName();

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case Constants.MSG_FROM_CLIENT:
                    L.et(TAG , "receive msg from client: ===" +  msg.getData().getString("msg"));

                    Messenger client = msg.replyTo;

                    Message replyMessage = Message.obtain(null , Constants.MSG_FROM_SERVER);

                    Bundle bundle = new Bundle();
                    bundle.putString("reply" , "hi , i have got you msg!");

                    replyMessage.setData(bundle);

                    try {
                        client.send(replyMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }


                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    private final Messenger messenger = new Messenger(new MessengerHandler());


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return messenger.getBinder();
    }
}
