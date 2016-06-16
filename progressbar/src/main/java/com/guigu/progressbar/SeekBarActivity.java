package com.guigu.progressbar;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {
    SeekBar sb_bar_seek;
    TextView tv_bar_content;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);


        sb_bar_seek = (SeekBar) findViewById(R.id.sb_bar_seek);
        tv_bar_content = (TextView) findViewById(R.id.tv_bar_content);

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (i = 1; i <= 100; i++) {
                    sb_bar_seek.setProgress(i);
                    SystemClock.sleep(50);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(i<100){

                                tv_bar_content.setText("当前进度为："+i);

                            }else{
                                tv_bar_content.setText("进度更新完成！");

                            }
                        }
                    });
                }

            }
        }).start();
    }
}
