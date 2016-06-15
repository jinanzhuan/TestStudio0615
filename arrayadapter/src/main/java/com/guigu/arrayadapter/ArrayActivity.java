package com.guigu.arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayActivity extends AppCompatActivity {

    private ListView lv_array_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        //1、获得控件对象。
        lv_array_layout = (ListView)findViewById(R.id.lv_array_layout);

        //2、设置数据
        String[] names={"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};

        //3、设置适配器。
        lv_array_layout.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, names));

    }
}
