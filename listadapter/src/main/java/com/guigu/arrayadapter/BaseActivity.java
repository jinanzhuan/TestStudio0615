package com.guigu.arrayadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bean.Food;

public class BaseActivity extends AppCompatActivity {
    ListView lv_base_layout;
    private List<Food> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //1、获得控件对象
            lv_base_layout = (ListView)findViewById(R.id.lv_base_layout);
        //2、设置数据

        initData();

        //3、设置适配器
        BaseAdapter adapter=new BaseAdapter() {

            private ImageView iv_array_image;

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view=null;
                ViewHolder holder=null;
                //1、如果convertView为空，则新建View对象及加载其对应的组件。
                if(convertView==null){
                    view=View.inflate(BaseActivity.this,R.layout.simple_list_layout,null);
                    holder=new ViewHolder();
                    iv_array_image = (ImageView) view.findViewById(R.id.iv_array_image);
                    TextView tv_array_content = (TextView) view.findViewById(R.id.tv_array_content);

                    holder.image=iv_array_image;
                    holder.text=tv_array_content;

                    Log.i("TAG", "view");
                    Log.i("TAG", "iv_array_image");
                    Log.i("TAG", "tv_array_content");

                    //利用view的属性，将holder保存到内存中。
                    view.setTag(holder);
                }else{//不为空的话，则利用缓冲的容器
                    view=convertView;
                    holder= (ViewHolder) view.getTag();
                }

                holder.image.setImageResource(list.get(position).getImage());
                holder.text.setText(list.get(position).getContent());

                return view;
            }

            //新建内部类，方便调用其中的方法和属性。
            class ViewHolder {
                ImageView image;
                TextView text;
            }
        };

        lv_base_layout.setAdapter(adapter);

        lv_base_layout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BaseActivity.this, BaseItemActivity.class);
                intent.putExtra("image",list.get(position).getImage());
                intent.putExtra("content",list.get(position).getContent());
                startActivity(intent);
            }
        });


    }

    private void initData() {
        list = new ArrayList<Food>();
        String[] contents={"菜品1","菜品2","菜品3","菜品4","菜品5","菜品6","菜品7","菜品8","菜品9","菜品10"};
        int[] images={R.drawable.f1,R.drawable.f2,R.drawable.f3
                ,R.drawable.f4,R.drawable.f5,R.drawable.f6,R.drawable.f7
                ,R.drawable.f8,R.drawable.f9,R.drawable.f10};
        for(int i=0;i<contents.length;i++){
            Food food=new Food(images[i],contents[i]);
            list.add(food);
        }

    }
}
