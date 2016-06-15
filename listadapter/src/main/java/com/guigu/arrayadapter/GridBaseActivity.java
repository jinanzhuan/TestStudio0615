package com.guigu.arrayadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bean.Food;

public class GridBaseActivity extends AppCompatActivity {
    GridView gv_grid_layout;
    private List<Food> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_base);

        //1、获取控件对象
        gv_grid_layout = (GridView)findViewById(R.id.gv_grid_layout);
        //2、设置数据
        iniData();
        //3、设置适配器

        BaseAdapter adapter=new BaseAdapter() {
            class ViewHolder {
                ImageView image;
                TextView text;
            }

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
                if(convertView==null){
                    view=View.inflate(GridBaseActivity.this, R.layout.simple_list_layout, null);
                    ImageView iv_array_image = (ImageView) view.findViewById(R.id.iv_array_image);
                    TextView tv_array_content = (TextView) view.findViewById(R.id.tv_array_content);

                    holder=new ViewHolder();
                    holder.image=iv_array_image;
                    holder.text=tv_array_content;

                    view.setTag(holder);

                }else{
                    view=convertView;
                    holder= (ViewHolder) view.getTag();
                }

                holder.image.setImageResource(list.get(position).getImage());
                holder.text.setText(list.get(position).getContent());

                return view;
            }
        };

        gv_grid_layout.setAdapter(adapter);

        gv_grid_layout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GridBaseActivity.this, BaseItemActivity.class);
                intent.putExtra("image",list.get(position).getImage());
                intent.putExtra("content",list.get(position).getContent());
                startActivity(intent);
            }
        });

    }

    private void iniData() {
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
