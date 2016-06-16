package com.guigu.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toProgressBar(View v) {
        Intent intent = new Intent(MainActivity.this, ProgressBarActivity.class);
        startActivity(intent);
    }
    public void toSeekBar(View v) {
        Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
        startActivity(intent);
    }
}
