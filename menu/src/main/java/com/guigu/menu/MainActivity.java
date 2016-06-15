package com.guigu.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl_main_layout;
    TextView tv_main_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl_main_layout = (RelativeLayout)findViewById(R.id.rl_main_layout);
        tv_main_title = (TextView)findViewById(R.id.tv_main_title);

        //为组件注册快捷菜单。

       registerForContextMenu(tv_main_title);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //设置菜单项Id及菜单的名称
        menu.add(Menu.NONE,1,Menu.NONE,"红色");
        menu.add(Menu.NONE,2,Menu.NONE,"绿色");
        menu.add(Menu.NONE,3,Menu.NONE,"黄色");
        menu.add(Menu.NONE,4,Menu.NONE,"紫色");
        menu.add(Menu.NONE,5,Menu.NONE,"黑色");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //获取选中选项的Id
        int itemId = item.getItemId();

        //根据Id进行不同的处理

        switch (itemId) {
            case 1 :
                rl_main_layout.setBackgroundColor(Color.RED);
                break;
            case 2:
                rl_main_layout.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                rl_main_layout.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                rl_main_layout.setBackgroundColor(Color.MAGENTA);
                break;
            case 5:
                rl_main_layout.setBackgroundColor(Color.BLACK);
                break;
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //重写快捷菜单的回调方法，并设置菜单项的Id及标题
        menu.add(Menu.NONE, 1, Menu.NONE, "红色");
        menu.add(Menu.NONE, 2, Menu.NONE, "绿色");
        menu.add(Menu.NONE, 3, Menu.NONE, "黄色");
        menu.add(Menu.NONE, 4, Menu.NONE, "白色");
        menu.add(Menu.NONE, 5, Menu.NONE, "灰色");


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //根据选中的菜单获得其Id
        int itemId = item.getItemId();
        //根据Id进行不同的选择处理
        switch (itemId){
            case 1:
                tv_main_title.setText("红色");
                tv_main_title.setBackgroundColor(Color.RED);
                break;
            case 2:
                tv_main_title.setText("绿色");
                tv_main_title.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                tv_main_title.setText("黄色");
                tv_main_title.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                tv_main_title.setText("白色");
                tv_main_title.setBackgroundColor(Color.WHITE);
                break;
            case 5:
                tv_main_title.setText("灰色");
                tv_main_title.setBackgroundColor(Color.GRAY);
                break;
        }
        return true;
    }
}
