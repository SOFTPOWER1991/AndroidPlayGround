package com.rayootech.www.mediarecordexample;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.geek.commonlib.utils.L;

import java.io.File;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnStop, btnPlay;

    MediaPlayer mPlayer;

    MediaRecorder mRecorder;


    String PATH = "";

    String mFileName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = new MediaPlayer();

        mRecorder = new MediaRecorder();

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVoice();
            }
        });

        btnStop = (Button) findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopVoice();
            }
        });

        btnPlay = (Button) findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVoice();
            }
        });
    }

    private void playVoice() {
        try {

//            if (mPlayer != null) {
//                mPlayer.reset();
//            } else {
//                mPlayer = new MediaPlayer();
//            }

//            mPlayer.reset();

            if (mPlayer == null) {
                mPlayer = new MediaPlayer();
                L.et("completion" , "mplayer is null");
            }else {
                mPlayer = new MediaPlayer();
                L.et("completion" , "mplayer isn't null");
            }

            PATH = Environment.getExternalStorageDirectory().getPath() + "/MyVoiceForder/Record/";

            File files = new File(PATH);
            File file = files.listFiles()[0];

            mPlayer.setDataSource(file.getAbsolutePath());
//            mPlayer.setDataSource(this, Uri.fromFile(file));

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    L.et("completion", "set on completion listener");
                    mPlayer.release();
                }
            });
            mPlayer.prepare();
            mPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


    /**
     * 开始录音
     */
    private void startVoice() {
        // 设置录音保存路径
        PATH = Environment.getExternalStorageDirectory().getPath() + "/MyVoiceForder/Record/";
        L.et("path", PATH);

        mFileName = PATH + UUID.randomUUID().toString() + ".amr";

        L.et("path", mFileName);

        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            L.et("ChatMessageActivity", "SD Card is not mounted,It is  "
                    + state + ".");
        }
        File directory = new File(mFileName).getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            L.et("ChatMessageActivity", "Path to file could not be created");
        }
        mRecorder = new MediaRecorder();
        mRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
            @Override
            public void onError(MediaRecorder mediaRecorder, int i, int i1) {
                L.et("error", "recorder voice error");
            }
        });
        mRecorder.setOnInfoListener(null);
        mRecorder.setPreviewDisplay(null);
        try {
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
            mRecorder.setOutputFile(mFileName);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.prepare();
            mRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 停止录音
     */
    private void stopVoice() {
        try {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

}
