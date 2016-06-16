package com.guigu.progressbar;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar pb_bar_progress;
    TextView tv_bar_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb_bar_progress = (ProgressBar)findViewById(R.id.pb_bar_progress);
        tv_bar_content = (TextView)findViewById(R.id.tv_bar_content);

        new Thread(){

            private int i;

            @Override
            public void run() {
               for (i = 1; i <=100; i++){
                   pb_bar_progress.setProgress(i);
                   SystemClock.sleep(100);

                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           if(i<100){
                               tv_bar_content.setText("进度为："+ i);

                           }else{
                               tv_bar_content.setText("更新进度完成！");
                           }

                       }
                   });

               }
            }
        }.start();
    }
}
