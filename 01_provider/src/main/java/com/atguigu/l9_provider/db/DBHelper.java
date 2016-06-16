package com.atguigu.l9_provider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shuwei on 2016/6/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, int version) {
        super(context, "android0410.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(_id integer not null primary key autoincrement,name varchar )");
        db.execSQL("insert into person (name) values('Tom')");
        db.execSQL("insert into person (name) values('Jerry')");
        db.execSQL("insert into person (name) values('LiLei')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
