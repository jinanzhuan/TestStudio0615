package com.guigu.arrayadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void to_Array_List(View v) {
        Intent intent = new Intent(MainActivity.this, ArrayActivity.class);
        startActivity(intent);
    }

    public void to_Simple_List(View v) {
        Intent intent = new Intent(MainActivity.this, SimpleActivity.class);
        startActivity(intent);
    }

    public void to_Base_List(View v) {
        Intent intent = new Intent(MainActivity.this, BaseActivity.class);
        startActivity(intent);
    }
}
