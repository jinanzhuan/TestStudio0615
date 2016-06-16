package com.guigu.day01_contentprovider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView et_main_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_content = (TextView)findViewById(R.id.et_main_content);
    }

    public void selectcontacts(View v) {
        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1&&resultCode==RESULT_OK){
            String number = data.getStringExtra("number2");

            et_main_content.setText(number);

        }


    }
}
