package com.guigu.arrayadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {
    ListView lv_simple_layout;
    private List<Map<String, Object>> list;
    private Map<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //1、获得控件对象。
        lv_simple_layout = (ListView)findViewById(R.id.lv_simple_layout);


        //2、设置数据。

        initData();

        //3、设置适配器。
        String[] from={"image","content"};
        int[] to={R.id.iv_array_image,R.id.tv_array_content};
        SimpleAdapter adapter=new SimpleAdapter(this,list,R.layout.simple_list_layout,from,to);

        lv_simple_layout.setAdapter(adapter);



    }

    private void initData() {
        list=new ArrayList<Map<String, Object>>();
        for (int i=0;i<10;i++){
            map = new HashMap<String,Object>();
            map.put("image", R.drawable.f1+i);
            map.put("content", "菜品" + (i+1));
            list.add(map);

        }




    }
}
