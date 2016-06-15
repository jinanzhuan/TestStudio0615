package com.guigu.arrayadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseItemActivity extends AppCompatActivity {
    ImageView iv_item_image;
    TextView tv_item_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_item);
        iv_item_image = (ImageView)findViewById(R.id.iv_item_image);
        tv_item_content = (TextView)findViewById(R.id.tv_item_content);

        Intent intent = getIntent();
        int image = intent.getIntExtra("image", R.drawable.f1);
        String content = intent.getStringExtra("content");

        iv_item_image.setImageResource(image);
        tv_item_content.setText(content);


    }
}
