package com.guigu.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity_menu extends AppCompatActivity {
    RelativeLayout rl_main_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl_main_layout = (RelativeLayout)findViewById(R.id.rl_main_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //方式一、xml注册。
//        getMenuInflater().inflate(R.menu.menu,menu);

        //方式二、自己调用方法添加菜单项

 /*       menu.add("红色");
        menu.add("绿色");
        menu.add("黄色");
        menu.add("紫色");
        menu.add("黑色");*/

        menu.add(Menu.NONE,1,Menu.NONE,"红色");
        menu.add(Menu.NONE,2,Menu.NONE,"绿色");
        menu.add(Menu.NONE,3,Menu.NONE,"黄色");
        menu.add(Menu.NONE,4,Menu.NONE,"紫色");
        menu.add(Menu.NONE,5,Menu.NONE,"黑色");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

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
}
