package com.dmp.downloadsongsparallel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    private static final String TAG = "DownloadSongs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        findViewById(R.id.button).setOnClickListener(view -> {
            for (String song:PlayList.songs) {
                DownloadSongs downloadSongs = new DownloadSongs(song);
                downloadSongs.start();

            }
        });
    }
    public class DownloadSongs extends Thread{
        private static final String TAG = "DownloadSongs";

        private final String song;
        public DownloadSongs(String song) {
            this.song = song;
        }

        @Override
        public void run() {
            downloadSongs();
        }
        private void downloadSongs(){

            textView.post(new Runnable() {
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    textView.append("Start download: :"+song+" downloading...\n");
                }
            });
            Log.d(TAG, "downloadSongs :"+song+" downloaded... ");

            SystemClock.sleep(3000);

            Log.d(TAG, "downloadSongs :"+song+" downloaded...");
            textView2.post(new Runnable() {
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    textView2.append("downloadSongs :"+song+" downloaded...\n");
                }
            });
        }


    }


}

